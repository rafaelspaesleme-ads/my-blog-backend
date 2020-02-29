package com.rplproject.myblog.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tab_social_media")
public class SocialMedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private Long fkFollower;
    private Boolean active;

    public SocialMedia(Long id, String urlGitHub, String urlLinkedIn, String urlTwitter, String urlYouTube, String urlInstagram, String urlMySite, String urlPodCast, String urlMyBlog, Long fkPortolio, Long fkFollower, Boolean active) {
        this.id = id;
        this.urlGitHub = urlGitHub;
        this.urlLinkedIn = urlLinkedIn;
        this.urlTwitter = urlTwitter;
        this.urlYouTube = urlYouTube;
        this.urlInstagram = urlInstagram;
        this.urlMySite = urlMySite;
        this.urlPodCast = urlPodCast;
        this.urlMyBlog = urlMyBlog;
        this.fkPortolio = fkPortolio;
        this.fkFollower = fkFollower;
        this.active = active;
    }

    public SocialMedia() {
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

    public Long getFkFollower() {
        return fkFollower;
    }

    public void setFkFollower(Long fkFollower) {
        this.fkFollower = fkFollower;
    }

    public Long getFkPortolio() {
        return fkPortolio;
    }

    public void setFkPortolio(Long fkPortolio) {
        this.fkPortolio = fkPortolio;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public static final class SocialMediaBuilder {
        private SocialMedia socialMedia;

        private SocialMediaBuilder() {
            socialMedia = new SocialMedia();
        }

        public static SocialMediaBuilder aSocialMedia() {
            return new SocialMediaBuilder();
        }

        public SocialMediaBuilder withId(Long id) {
            socialMedia.setId(id);
            return this;
        }

        public SocialMediaBuilder withUrlGitHub(String urlGitHub) {
            socialMedia.setUrlGitHub(urlGitHub);
            return this;
        }

        public SocialMediaBuilder withUrlLinkedIn(String urlLinkedIn) {
            socialMedia.setUrlLinkedIn(urlLinkedIn);
            return this;
        }

        public SocialMediaBuilder withUrlTwitter(String urlTwitter) {
            socialMedia.setUrlTwitter(urlTwitter);
            return this;
        }

        public SocialMediaBuilder withUrlYouTube(String urlYouTube) {
            socialMedia.setUrlYouTube(urlYouTube);
            return this;
        }

        public SocialMediaBuilder withUrlInstagram(String urlInstagram) {
            socialMedia.setUrlInstagram(urlInstagram);
            return this;
        }

        public SocialMediaBuilder withUrlMySite(String urlMySite) {
            socialMedia.setUrlMySite(urlMySite);
            return this;
        }

        public SocialMediaBuilder withUrlPodCast(String urlPodCast) {
            socialMedia.setUrlPodCast(urlPodCast);
            return this;
        }

        public SocialMediaBuilder withUrlMyBlog(String urlMyBlog) {
            socialMedia.setUrlMyBlog(urlMyBlog);
            return this;
        }

        public SocialMediaBuilder withFkPortolio(Long fkPortolio) {
            socialMedia.setFkPortolio(fkPortolio);
            return this;
        }

        public SocialMediaBuilder withFkFollower(Long fkFollower) {
            socialMedia.setFkFollower(fkFollower);
            return this;
        }

        public SocialMediaBuilder withActive(Boolean active) {
            socialMedia.setActive(active);
            return this;
        }

        public SocialMedia build() {
            return socialMedia;
        }
    }
}
