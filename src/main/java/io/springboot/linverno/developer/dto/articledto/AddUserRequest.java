package io.springboot.linverno.developer.dto.articledto;

import lombok.Data;

@Data
public class AddUserRequest {

    private String email;
    private String password;

}
