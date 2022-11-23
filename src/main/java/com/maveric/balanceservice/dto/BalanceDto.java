package com.maveric.balanceservice.dto;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Currency;


@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
public class BalanceDto {
    private String  _id;
    @Valid
    @NotBlank(message = "Account Id is mandatory")
    private String accountId;
    @Valid
    @NotNull(message = "Amount is mandatory")
    @Min(value = 0,message = "Amount shouldn't be lesser than zero!")
    private Number amount;
    @Valid
    @NotNull(message = "Currency is mandatory")
    private Currency currency;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
