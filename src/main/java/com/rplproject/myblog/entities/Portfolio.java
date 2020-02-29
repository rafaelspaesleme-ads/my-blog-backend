package com.rplproject.myblog.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity(name = "tab_portfolio")
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
    private SocialMedia socialMedia;
    private List<Formacao> formations;
    private List<Formacao> courses;
    private List<Conhecimento> learnings;
    private Boolean active;

    public Portfolio(Long id, String urlImage, String title, String subTitle, String job, String whatsApp, String mail, String phone, SocialMedia socialMedia, List<Formacao> formations, List<Formacao> courses, List<Conhecimento> learnings, Boolean active) {
        this.id = id;
        this.urlImage = urlImage;
        this.title = title;
        this.subTitle = subTitle;
        this.job = job;
        this.whatsApp = whatsApp;
        this.mail = mail;
        this.phone = phone;
        this.socialMedia = socialMedia;
        this.formations = formations;
        this.courses = courses;
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

    public String getUrlWhatsApp() {
        return whatsApp;
    }

    public void setUrlWhatsApp(String whatsApp) {
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

    public List<Formacao> getFormations() {
        return formations;
    }

    public void setFormations(List<Formacao> formations) {
        this.formations = formations;
    }

    public List<Formacao> getCourses() {
        return courses;
    }

    public void setCourses(List<Formacao> courses) {
        this.courses = courses;
    }

    public List<Conhecimento> getLearning() {
        return learnings;
    }

    public void setLearning(List<Conhecimento> learnings) {
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

        public PortfolioBuilder withUrlWhatsApp(String whatsApp) {
            portfolio.setUrlWhatsApp(whatsApp);
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

        public PortfolioBuilder withFormations(List<Formacao> formations) {
            portfolio.setFormations(formations);
            return this;
        }

        public PortfolioBuilder withCourses(List<Formacao> courses) {
            portfolio.setCourses(courses);
            return this;
        }

        public PortfolioBuilder withLearning(List<Conhecimento> learnings) {
            portfolio.setLearning(learnings);
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
