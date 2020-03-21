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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

    public Optional<UsuariosDTO> findById(Long id){
        UsuariosSecurity usuariosSecurity = UserService.authenticated();
        if (usuariosSecurity == null && !usuariosSecurity.hasRole(ProfileUserConfiguration.ROLE_ADMIN) && !id.equals(usuariosSecurity.getId())){
            throw new AuthorizationException("Acesso negado.");
        }
        return Optional.ofNullable(buildUsuariosDTO(Objects
                .requireNonNull(usuariosRepository.findById(id)
                        .orElse(null))));
    }

    public List<UsuariosDTO> findByUsuario(String usuario){
        List<Usuarios> allByUsuario = usuariosRepository.findAllByUsuario(usuario);
        List<UsuariosDTO> usuariosDTOS = new ArrayList<>();
        allByUsuario.forEach(usuarios -> {
            usuariosDTOS.add(buildUsuariosDTO(usuarios));
        });
        return usuariosDTOS;
    }

    public List<UsuariosDTO> findByContemUsuario(String usuario){
        List<Usuarios> byContemUsuario = usuariosRepository.findByContemUsuario(usuario);
        List<UsuariosDTO> usuariosDTOS = new ArrayList<>();
        byContemUsuario.forEach(usuarios -> {
            usuariosDTOS.add(buildUsuariosDTO(usuarios));
        });
        return usuariosDTOS;
    }

    public List<UsuariosDTO> findAll(){
        List<UsuariosDTO> usuariosDTOS = new ArrayList<>();
        usuariosRepository.findAll()
                .forEach(usuarios -> usuariosDTOS.add(buildUsuariosDTO(usuarios)));
        return usuariosDTOS;
    }

    public UsuariosDTO save(UsuariosDTO usuariosDTO){
        usuariosDTO.setId(null);
        return buildUsuariosDTO(usuariosRepository.save(buildUsuarios(usuariosDTO)));
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
                .withEmail(usuarios.getEmail())
                .build();
    }
}
