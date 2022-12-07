package org.webservice.customer.presentation;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {

}
