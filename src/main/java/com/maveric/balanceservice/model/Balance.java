package com.maveric.balanceservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Currency;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Document(collection = "Balance")
public class Balance {
    @Id
    private String _id;
    private String accountId;
    private Number amount;
    private Currency currency;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
