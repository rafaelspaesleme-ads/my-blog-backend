package com.rplproject.myblog.resources;

import com.rplproject.myblog.entities.Usuarios;
import com.rplproject.myblog.services.UsuariosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/usrxk")
public class UsuariosResource {
    private final UsuariosService usuariosService;

    public UsuariosResource(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @CrossOrigin
    @GetMapping(value = "usuario/codigo/{id}")
    public ResponseEntity<Usuarios> findById(@PathVariable Long id){
        Optional<Usuarios> usuarios = usuariosService.findById(id);
        return ResponseEntity.ok().body(usuarios.orElse(null));
    }

    @CrossOrigin
    @GetMapping(value = "usuario/espec/user/{usuario}")
    public ResponseEntity<List<Usuarios>> findByUsuario(@PathVariable String usuario){
        List<Usuarios> usuarios = usuariosService.findByUsuario(usuario);
        return ResponseEntity.ok().body(usuarios);
    }

    @CrossOrigin
    @GetMapping(value = "usuario/user/{usuario}")
    public ResponseEntity<List<Usuarios>> findByContemUsuario(@PathVariable String usuario){
        List<Usuarios> usuarios = usuariosService.findByContemUsuario(usuario);
        return ResponseEntity.ok().body(usuarios);
    }
}
