package com.rplproject.myblog.services;

import com.rplproject.myblog.dto.*;
import com.rplproject.myblog.entities.Conhecimento;
import com.rplproject.myblog.entities.Portfolio;
import com.rplproject.myblog.entities.SocialMedia;
import com.rplproject.myblog.repositories.ConhecimentoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConhecimentoService {
    private final ConhecimentoRepository conhecimentoRepository;

    public ConhecimentoService(ConhecimentoRepository conhecimentoRepository) {
        this.conhecimentoRepository = conhecimentoRepository;
    }

    protected List<Conhecimento> findAll(PortfolioDTO portfolioDTO, Portfolio portfolio, SocialMedia socialMedia){
        List<Conhecimento> conhecimentos = new ArrayList<>();
        portfolioDTO.getLearnings().forEach(conhecimentoDTO ->
                conhecimentos.add(buildConhecimento(conhecimentoDTO, portfolio)));
        return conhecimentoRepository.saveAll(conhecimentos);
    }

    protected List<ConhecimentoDTO> findAllDTO(List<Conhecimento> conhecimentos){
        List<ConhecimentoDTO> conhecimentosDTOS = new ArrayList<>();
        conhecimentos.forEach(conhecimento -> conhecimentosDTOS.add(buildConhecimentoDTO(conhecimento)));
        return conhecimentosDTOS;
    }

    protected Conhecimento buildConhecimento(ConhecimentoDTO conhecimentoDTO, Portfolio portfolio){
        return Conhecimento.ConhecimentoBuilder.aConhecimento()
                .withId(conhecimentoDTO.getId())
                .withTitle(conhecimentoDTO.getTitle())
                .withLevel(conhecimentoDTO.getLevel())
                .withPortfolio(portfolio)
                .withActive(conhecimentoDTO.getActive())
                .build();
    }

    protected ConhecimentoDTO buildConhecimentoDTO(Conhecimento conhecimento){
        return ConhecimentoDTO.ConhecimentoDTOBuilder.aConhecimentoDTO()
                .withId(conhecimento.getId())
                .withTitle(conhecimento.getTitle())
                .withLevel(conhecimento.getLevel())
                .withActive(conhecimento.getActive())
                .build();
    }


}
