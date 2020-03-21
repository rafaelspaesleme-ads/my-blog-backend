package com.rplproject.myblog.services;

import com.rplproject.myblog.configurations.PasswordConfiguration;
import com.rplproject.myblog.configurations.ProfileUserConfiguration;
import com.rplproject.myblog.dto.UsuariosDTO;
import com.rplproject.myblog.entities.Usuarios;
import com.rplproject.myblog.exceptions.AuthorizationException;
import com.rplproject.myblog.repositories.UsuariosRepository;
import com.rplproject.myblog.secutiry.UsuariosSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService {
    private Boolean del;
    private final UsuariosRepository usuariosRepository;
    private final PasswordConfiguration passwordConfiguration;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UsuariosService(UsuariosRepository usuariosRepository, PasswordConfiguration passwordConfiguration, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usuariosRepository = usuariosRepository;
        this.passwordConfiguration = passwordConfiguration;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public Optional<Usuarios> findById(Long id){
        UsuariosSecurity usuariosSecurity = UserService.authenticated();
        if (usuariosSecurity == null && !usuariosSecurity.hasRole(ProfileUserConfiguration.ROLE_ADMIN) && !id.equals(usuariosSecurity.getId())){
            throw new AuthorizationException("Acesso negado.");
        }
        return usuariosRepository.findById(id);
    }

    public List<Usuarios> findByUsuario(String usuario){
        return usuariosRepository.findAllByUsuario(usuario);
    }

    public List<Usuarios> findByContemUsuario(String usuario){
        return usuariosRepository.findByContemUsuario(usuario);
    }

    public Usuarios save(UsuariosDTO usuariosDTO){
        usuariosDTO.setId(null);
        return usuariosRepository.save(buildUsuarios(usuariosDTO));
    }

    public Usuarios buildUsuarios(UsuariosDTO usuariosDTO){
        return Usuarios.UsuariosBuilder.anUsuarios()
                .withAtivo(usuariosDTO.getAtivo())
                .withId(usuariosDTO.getId())
                .withNome(usuariosDTO.getNome())
                .withUsuario(usuariosDTO.getUsuario())
                .withSenha(bCryptPasswordEncoder.encode(usuariosDTO.getSenha()))
                .withEmail(usuariosDTO.getEmail())
                .build();
    }

    public UsuariosDTO buildUsuariosDTO(Usuarios usuarios){
        return UsuariosDTO.UsuariosDTOBuilder.anUsuariosDTO()
                .withAtivo(usuarios.getAtivo())
                .withId(usuarios.getId())
                .withNome(usuarios.getNome())
                .withUsuario(usuarios.getUsuario())
                .withSenha(bCryptPasswordEncoder.encode(usuarios.getSenha()))
                .withEmail(usuarios.getEmail())
                .build();
    }
}
