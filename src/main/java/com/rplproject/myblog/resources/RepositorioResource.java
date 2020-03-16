package com.rplproject.myblog.resources;

import com.rplproject.myblog.dto.RepositorioDTO;
import com.rplproject.myblog.services.RepositorioService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/blog/repositorio")
public class RepositorioResource {
    private final RepositorioService repositorioService;

    public RepositorioResource(RepositorioService repositorioService) {
        this.repositorioService = repositorioService;
    }

    @CrossOrigin
    @GetMapping(value = "buscar/codigo/{id}")
    public ResponseEntity<RepositorioDTO> findById(@Valid @PathVariable Long id) {
        Optional<RepositorioDTO> repositorioDTO = repositorioService.findById(id);
        return ResponseEntity.ok().body(repositorioDTO.orElse(null));
    }

    @CrossOrigin
    @GetMapping(value = "buscar/ativo/{active}")
    public ResponseEntity<Page<RepositorioDTO>> findByActive(@Valid
                                                        @RequestParam(value = "page", defaultValue = "0") Integer page,
                                                        @RequestParam(value = "size", defaultValue = "20") Integer linesPerPage,
                                                        @RequestParam(value = "orderBy", defaultValue = "datePost") String orderBy,
                                                        @RequestParam(value = "direction", defaultValue = "DESC") String direction,
                                                        @PathVariable Boolean active) {
        Page<RepositorioDTO> repositorioDTOS = repositorioService.findByActive(active, page, linesPerPage, orderBy, direction);
        return ResponseEntity.ok().body(repositorioDTOS);
    }

    @CrossOrigin
    @PostMapping(value = "salvar")
    public ResponseEntity<RepositorioDTO> save(@Valid @RequestBody RepositorioDTO repositorioDTO){
        Optional<RepositorioDTO> repositorio = repositorioService.save(repositorioDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(repositorio.get().getId()).toUri();
        return ResponseEntity.created(uri).body(repositorio.orElse(null));
    }

    @CrossOrigin
    @PutMapping(value = "desativar/{id}")
    public ResponseEntity<RepositorioDTO> disable(@Valid
                                             @RequestBody RepositorioDTO repositorioDTO,
                                             @PathVariable Long id) {
        Optional<RepositorioDTO> repositorio = repositorioService.disable(repositorioDTO, id);
        return repositorio.isPresent()
                ? ResponseEntity.ok(repositorio.orElse(null))
                : ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(repositorio.orElse(null));
    }

    @CrossOrigin
    @DeleteMapping(value = "deletar/{id}")
    public ResponseEntity<List<RepositorioDTO>> deletar(@Valid @PathVariable Long id){
        Boolean delete = repositorioService.delete(id);
        List<RepositorioDTO> repositorios = repositorioService.findAll();
        return delete
                ? ResponseEntity.ok(repositorios)
                : ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(repositorios);
    }
}
