package com.rplproject.myblog.resources;

import com.rplproject.myblog.dto.PostagemDTO;
import com.rplproject.myblog.services.PostagemService;
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
@RequestMapping(value = "/api/blog/postagem")
public class PostagemResource {

    private final PostagemService postagemService;

    public PostagemResource(PostagemService postagemService) {
        this.postagemService = postagemService;
    }

    @CrossOrigin
    @GetMapping(value = "buscar/codigo/{id}")
    public ResponseEntity<PostagemDTO> findById(@Valid @PathVariable Long id) {
        Optional<PostagemDTO> postagemDTO = postagemService.findById(id);
        return ResponseEntity.ok().body(postagemDTO.orElse(null));
    }

    @CrossOrigin
    @GetMapping(value = "buscar/ativo/{active}")
    public ResponseEntity<Page<PostagemDTO>> findByActive(@Valid
                                                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                                                    @RequestParam(value = "size", defaultValue = "20") Integer linesPerPage,
                                                    @RequestParam(value = "orderBy", defaultValue = "datePost") String orderBy,
                                                    @RequestParam(value = "direction", defaultValue = "DESC") String direction,
                                                    @PathVariable Boolean active) {

        Page<PostagemDTO> postagemDTO = postagemService.findByActive(active, page, linesPerPage, orderBy, direction);
        return ResponseEntity.ok().body(postagemDTO);
    }

    @CrossOrigin
    @PostMapping(value = "salvar")
    public ResponseEntity<PostagemDTO> save(@Valid @RequestBody PostagemDTO postagemDTO) {
        Optional<PostagemDTO> postagem = postagemService.save(postagemDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(postagem.get().getId()).toUri();
        return ResponseEntity.created(uri).body(postagem.orElse(null));
    }

    @CrossOrigin
    @PutMapping(value = "desativar/{id}")
    public ResponseEntity<PostagemDTO> disable(@Valid
                                               @RequestBody PostagemDTO postagemDTO,
                                               @PathVariable Long id) {
        Optional<PostagemDTO> postagem = postagemService.disable(postagemDTO, id);
        return postagem.isPresent() ? ResponseEntity.ok().body(postagem.orElse(null)) : ResponseEntity.status(HttpStatus.NO_CONTENT).body(postagem.orElse(null));
    }

    @CrossOrigin
    @DeleteMapping(value = "deletar/{id}")
    public ResponseEntity<List<PostagemDTO>> delete(@Valid @PathVariable Long id) {
        Boolean delete = postagemService.delete(id);
        List<PostagemDTO> postagems = postagemService.findAll();
        return delete ? ResponseEntity.ok().body(postagems) : ResponseEntity.status(HttpStatus.NO_CONTENT).body(postagems);
    }
}
