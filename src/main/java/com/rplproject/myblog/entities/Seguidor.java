package com.rplproject.myblog.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity(name = "tab_followers")
public class Seguidor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String name;
    private String surname;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "fk_profissao")
    private Profissao profissao;
    private String mail;
    private String whatsApp;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_social_media", referencedColumnName = "id")
    private SocialMedia socialMedia;
    private String urlImageAvatar;
    @Column(columnDefinition = "TEXT")
    private String about;
    private Boolean active;

    public Seguidor(Long id, String password, String name, String surname, Profissao profissao, String mail, String whatsApp, SocialMedia socialMedia, String urlImageAvatar, String about, Boolean active) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.profissao = profissao;
        this.mail = mail;
        this.whatsApp = whatsApp;
        this.socialMedia = socialMedia;
        this.urlImageAvatar = urlImageAvatar;
        this.about = about;
        this.active = active;
    }

    public Seguidor() {
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

    public static final class SeguidorBuilder {
        private Seguidor seguidor;

        private SeguidorBuilder() {
            seguidor = new Seguidor();
        }

        public static SeguidorBuilder aSeguidor() {
            return new SeguidorBuilder();
        }

        public SeguidorBuilder withId(Long id) {
            seguidor.setId(id);
            return this;
        }

        public SeguidorBuilder withUsername(String username) {
            seguidor.setUsername(username);
            return this;
        }

        public SeguidorBuilder withPassword(String password) {
            seguidor.setPassword(password);
            return this;
        }

        public SeguidorBuilder withName(String name) {
            seguidor.setName(name);
            return this;
        }

        public SeguidorBuilder withSurname(String surname) {
            seguidor.setSurname(surname);
            return this;
        }

        public SeguidorBuilder withProfissao(Profissao profissao) {
            seguidor.setProfissao(profissao);
            return this;
        }

        public SeguidorBuilder withMail(String mail) {
            seguidor.setMail(mail);
            return this;
        }

        public SeguidorBuilder withWhatsApp(String whatsApp) {
            seguidor.setWhatsApp(whatsApp);
            return this;
        }

        public SeguidorBuilder withSocialMedia(SocialMedia socialMedia) {
            seguidor.setSocialMedia(socialMedia);
            return this;
        }

        public SeguidorBuilder withUrlImageAvatar(String urlImageAvatar) {
            seguidor.setUrlImageAvatar(urlImageAvatar);
            return this;
        }

        public SeguidorBuilder withAbout(String about) {
            seguidor.setAbout(about);
            return this;
        }

        public SeguidorBuilder withActive(Boolean active) {
            seguidor.setActive(active);
            return this;
        }

        public Seguidor build() {
            return seguidor;
        }
    }
}
