package com.webservice.customer.business;

import com.webservice.customer.presentation.CustomerRegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.webservice.customer.persistence.Customer;
import com.webservice.customer.persistence.CustomerRepository;
import org.webservice.fraud.FraudCheckResponse;

@Service
@AllArgsConstructor
public class CustomerService{
    private final CustomerRepository customerRepository;

    public void registerCostumer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        //todo: check if email valid
        //todo: check if email not taken
        customerRepository.saveAndFlush(customer);
        //todo: check if customer is fraudster
        FraudCheckResponse fraudCheckResponse = new RestTemplate().getForObject(
                "http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );
//        if (fraudCheckResponse.isFraudster()){
//            throw new IllegalStateException("fraudulent");
//        }
        //todo: send notification

    }
}
