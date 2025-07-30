package io.springboot.linverno.developer.dto.request;

import lombok.Data;

@Data
public class CreateAccessTokenRequest {

    private String refreshToken;

}
