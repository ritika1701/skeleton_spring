package com.test.codes.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Document(collection = "exchangeList")
public class ExchangeProduct {

    @Id
    private String Id;

    @NonNull
    private String product_id;
    @NonNull
    private BigDecimal quoted_price;
    private String user_id = UUID.randomUUID().toString();
    private Boolean isValid = false;

}
