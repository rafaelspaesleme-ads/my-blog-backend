package com.rplproject.myblog.services;

import com.rplproject.myblog.dto.*;
import com.rplproject.myblog.entities.Formacao;
import com.rplproject.myblog.entities.Portfolio;
import com.rplproject.myblog.entities.SocialMedia;
import com.rplproject.myblog.repositories.FormacaoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class FormacaoService {
    private final FormacaoRepository formacaoRepository;

    public FormacaoService(FormacaoRepository formacaoRepository) {
        this.formacaoRepository = formacaoRepository;
    }

    protected List<Formacao> findAll(PortfolioDTO portfolioDTO, Portfolio portfolio) {
        List<Formacao> formacoes = new ArrayList<>();
        portfolioDTO.getFormationsOrCourses().forEach(formacaoDTO ->
                formacoes.add(buildFormacao(formacaoDTO, portfolio)));
        return formacaoRepository.saveAll(formacoes);
    }

    protected List<FormacaoDTO> findAllDTO(List<Formacao> formacoes) {
        List<FormacaoDTO> formacoesDTO = new ArrayList<>();
        formacoes.forEach(formacao -> formacoesDTO.add(buildFormacaoDTO(formacao)));
        return formacoesDTO;
    }

    protected Formacao buildFormacao(FormacaoDTO formacaoDTO, Portfolio portfolio){
        return Formacao.FormacaoBuilder.aFormacao()
                .withId(formacaoDTO.getId())
                .withTitle(formacaoDTO.getTitle())
                .withInstitution(formacaoDTO.getInstitution())
                .withPortfolio(portfolio)
                .withDateInitial(formacaoDTO.getDateInitial())
                .withDateFinal(formacaoDTO.getDateFinal())
                .withTypeCourses(formacaoDTO.getTypeCourses())
                .withActive(formacaoDTO.getActive())
                .build();
    }

    protected FormacaoDTO buildFormacaoDTO(Formacao formacao){
        return FormacaoDTO.FormacaoDTOBuilder.aFormacaoDTO()
                .withId(formacao.getId())
                .withTitle(formacao.getTitle())
                .withInstitution(formacao.getInstitution())
                .withDateInitial(formacao.getDateInitial())
                .withDateFinal(formacao.getDateFinal())
                .withTypeCourses(formacao.getTypeCourses())
                .withActive(formacao.getActive())
                .build();
    }
}
