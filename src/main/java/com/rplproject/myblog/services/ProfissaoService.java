package com.rplproject.myblog.services;

import com.rplproject.myblog.dto.ProfissaoDTO;
import com.rplproject.myblog.entities.Profissao;
import com.rplproject.myblog.repositories.ProfissaoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfissaoService {
    private final ProfissaoRepository profissaoRepository;

    public ProfissaoService(ProfissaoRepository profissaoRepository) {
        this.profissaoRepository = profissaoRepository;
    }

    protected Profissao findById(ProfissaoDTO profissaoDTO){
        if (profissaoDTO.getId() != null){
            return profissaoRepository
                    .findById(profissaoDTO.getId())
                    .orElse(profissaoRepository.save(buildProfissao(profissaoDTO)));
        } else {
            return profissaoRepository.save(buildProfissao(profissaoDTO));
        }

    }

    protected Profissao buildProfissao(ProfissaoDTO profissaoDTO){
        return Profissao.ProfissaoBuilder.aProfissao()
                .withId(profissaoDTO.getId())
                .withTitle(profissaoDTO.getTitle())
                .withActive(profissaoDTO.getActive())
                .build();
    }
}
