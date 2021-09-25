package com.airtel.codes.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ExchangeResponse {

    private String userid;
    private String message;

}
