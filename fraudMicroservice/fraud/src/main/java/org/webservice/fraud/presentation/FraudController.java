package org.webservice.fraud.presentation;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.webservice.clients.fraud.FraudCheckResponse;
import org.webservice.fraud.business.FraudCheckService;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/fraud-check")
public class FraudController {

    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(
            @PathVariable("customerId") Integer customerId){
        boolean isFraudulentCustomer = fraudCheckService.
                isFraudulentCustomer(customerId);

        log.info("fraud check request for customer {}", customerId);
        return new FraudCheckResponse(isFraudulentCustomer);

    }
}
