package com.rplproject.myblog.dto;

import com.rplproject.myblog.entities.Profissao;
import com.rplproject.myblog.entities.SocialMedia;

import javax.persistence.*;

public class SeguidorDTO {
    private Long id;
    private String username;
    private String password;
    private String name;
    private String surname;
    private Profissao profissao;
    private String mail;
    private String whatsApp;
    private SocialMedia socialMedia;
    private String urlImageAvatar;
    private String about;
    private Boolean active;

    public SeguidorDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Profissao getProfissao() {
        return profissao;
    }

    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getWhatsApp() {
        return whatsApp;
    }

    public void setWhatsApp(String whatsApp) {
        this.whatsApp = whatsApp;
    }

    public SocialMedia getSocialMedia() {
        return socialMedia;
    }

    public void setSocialMedia(SocialMedia socialMedia) {
        this.socialMedia = socialMedia;
    }

    public String getUrlImageAvatar() {
        return urlImageAvatar;
    }

    public void setUrlImageAvatar(String urlImageAvatar) {
        this.urlImageAvatar = urlImageAvatar;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public static final class SeguidorDTOBuilder {
        private SeguidorDTO seguidorDTO;

        private SeguidorDTOBuilder() {
            seguidorDTO = new SeguidorDTO();
        }

        public static SeguidorDTOBuilder aSeguidorDTO() {
            return new SeguidorDTOBuilder();
        }

        public SeguidorDTOBuilder withId(Long id) {
            seguidorDTO.setId(id);
            return this;
        }

        public SeguidorDTOBuilder withUsername(String username) {
            seguidorDTO.setUsername(username);
            return this;
        }

        public SeguidorDTOBuilder withPassword(String password) {
            seguidorDTO.setPassword(password);
            return this;
        }

        public SeguidorDTOBuilder withName(String name) {
            seguidorDTO.setName(name);
            return this;
        }

        public SeguidorDTOBuilder withSurname(String surname) {
            seguidorDTO.setSurname(surname);
            return this;
        }

        public SeguidorDTOBuilder withProfissao(Profissao profissao) {
            seguidorDTO.setProfissao(profissao);
            return this;
        }

        public SeguidorDTOBuilder withMail(String mail) {
            seguidorDTO.setMail(mail);
            return this;
        }

        public SeguidorDTOBuilder withWhatsApp(String whatsApp) {
            seguidorDTO.setWhatsApp(whatsApp);
            return this;
        }

        public SeguidorDTOBuilder withSocialMedia(SocialMedia socialMedia) {
            seguidorDTO.setSocialMedia(socialMedia);
            return this;
        }

        public SeguidorDTOBuilder withUrlImageAvatar(String urlImageAvatar) {
            seguidorDTO.setUrlImageAvatar(urlImageAvatar);
            return this;
        }

        public SeguidorDTOBuilder withAbout(String about) {
            seguidorDTO.setAbout(about);
            return this;
        }

        public SeguidorDTOBuilder withActive(Boolean active) {
            seguidorDTO.setActive(active);
            return this;
        }

        public SeguidorDTO build() {
            return seguidorDTO;
        }
    }
}
