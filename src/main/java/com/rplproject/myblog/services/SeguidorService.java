package com.rplproject.myblog.services;

import com.rplproject.myblog.dto.PortfolioDTO;
import com.rplproject.myblog.dto.ProfissaoDTO;
import com.rplproject.myblog.dto.SeguidorDTO;
import com.rplproject.myblog.dto.SocialMediaDTO;
import com.rplproject.myblog.entities.Portfolio;
import com.rplproject.myblog.entities.Seguidor;
import com.rplproject.myblog.entities.SocialMedia;
import com.rplproject.myblog.repositories.SeguidorRepository;
import com.rplproject.myblog.repositories.SocialMediaRepository;
import org.springframework.stereotype.Service;

@Service
public class SeguidorService {
    private final SeguidorRepository seguidorRepository;
    private final SocialMediaRepository socialMediaRepository;
    private final ProfissaoService profissaoService;

    public SeguidorService(SeguidorRepository seguidorRepository, SocialMediaRepository socialMediaRepository, ProfissaoService profissaoService) {
        this.seguidorRepository = seguidorRepository;
        this.socialMediaRepository = socialMediaRepository;
        this.profissaoService = profissaoService;
    }

    protected Seguidor findById(SeguidorDTO seguidorDTO, SocialMedia socialMedia, ProfissaoDTO profissaoDTO){
        Seguidor seguidor = buildSeguidor(seguidorDTO, socialMedia, profissaoDTO);
        if (seguidorDTO.getId() != null){
            return seguidorRepository
                    .findById(seguidorDTO.getId())
                    .orElse(seguidorRepository.save(seguidor));
        } else {
            return seguidorRepository.save(seguidor);
        }
    }

    protected Seguidor buildSeguidor(SeguidorDTO seguidorDTO, SocialMedia socialMedia, ProfissaoDTO profissaoDTO){
        return Seguidor.SeguidorBuilder.aSeguidor()
                .withId(seguidorDTO.getId())
                .withUsername(seguidorDTO.getUsername())
                .withPassword(seguidorDTO.getPassword())
                .withName(seguidorDTO.getName())
                .withSurname(seguidorDTO.getSurname())
                .withProfissao(profissaoService.findById(profissaoDTO))
                .withMail(seguidorDTO.getMail())
                .withSocialMedia(socialMedia)
                .withWhatsApp(seguidorDTO.getWhatsApp())
                .withUrlImageAvatar(seguidorDTO.getUrlImageAvatar())
                .withAbout(seguidorDTO.getAbout())
                .withActive(seguidorDTO.getActive())
                .build();
    }
}
