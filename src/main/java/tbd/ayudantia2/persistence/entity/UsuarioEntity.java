package tbd.ayudantia2.persistence.entity;

import lombok.Data;

@Data
public class UsuarioEntity {
    private String username;
    private String password;
    private String email;
    private String rol;
}
