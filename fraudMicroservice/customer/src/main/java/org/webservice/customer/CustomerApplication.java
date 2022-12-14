package org.webservice.customer;

import org.springframework.boot.SpringApplication;
import org.springframework .boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@SpringBootApplication(
        scanBasePackages = {
                "org.webservice.customer",
                "org.webservice.amqp",
        }
)
@EnableFeignClients(
        basePackages = "org.webservice.clients"
)
public class CustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}
