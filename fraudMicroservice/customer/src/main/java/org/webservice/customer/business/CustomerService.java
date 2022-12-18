package org.webservice.customer.business;

import org.webservice.amqp.RabbitMQMessageProducer;
import org.webservice.clients.fraud.FraudCheckResponse;
import org.webservice.clients.fraud.FraudClient;
import org.webservice.clients.notification.NotificationClient;
import org.webservice.clients.notification.NotificationRequest;
import org.webservice.customer.presentation.CustomerRegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.webservice.customer.persistence.Customer;
import org.webservice.customer.persistence.CustomerRepository;

@Service
@AllArgsConstructor
public class CustomerService{
    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        //todo: check if email valid
        //todo: check if email not taken
        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("fraudster");
        }

        NotificationRequest notificationRequest = new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                String.format("Hi %s, welcome to anas ...",
                        customer.getFirstName())
        );

        rabbitMQMessageProducer.publish(
                notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key"
        );


    }
}
