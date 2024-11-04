package tbd.ayudantia2.persistence.repository;

import tbd.ayudantia2.persistence.entity.UsuarioEntity;

public interface UsuarioRepository {
    UsuarioEntity getUsuarioId(String username);
    void saveUsuario(UsuarioEntity usuario);
}
