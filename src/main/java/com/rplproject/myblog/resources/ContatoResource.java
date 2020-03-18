package com.rplproject.myblog.resources;

import com.rplproject.myblog.dto.ContatoDTO;
import com.rplproject.myblog.services.ContatoService;
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
@RequestMapping(value = "/api/blog/contato")
public class ContatoResource {
    private final ContatoService contatoService;

    public ContatoResource(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @CrossOrigin
    @GetMapping(value = "buscar/codigo/{id}")
    public ResponseEntity<ContatoDTO> findById(@Valid @PathVariable Long id) {
        Optional<ContatoDTO> contatoDTO = contatoService.findById(id);
        return ResponseEntity.ok().body(contatoDTO.orElse(null));
    }

    @CrossOrigin
    @GetMapping(value = "buscar/ativo/{active}")
    public ResponseEntity<Page<ContatoDTO>> findByActive(@Valid
                                                        @RequestParam(value = "page", defaultValue = "0") Integer page,
                                                        @RequestParam(value = "size", defaultValue = "20") Integer linesPerPage,
                                                        @RequestParam(value = "orderBy", defaultValue = "datePost") String orderBy,
                                                        @RequestParam(value = "direction", defaultValue = "DESC") String direction,
                                                        @PathVariable Boolean active) {
        Page<ContatoDTO> contatoDTOS = contatoService.findByActive(active, page, linesPerPage, orderBy, direction);
        return ResponseEntity.ok().body(contatoDTOS);
    }

    @CrossOrigin
    @PostMapping(value = "salvar")
    public ResponseEntity<ContatoDTO> save(@Valid @RequestBody ContatoDTO contatoDTO){
        Optional<ContatoDTO> contato = contatoService.save(contatoDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(contato.get().getId()).toUri();
        return ResponseEntity.created(uri).body(contato.orElse(null));
    }

    @CrossOrigin
    @PutMapping(value = "desativar/{id}")
    public ResponseEntity<ContatoDTO> disable(@Valid
                                             @RequestBody ContatoDTO contatoDTO,
                                             @PathVariable Long id) {
        Optional<ContatoDTO> contato = contatoService.disable(contatoDTO, id);
        return contato.isPresent()
                ? ResponseEntity.ok(contato.orElse(null))
                : ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(contato.orElse(null));
    }

    @CrossOrigin
    @DeleteMapping(value = "deletar/{id}")
    public ResponseEntity<List<ContatoDTO>> deletar(@Valid @PathVariable Long id){
        Boolean delete = contatoService.delete(id);
        List<ContatoDTO> contatos = contatoService.findAll();
        return delete
                ? ResponseEntity.ok(contatos)
                : ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(contatos);
    }
}
