package tbd.ayudantia2.persistence.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Sql2o;
import tbd.ayudantia2.persistence.entity.UsuarioEntity;

@Repository
public class UsuarioRepositoryImp implements UsuarioRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public UsuarioEntity getUsuarioId(String username) {
        try (org.sql2o.Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM users WHERE username = :username")
                    .addParameter("username",username)
                    .executeAndFetchFirst(UsuarioEntity.class);
        }
    }

@Override
public void saveUsuario(UsuarioEntity usuario) {
    String sql = "INSERT INTO users (username, email, password, rol) VALUES (:username, :email, :password, :rol)";
    try (org.sql2o.Connection con = sql2o.open()) {
        con.createQuery(sql)
            .addParameter("username", usuario.getUsername())
            .addParameter("email", usuario.getEmail())
            .addParameter("password", usuario.getPassword())
            .addParameter("rol", usuario.getRol())
            .executeUpdate();
        }
    }
}
