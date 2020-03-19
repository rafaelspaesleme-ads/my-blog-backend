package com.rplproject.myblog.services;

import com.rplproject.myblog.dto.PortfolioDTO;
import com.rplproject.myblog.dto.ProfissaoDTO;
import com.rplproject.myblog.dto.SeguidorDTO;
import com.rplproject.myblog.dto.SocialMediaDTO;
import com.rplproject.myblog.entities.Portfolio;
import com.rplproject.myblog.entities.Seguidor;
import com.rplproject.myblog.entities.SocialMedia;
import com.rplproject.myblog.repositories.SocialMediaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SocialMediaService {
    private final SocialMediaRepository socialMediaRepository;
    private final SeguidorService seguidorService;

    public SocialMediaService(SocialMediaRepository socialMediaRepository, SeguidorService seguidorService) {
        this.socialMediaRepository = socialMediaRepository;
        this.seguidorService = seguidorService;
    }

    protected SocialMedia findById(Portfolio portfolio, SocialMediaDTO socialMediaDTO, SeguidorDTO seguidorDTO, ProfissaoDTO profissaoDTO){
        Long codigoSocialMedia = socialMediaDTO.getId();
        SocialMedia socialMedia = buildSocialMedia(portfolio, socialMediaDTO);
        if (codigoSocialMedia != null){
            return socialMediaRepository
                    .findById(codigoSocialMedia)
                    .orElse(socialMediaRepository.save(socialMedia));
        } else {
            SocialMedia socialMediaSave = socialMediaRepository.save(socialMedia);
            Seguidor seguidor = seguidorService.findById(seguidorDTO, socialMediaSave, profissaoDTO);
            Optional<SocialMedia> socialMediaUpdate = socialMediaRepository.findById(socialMediaSave.getId());
            SocialMedia socialMediaSaveDefinition;
            socialMediaSaveDefinition = socialMediaUpdate.map(media -> socialMediaRepository.save(buildUpdateSocialMedia(media, seguidor))).orElseGet(socialMediaUpdate::get);
            return socialMediaSaveDefinition;
        }

    }

    protected SocialMedia buildSocialMedia(Portfolio portfolio, SocialMediaDTO socialMediaDTO){
        return SocialMedia.SocialMediaBuilder.aSocialMedia()
                .withId(socialMediaDTO.getId())
                .withUrlGitHub(socialMediaDTO.getUrlGitHub())
                .withUrlLinkedIn(socialMediaDTO.getUrlLinkedIn())
                .withUrlTwitter(socialMediaDTO.getUrlTwitter())
                .withUrlYouTube(socialMediaDTO.getUrlYouTube())
                .withUrlInstagram(socialMediaDTO.getUrlInstagram())
                .withUrlMySite(socialMediaDTO.getUrlMySite())
                .withUrlPodCast(socialMediaDTO.getUrlPodCast())
                .withUrlMyBlog(socialMediaDTO.getUrlMyBlog())
                .withFkPortolio(portfolio.getId())
                .withActive(socialMediaDTO.getActive())
                .build();
    }

    protected SocialMedia buildUpdateSocialMedia(SocialMedia socialMedia, Seguidor seguidor){
        return SocialMedia.SocialMediaBuilder.aSocialMedia()
                .withId(socialMedia.getId())
                .withUrlGitHub(socialMedia.getUrlGitHub())
                .withUrlLinkedIn(socialMedia.getUrlLinkedIn())
                .withUrlTwitter(socialMedia.getUrlTwitter())
                .withUrlYouTube(socialMedia.getUrlYouTube())
                .withUrlInstagram(socialMedia.getUrlInstagram())
                .withUrlMySite(socialMedia.getUrlMySite())
                .withUrlPodCast(socialMedia.getUrlPodCast())
                .withUrlMyBlog(socialMedia.getUrlMyBlog())
                .withFkPortolio(socialMedia.getFkPortolio())
                .withSeguidor(seguidor)
                .withActive(socialMedia.getActive())
                .build();
    }
}
