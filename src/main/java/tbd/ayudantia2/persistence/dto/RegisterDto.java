package tbd.ayudantia2.persistence.dto;

import lombok.Data;

@Data
public class RegisterDto {
    private String username;
    private String email;
    private String password;
    private String rol;
}