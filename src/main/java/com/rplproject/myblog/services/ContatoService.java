package com.rplproject.myblog.services;

import com.rplproject.myblog.dto.ContatoDTO;
import com.rplproject.myblog.entities.Contato;
import com.rplproject.myblog.repositories.ContatoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ContatoService {

    private final ContatoRepository contatoRepository;

    public ContatoService(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    public Optional<ContatoDTO> findById(Long id) {
        Optional<Contato> contato = contatoRepository.findById(id);
        return buildContatoDTO(Objects.requireNonNull(contato.orElse(null)));
    }

    public Page<ContatoDTO> findByActive(Boolean active, Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        Page<Contato> contatos = contatoRepository.findAllByActive(active, pageRequest);
        return contatos.map(contato -> buildContatoDTO(contato).orElse(null));
    }

    protected Optional<ContatoDTO> buildContatoDTO(Contato contato) {
        return Optional.of(ContatoDTO.ContatoDTOBuilder.aContatoDTO()
                .withId(contato.getId())
                .withTitle(contato.getTitle())
                .withAddress(contato.getAddress())
                .withTypeContact(contato.getTypeContact())
                .withNameSemanticIcon(contato.getNameSemanticIcon())
                .withDatePost(contato.getDatePost())
                .withActive(contato.getActive())
                .build());
    }

    public Optional<ContatoDTO> save(ContatoDTO contatoDTO) {
        Contato contato = contatoRepository.save(Objects.requireNonNull(buildContato(contatoDTO).orElse(null)));
        return buildContatoDTO(contato);
    }

    protected Optional<Contato> buildContato(ContatoDTO contatoDTO){
        return Optional.of(Contato.ContatoBuilder.aContato()
                .withId(contatoDTO.getId())
                .withTitle(contatoDTO.getTitle())
                .withAddress(contatoDTO.getAddress())
                .withTypeContact(contatoDTO.getTypeContact())
                .withNameSemanticIcon(contatoDTO.getNameSemanticIcon())
                .withDatePost(LocalDateTime.now())
                .withActive(contatoDTO.getActive())
                .build());
    }

    public Optional<ContatoDTO> disable(ContatoDTO contatoDTO, Long id) {
        Optional<ContatoDTO> contatoById = findById(id);
        contatoById.ifPresent(contato -> {
            contatoRepository.save(Objects.requireNonNull(buildContato(contatoDTO).orElse(null)));
        });

        return contatoById;
    }

    public Boolean delete(Long id){
        Optional<ContatoDTO> byId = findById(id);
        byId.ifPresent(contatoDTO -> contatoRepository.deleteById(id));
        Optional<ContatoDTO> contatoById = findById(id);
        return !contatoById.isPresent();
    }

    public List<ContatoDTO> findAll() {
        return find();
    }

    protected List<ContatoDTO> find() {
        List<Contato> contatos = contatoRepository.findAll();
        List<ContatoDTO> contatoDTOList = new ArrayList<>();
        contatos.forEach(contato -> contatoDTOList.add(buildContatoDTO(contato).orElse(null)));
        return contatoDTOList;
    }

}
