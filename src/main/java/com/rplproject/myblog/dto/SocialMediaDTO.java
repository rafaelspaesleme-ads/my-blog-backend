package com.rplproject.myblog.dto;

import com.rplproject.myblog.entities.Seguidor;

import javax.persistence.OneToOne;

public class SocialMediaDTO {
    private Long id;
    private String urlGitHub;
    private String urlLinkedIn;
    private String urlTwitter;
    private String urlYouTube;
    private String urlInstagram;
    private String urlMySite;
    private String urlPodCast;
    private String urlMyBlog;
    private Long fkPortolio;
    private Seguidor seguidor;
    private Boolean active;

    public SocialMediaDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlGitHub() {
        return urlGitHub;
    }

    public void setUrlGitHub(String urlGitHub) {
        this.urlGitHub = urlGitHub;
    }

    public String getUrlLinkedIn() {
        return urlLinkedIn;
    }

    public void setUrlLinkedIn(String urlLinkedIn) {
        this.urlLinkedIn = urlLinkedIn;
    }

    public String getUrlTwitter() {
        return urlTwitter;
    }

    public void setUrlTwitter(String urlTwitter) {
        this.urlTwitter = urlTwitter;
    }

    public String getUrlYouTube() {
        return urlYouTube;
    }

    public void setUrlYouTube(String urlYouTube) {
        this.urlYouTube = urlYouTube;
    }

    public String getUrlInstagram() {
        return urlInstagram;
    }

    public void setUrlInstagram(String urlInstagram) {
        this.urlInstagram = urlInstagram;
    }

    public String getUrlMySite() {
        return urlMySite;
    }

    public void setUrlMySite(String urlMySite) {
        this.urlMySite = urlMySite;
    }

    public String getUrlPodCast() {
        return urlPodCast;
    }

    public void setUrlPodCast(String urlPodCast) {
        this.urlPodCast = urlPodCast;
    }

    public String getUrlMyBlog() {
        return urlMyBlog;
    }

    public void setUrlMyBlog(String urlMyBlog) {
        this.urlMyBlog = urlMyBlog;
    }

    public Long getFkPortolio() {
        return fkPortolio;
    }

    public void setFkPortolio(Long fkPortolio) {
        this.fkPortolio = fkPortolio;
    }

    public Seguidor getSeguidor() {
        return seguidor;
    }

    public void setSeguidor(Seguidor seguidor) {
        this.seguidor = seguidor;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public static final class SocialMediaDTOBuilder {
        private SocialMediaDTO socialMediaDTO;

        private SocialMediaDTOBuilder() {
            socialMediaDTO = new SocialMediaDTO();
        }

        public static SocialMediaDTOBuilder aSocialMediaDTO() {
            return new SocialMediaDTOBuilder();
        }

        public SocialMediaDTOBuilder withId(Long id) {
            socialMediaDTO.setId(id);
            return this;
        }

        public SocialMediaDTOBuilder withUrlGitHub(String urlGitHub) {
            socialMediaDTO.setUrlGitHub(urlGitHub);
            return this;
        }

        public SocialMediaDTOBuilder withUrlLinkedIn(String urlLinkedIn) {
            socialMediaDTO.setUrlLinkedIn(urlLinkedIn);
            return this;
        }

        public SocialMediaDTOBuilder withUrlTwitter(String urlTwitter) {
            socialMediaDTO.setUrlTwitter(urlTwitter);
            return this;
        }

        public SocialMediaDTOBuilder withUrlYouTube(String urlYouTube) {
            socialMediaDTO.setUrlYouTube(urlYouTube);
            return this;
        }

        public SocialMediaDTOBuilder withUrlInstagram(String urlInstagram) {
            socialMediaDTO.setUrlInstagram(urlInstagram);
            return this;
        }

        public SocialMediaDTOBuilder withUrlMySite(String urlMySite) {
            socialMediaDTO.setUrlMySite(urlMySite);
            return this;
        }

        public SocialMediaDTOBuilder withUrlPodCast(String urlPodCast) {
            socialMediaDTO.setUrlPodCast(urlPodCast);
            return this;
        }

        public SocialMediaDTOBuilder withUrlMyBlog(String urlMyBlog) {
            socialMediaDTO.setUrlMyBlog(urlMyBlog);
            return this;
        }

        public SocialMediaDTOBuilder withFkPortolio(Long fkPortolio) {
            socialMediaDTO.setFkPortolio(fkPortolio);
            return this;
        }

        public SocialMediaDTOBuilder withSeguidor(Seguidor seguidor) {
            socialMediaDTO.setSeguidor(seguidor);
            return this;
        }

        public SocialMediaDTOBuilder withActive(Boolean active) {
            socialMediaDTO.setActive(active);
            return this;
        }

        public SocialMediaDTO build() {
            return socialMediaDTO;
        }
    }
}
