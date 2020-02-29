package com.rplproject.myblog.services;

import com.rplproject.myblog.dto.PostagemDTO;
import com.rplproject.myblog.entities.Postagem;
import com.rplproject.myblog.repositories.PostagemRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class PostagemService {
    private final PostagemRepository postagemRepository;

    public PostagemService(PostagemRepository postagemRepository) {
        this.postagemRepository = postagemRepository;
    }

    public Optional<PostagemDTO> findById(Long id){
        Postagem postagem = postagemRepository.findById(id).orElse(null);
        return Optional.of(buildPostagemDTO(postagem));
    }

    public Page<PostagemDTO> findByActive(Boolean active, Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        Page<Postagem> postagems = postagemRepository.findAllByActive(active, pageRequest);
        return postagems.map(this::buildPostagemDTO);
    }

    public Optional<PostagemDTO> save(PostagemDTO postagemDTO){
        Postagem postagem = postagemRepository.save(buildPostagem(postagemDTO));
        return Optional.of(buildPostagemDTO(postagem));
    }

    public Optional<PostagemDTO> disable(PostagemDTO postagemDTO, Long id){
        Optional<PostagemDTO> postagem = findById(id);
        postagem.ifPresent(post -> postagemRepository.save(buildPostagem(postagemDTO)));
        return postagem;
    }

    public Boolean delete(Long id){
        Optional<PostagemDTO> byId = findById(id);
        byId.ifPresent(post -> postagemRepository.deleteById(id));
        Optional<PostagemDTO> newById = findById(id);
        return !newById.isPresent();

    }

    public List<PostagemDTO> findAll(){
        List<Postagem> postagems = postagemRepository.findAll();
        List<PostagemDTO> postagemDTOS = new ArrayList<>();
        postagems.forEach(postagem -> postagemDTOS.add(buildPostagemDTO(postagem)));
        return postagemDTOS;
    }

    protected Postagem buildPostagem(PostagemDTO postagemDTO){
        return Postagem.PostagemBuilder.aPostagem()
                .withActive(postagemDTO.getActive())
                .withDatePost(postagemDTO.getDatePost())
                .withDescription(postagemDTO.getDescription())
                .withId(postagemDTO.getId())
                .withSubTitle(postagemDTO.getSubTitle())
                .withText(postagemDTO.getText())
                .withTitle(postagemDTO.getTitle())
                .build();
    }

    protected PostagemDTO buildPostagemDTO(Postagem postagem){
        return PostagemDTO.PostagemDTOBuilder.aPostagemDTO()
                .withActive(postagem.getActive())
                .withDescription(postagem.getDescription())
                .withId(postagem.getId())
                .withSubTitle(postagem.getSubTitle())
                .withText(postagem.getText())
                .withTitle(postagem.getTitle())
                .withDatePost(postagem.getDatePost())
                .build();
    }
}
