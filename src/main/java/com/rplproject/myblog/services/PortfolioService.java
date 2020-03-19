package com.rplproject.myblog.services;

import com.rplproject.myblog.dto.*;
import com.rplproject.myblog.entities.Conhecimento;
import com.rplproject.myblog.entities.Formacao;
import com.rplproject.myblog.entities.Portfolio;
import com.rplproject.myblog.entities.SocialMedia;
import com.rplproject.myblog.repositories.PortfolioRepository;
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
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;
    private final SocialMediaService socialMediaService;
    private final FormacaoService formacaoService;
    private final ConhecimentoService conhecimentoService;

    public PortfolioService(PortfolioRepository portfolioRepository, SocialMediaService socialMediaService, FormacaoService formacaoService, ConhecimentoService conhecimentoService) {
        this.portfolioRepository = portfolioRepository;
        this.socialMediaService = socialMediaService;
        this.formacaoService = formacaoService;
        this.conhecimentoService = conhecimentoService;
    }

    public Optional<PortfolioDTO> findById(Long id){
        Portfolio portfolio = portfolioRepository.findById(id).orElse(null);
        return Optional.of(buildPortfolioDTO(Objects.requireNonNull(portfolio)));
    }

    public Page<PortfolioDTO> findByActive(Boolean active, Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        Page<Portfolio> portfolios = portfolioRepository.findAllByActive(active, pageRequest);
        return portfolios.map(this::buildPortfolioDTO);
    }

    public Optional<PortfolioDTO> save(PortfolioDTO portfolioDTO, SocialMediaDTO socialMediaDTO, SeguidorDTO seguidorDTO, ProfissaoDTO profissaoDTO){
        Portfolio buildPortfolio = buildPortfolio(portfolioDTO);
        Portfolio portfolio;
        Optional<Portfolio> portfolioUpdate;
        Portfolio portfolioSaveDefinition;
        PortfolioDTO portfolioDTOUpdate = null;
        if (buildPortfolio.getId() != null){
            portfolioRepository.findById(buildPortfolio.getId()).orElse(portfolioRepository.save(buildPortfolio));
        } else {
            portfolio = portfolioRepository.save(buildPortfolio);
            SocialMedia socialMedia = socialMediaService.findById(portfolio, socialMediaDTO, seguidorDTO, profissaoDTO);
            List<Formacao> formacoes = formacaoService.findAll(portfolioDTO, portfolio);
            List<Conhecimento> conhecimentos = conhecimentoService.findAll(portfolioDTO, portfolio, socialMedia);
            portfolioUpdate = buildPortfolioUpdate(portfolio, socialMedia, formacoes, conhecimentos);
            portfolioSaveDefinition = portfolioUpdate.map(portfolioRepository::save).orElseGet(() -> portfolioRepository.save(portfolio));
            portfolioDTOUpdate = buildPortfolioDTO(portfolioSaveDefinition);
        }
        return Optional.of(Objects.requireNonNull(portfolioDTOUpdate));
    }

    public Optional<PortfolioDTO> disable(PortfolioDTO portfolioDTO, Long id){
        Optional<PortfolioDTO> portfolio = findById(id);
        portfolio.ifPresent(art -> portfolioRepository.save(buildPortfolio(portfolioDTO)));
        return portfolio;
    }

    public Boolean delete(Long id){
        Optional<PortfolioDTO> byId = findById(id);
        byId.ifPresent(portfolioDTO -> portfolioRepository.deleteById(id));
        Optional<PortfolioDTO> newById = findById(id);
        return !newById.isPresent();
    }

    public List<PortfolioDTO> findAll() {
        List<Portfolio> portfolios = portfolioRepository.findAll();
        List<PortfolioDTO> portfolioDTOS = new ArrayList<>();
        portfolios.forEach(portfolio -> portfolioDTOS.add(buildPortfolioDTO(portfolio)));
        return portfolioDTOS;
    }

    protected Portfolio buildPortfolio(PortfolioDTO portfolioDTO){
        return Portfolio.PortfolioBuilder.aPortfolio()
                .withId(portfolioDTO.getId())
                .withUrlImage(portfolioDTO.getUrlImage())
                .withTitle(portfolioDTO.getTitle())
                .withSubTitle(portfolioDTO.getSubTitle())
                .withJob(portfolioDTO.getJob())
                .withWhatsApp(portfolioDTO.getWhatsApp())
                .withMail(portfolioDTO.getMail())
                .withPhone(portfolioDTO.getPhone())
                .withActive(portfolioDTO.getActive())
                .withDatePost(LocalDateTime.now())
                .build();
    }

    protected PortfolioDTO buildPortfolioDTO(Portfolio portfolio){
        return PortfolioDTO.PortfolioDTOBuilder.aPortfolioDTO()
                .withId(portfolio.getId())
                .withUrlImage(portfolio.getUrlImage())
                .withTitle(portfolio.getTitle())
                .withSubTitle(portfolio.getSubTitle())
                .withJob(portfolio.getJob())
                .withWhatsApp(portfolio.getWhatsApp())
                .withMail(portfolio.getMail())
                .withPhone(portfolio.getPhone())
                .withSocialMedia(portfolio.getSocialMedia())
                .withFormationsOrCourses(formacaoService.findAllDTO(portfolio.getFormationsOrCourses()))
                .withLearnings(conhecimentoService.findAllDTO(portfolio.getLearnings()))
                .withActive(portfolio.getActive())
                .withDatePost(portfolio.getDatePost())
                .build();
    }

    protected Optional<Portfolio> buildPortfolioUpdate(Portfolio portfolio, SocialMedia socialMedia, List<Formacao> formacoes, List<Conhecimento> conhecimentos){
        return Optional.of(Portfolio.PortfolioBuilder.aPortfolio()
                .withId(portfolio.getId())
                .withUrlImage(portfolio.getUrlImage())
                .withTitle(portfolio.getTitle())
                .withSubTitle(portfolio.getSubTitle())
                .withJob(portfolio.getJob())
                .withWhatsApp(portfolio.getWhatsApp())
                .withMail(portfolio.getMail())
                .withPhone(portfolio.getPhone())
                .withSocialMedia(socialMedia)
                .withFormationsOrCourses(formacoes)
                .withLearnings(conhecimentos)
                .withActive(portfolio.getActive())
                .withDatePost(portfolio.getDatePost())
                .build());
    }
}
