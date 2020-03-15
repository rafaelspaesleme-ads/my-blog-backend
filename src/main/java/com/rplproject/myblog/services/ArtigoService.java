package com.rplproject.myblog.services;

import com.rplproject.myblog.dto.ArtigoDTO;
import com.rplproject.myblog.entities.Artigo;
import com.rplproject.myblog.repositories.ArtigoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArtigoService {

    private final ArtigoRepository artigoRepository;

    public ArtigoService(ArtigoRepository artigoRepository) {
        this.artigoRepository = artigoRepository;
    }

    public Optional<ArtigoDTO> findById(Long id){
        Artigo artigo = artigoRepository.findById(id).orElse(null);
        return Optional.of(buildArtigoDTO(artigo));
    }

    public Page<ArtigoDTO> findByActive(Boolean active, Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        Page<Artigo> artigos = artigoRepository.findAllByActive(active, pageRequest);
        return artigos.map(this::buildArtigoDTO);
    }

    public Optional<ArtigoDTO> save(ArtigoDTO artigoDTO){
        Artigo artigo = artigoRepository.save(buildArtigo(artigoDTO));
        return Optional.of(buildArtigoDTO(artigo));
    }

    public Optional<ArtigoDTO> disable(ArtigoDTO artigoDTO, Long id){
        Optional<ArtigoDTO> artigo = findById(id);
        artigo.ifPresent(art -> artigoRepository.save(buildArtigo(artigoDTO)));
        return artigo;
    }

    public Boolean delete(Long id){
        Optional<ArtigoDTO> byId = findById(id);
        byId.ifPresent(artigoDTO -> artigoRepository.deleteById(id));
        Optional<ArtigoDTO> newById = findById(id);
        return !newById.isPresent();
    }

    public List<ArtigoDTO> findAll() {
        List<Artigo> artigos = artigoRepository.findAll();
        List<ArtigoDTO> artigoDTOS = new ArrayList<>();
        artigos.forEach(artigo -> artigoDTOS.add(buildArtigoDTO(artigo)));
        return artigoDTOS;
    }

    protected Artigo buildArtigo(ArtigoDTO artigoDTO){
        return Artigo.ArtigoBuilder.anArtigo()
                .withId(artigoDTO.getId())
                .withTitle(artigoDTO.getTitle())
                .withSubTitle(artigoDTO.getSubTitle())
                .withDescription(artigoDTO.getDescription())
                .withText(artigoDTO.getText())
                .withUrlImage(artigoDTO.getUrlImage())
                .withActive(artigoDTO.getActive())
                .withDatePost(LocalDateTime.now())
                .build();
    }

    protected ArtigoDTO buildArtigoDTO(Artigo artigo){
        return ArtigoDTO.ArtigoDTOBuilder.anArtigoDTO()
                .withId(artigo.getId())
                .withTitle(artigo.getTitle())
                .withSubTitle(artigo.getSubTitle())
                .withDescription(artigo.getDescription())
                .withText(artigo.getText())
                .withUrlImage(artigo.getUrlImage())
                .withActive(artigo.getActive())
                .withDatePost(artigo.getDatePost())
                .build();
    }
}
