package com.rplproject.myblog.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity(name = "tab_portfolios")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String urlImage;
    private String title;
    private String subTitle;
    private String job;
    private String whatsApp;
    private String mail;
    private String phone;

    @ManyToOne
    @JoinColumn(name = "fk_social_media")
    private SocialMedia socialMedia;

    @JsonIgnore
    @OneToMany(mappedBy = "portfolio")
    private List<Formacao> formationsOrCourses;

    @JsonIgnore
    @OneToMany(mappedBy = "portfolio")
    private List<Conhecimento> learnings;
    private Boolean active;

    public Portfolio(Long id, String urlImage, String title, String subTitle, String job, String whatsApp, String mail, String phone, SocialMedia socialMedia, List<Formacao> formationsOrCourses, List<Conhecimento> learnings, Boolean active) {
        this.id = id;
        this.urlImage = urlImage;
        this.title = title;
        this.subTitle = subTitle;
        this.job = job;
        this.whatsApp = whatsApp;
        this.mail = mail;
        this.phone = phone;
        this.socialMedia = socialMedia;
        this.formationsOrCourses = formationsOrCourses;
        this.learnings = learnings;
        this.active = active;
    }

    public Portfolio() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getWhatsApp() {
        return whatsApp;
    }

    public void setWhatsApp(String whatsApp) {
        this.whatsApp = whatsApp;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public SocialMedia getSocialMedia() {
        return socialMedia;
    }

    public void setSocialMedia(SocialMedia socialMedia) {
        this.socialMedia = socialMedia;
    }

    public List<Formacao> getFormationsOrCourses() {
        return formationsOrCourses;
    }

    public void setFormationsOrCourses(List<Formacao> formationsOrCourses) {
        this.formationsOrCourses = formationsOrCourses;
    }

    public List<Conhecimento> getLearnings() {
        return learnings;
    }

    public void setLearnings(List<Conhecimento> learnings) {
        this.learnings = learnings;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public static final class PortfolioBuilder {
        private Portfolio portfolio;

        private PortfolioBuilder() {
            portfolio = new Portfolio();
        }

        public static PortfolioBuilder aPortfolio() {
            return new PortfolioBuilder();
        }

        public PortfolioBuilder withId(Long id) {
            portfolio.setId(id);
            return this;
        }

        public PortfolioBuilder withUrlImage(String urlImage) {
            portfolio.setUrlImage(urlImage);
            return this;
        }

        public PortfolioBuilder withTitle(String title) {
            portfolio.setTitle(title);
            return this;
        }

        public PortfolioBuilder withSubTitle(String subTitle) {
            portfolio.setSubTitle(subTitle);
            return this;
        }

        public PortfolioBuilder withJob(String job) {
            portfolio.setJob(job);
            return this;
        }

        public PortfolioBuilder withWhatsApp(String whatsApp) {
            portfolio.setWhatsApp(whatsApp);
            return this;
        }

        public PortfolioBuilder withMail(String mail) {
            portfolio.setMail(mail);
            return this;
        }

        public PortfolioBuilder withPhone(String phone) {
            portfolio.setPhone(phone);
            return this;
        }

        public PortfolioBuilder withSocialMedia(SocialMedia socialMedia) {
            portfolio.setSocialMedia(socialMedia);
            return this;
        }

        public PortfolioBuilder withFormationsOrCourses(List<Formacao> formationsOrCourses) {
            portfolio.setFormationsOrCourses(formationsOrCourses);
            return this;
        }

        public PortfolioBuilder withLearnings(List<Conhecimento> learnings) {
            portfolio.setLearnings(learnings);
            return this;
        }

        public PortfolioBuilder withActive(Boolean active) {
            portfolio.setActive(active);
            return this;
        }

        public Portfolio build() {
            return portfolio;
        }
    }
}
