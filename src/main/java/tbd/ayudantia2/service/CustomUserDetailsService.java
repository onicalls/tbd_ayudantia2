package tbd.ayudantia2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tbd.ayudantia2.persistence.entity.UsuarioEntity;
import tbd.ayudantia2.persistence.repository.UsuarioRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioEntity usuarioEntity = usuarioRepository.getUsuarioId(username);
        if (usuarioEntity == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return User.builder()
                .username(usuarioEntity.getUsername())
                .password(usuarioEntity.getPassword()) // Asegúrate de que la contraseña esté encriptada
                .roles(usuarioEntity.getRol())
                .build();
    }
}