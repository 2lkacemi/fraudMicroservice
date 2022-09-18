package org.webservice.fraud.business;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.webservice.fraud.persistence.FraudCheckHistory;
import org.webservice.fraud.persistence.FraudCheckHistoryRepository;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class FraudCheckService {

    private FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public boolean isFraudulentCustomer(Integer customerId){
        fraudCheckHistoryRepository.save(
                FraudCheckHistory
                        .builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }
}
