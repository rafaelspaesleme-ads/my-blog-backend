package com.rplproject.myblog.resources;

import com.rplproject.myblog.dto.ArtigoDTO;
import com.rplproject.myblog.services.ArtigoService;
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
@RequestMapping(value = "/api/blog/artigo")
public class ArtigoResource {
    private final ArtigoService artigoService;

    public ArtigoResource(ArtigoService artigoService) {
        this.artigoService = artigoService;
    }

    @CrossOrigin
    @GetMapping(value = "buscar/codigo/{id}")
    public ResponseEntity<ArtigoDTO> findById(@Valid @PathVariable Long id) {
        Optional<ArtigoDTO> artigoDTO = artigoService.findById(id);
        return ResponseEntity.ok().body(artigoDTO.orElse(null));
    }

    @CrossOrigin
    @GetMapping(value = "buscar/ativo/{active}")
    public ResponseEntity<Page<ArtigoDTO>> findByActive(@Valid
                                                        @RequestParam(value = "page", defaultValue = "0") Integer page,
                                                        @RequestParam(value = "size", defaultValue = "20") Integer linesPerPage,
                                                        @RequestParam(value = "orderBy", defaultValue = "datePost") String orderBy,
                                                        @RequestParam(value = "direction", defaultValue = "DESC") String direction,
                                                        @PathVariable Boolean active) {
        Page<ArtigoDTO> artigoDTOS = artigoService.findByActive(active, page, linesPerPage, orderBy, direction);
        return ResponseEntity.ok().body(artigoDTOS);
    }

    @CrossOrigin
    @PostMapping(value = "salvar")
    public ResponseEntity<ArtigoDTO> save(@Valid @RequestBody ArtigoDTO artigoDTO){
        Optional<ArtigoDTO> artigo = artigoService.save(artigoDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(artigo.get().getId()).toUri();
        return ResponseEntity.created(uri).body(artigo.orElse(null));
    }

    @CrossOrigin
    @PutMapping(value = "desativar/{id}")
    public ResponseEntity<ArtigoDTO> disable(@Valid
                                             @RequestBody ArtigoDTO artigoDTO,
                                             @PathVariable Long id) {
        Optional<ArtigoDTO> artigo = artigoService.disable(artigoDTO, id);
        return artigo.isPresent()
                ? ResponseEntity.ok(artigo.orElse(null))
                : ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(artigo.orElse(null));
    }

    @CrossOrigin
    @DeleteMapping(value = "deletar/{id}")
    public ResponseEntity<List<ArtigoDTO>> deletar(@Valid @PathVariable Long id){
        Boolean delete = artigoService.delete(id);
        List<ArtigoDTO> artigos = artigoService.findAll();
        return delete
                ? ResponseEntity.ok(artigos)
                : ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(artigos);
    }
}
