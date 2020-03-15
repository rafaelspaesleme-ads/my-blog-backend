package com.rplproject.myblog.resources;

import com.rplproject.myblog.dto.ComboPortfolioDTO;
import com.rplproject.myblog.dto.PortfolioDTO;
import com.rplproject.myblog.services.PortfolioService;
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
@RequestMapping(value = "/api/blog/portfolio")
public class PortfolioResource {
    private final PortfolioService portfolioService;

    public PortfolioResource(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @CrossOrigin
    @GetMapping(value = "buscar/codigo/{id}")
    public ResponseEntity<PortfolioDTO> findById(@Valid @PathVariable Long id) {
        Optional<PortfolioDTO> portfolioDTO = portfolioService.findById(id);
        return ResponseEntity.ok().body(portfolioDTO.orElse(null));
    }

    @CrossOrigin
    @GetMapping(value = "buscar/ativo/{active}")
    public ResponseEntity<Page<PortfolioDTO>> findByActive(@Valid
                                                        @RequestParam(value = "page", defaultValue = "0") Integer page,
                                                        @RequestParam(value = "size", defaultValue = "20") Integer linesPerPage,
                                                        @RequestParam(value = "orderBy", defaultValue = "datePost") String orderBy,
                                                        @RequestParam(value = "direction", defaultValue = "DESC") String direction,
                                                        @PathVariable Boolean active) {
        Page<PortfolioDTO> portfolioDTOS = portfolioService.findByActive(active, page, linesPerPage, orderBy, direction);
        return ResponseEntity.ok().body(portfolioDTOS);
    }

    @CrossOrigin
    @PostMapping(value = "salvar")
    public ResponseEntity<PortfolioDTO> save(@Valid @RequestBody ComboPortfolioDTO comboPortfolioDTO){
        Optional<PortfolioDTO> portfolio = portfolioService.save(comboPortfolioDTO.getPortfolioDTO(),
                        comboPortfolioDTO.getSocialMediaDTO(),
                        comboPortfolioDTO.getSeguidorDTO(),
                        comboPortfolioDTO.getProfissaoDTO());

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(portfolio.get().getId()).toUri();
        return ResponseEntity.created(uri).body(portfolio.orElse(null));
    }

    @CrossOrigin
    @PutMapping(value = "desativar/{id}")
    public ResponseEntity<PortfolioDTO> disable(@Valid
                                             @RequestBody ComboPortfolioDTO comboPortfolioDTO,
                                             @PathVariable Long id) {
        Optional<PortfolioDTO> portfolio = portfolioService.disable(comboPortfolioDTO.getPortfolioDTO(), id);

        return portfolio.isPresent()
                ? ResponseEntity.ok(portfolio.orElse(null))
                : ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(portfolio.orElse(null));
    }

    @CrossOrigin
    @DeleteMapping(value = "deletar/{id}")
    public ResponseEntity<List<PortfolioDTO>> deletar(@Valid @PathVariable Long id){
        Boolean delete = portfolioService.delete(id);
        List<PortfolioDTO> portfolios = portfolioService.findAll();
        return delete
                ? ResponseEntity.ok(portfolios)
                : ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(portfolios);
    }
}
