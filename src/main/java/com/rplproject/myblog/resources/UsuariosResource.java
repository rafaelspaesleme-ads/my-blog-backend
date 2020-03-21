package com.rplproject.myblog.resources;

import com.rplproject.myblog.dto.UsuariosDTO;
import com.rplproject.myblog.services.UsuariosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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
    public ResponseEntity<UsuariosDTO> findById(@PathVariable Long id){
        Optional<UsuariosDTO> usuarios = usuariosService.findById(id);
        return ResponseEntity.ok().body(usuarios.orElse(null));
    }

    @CrossOrigin
    @GetMapping(value = "usuario/espec/user/{usuario}")
    public ResponseEntity<List<UsuariosDTO>> findByUsuario(@PathVariable String usuario){
        List<UsuariosDTO> usuarios = usuariosService.findByUsuario(usuario);
        return ResponseEntity.ok().body(usuarios);
    }

    @CrossOrigin
    @GetMapping(value = "usuario/user/{usuario}")
    public ResponseEntity<List<UsuariosDTO>> findByContemUsuario(@PathVariable String usuario){
        List<UsuariosDTO> usuarios = usuariosService.findByContemUsuario(usuario);
        return ResponseEntity.ok().body(usuarios);
    }

    @CrossOrigin
    @PostMapping(value = "usuario/user/save")
    public ResponseEntity<List<UsuariosDTO>> saveRealTime(@Valid @RequestBody UsuariosDTO usuariosDTO){
        UsuariosDTO usuarios = usuariosService.save(usuariosDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(usuarios.getId()).toUri();
        List<UsuariosDTO> usuariosList = usuariosService.findAll();
        return ResponseEntity.created(uri).body(usuariosList);
    }
}
