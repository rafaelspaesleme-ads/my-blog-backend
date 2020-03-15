package com.rplproject.myblog.dto;

import com.rplproject.myblog.entities.SocialMedia;

import java.time.LocalDateTime;
import java.util.List;

public class PortfolioDTO {
    private Long id;
    private String urlImage;
    private String title;
    private String subTitle;
    private String job;
    private String whatsApp;
    private String mail;
    private String phone;
    private SocialMedia socialMedia;
    private List<FormacaoDTO> formationsOrCourses;
    private List<ConhecimentoDTO> learnings;
    private Boolean active;
    private LocalDateTime datePost;

    public PortfolioDTO() {
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

    public List<FormacaoDTO> getFormationsOrCourses() {
        return formationsOrCourses;
    }

    public void setFormationsOrCourses(List<FormacaoDTO> formationsOrCourses) {
        this.formationsOrCourses = formationsOrCourses;
    }

    public List<ConhecimentoDTO> getLearnings() {
        return learnings;
    }

    public void setLearnings(List<ConhecimentoDTO> learnings) {
        this.learnings = learnings;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDateTime getDatePost() {
        return datePost;
    }

    public void setDatePost(LocalDateTime datePost) {
        this.datePost = datePost;
    }

    public static final class PortfolioDTOBuilder {
        private PortfolioDTO portfolioDTO;

        private PortfolioDTOBuilder() {
            portfolioDTO = new PortfolioDTO();
        }

        public static PortfolioDTOBuilder aPortfolioDTO() {
            return new PortfolioDTOBuilder();
        }

        public PortfolioDTOBuilder withId(Long id) {
            portfolioDTO.setId(id);
            return this;
        }

        public PortfolioDTOBuilder withUrlImage(String urlImage) {
            portfolioDTO.setUrlImage(urlImage);
            return this;
        }

        public PortfolioDTOBuilder withTitle(String title) {
            portfolioDTO.setTitle(title);
            return this;
        }

        public PortfolioDTOBuilder withSubTitle(String subTitle) {
            portfolioDTO.setSubTitle(subTitle);
            return this;
        }

        public PortfolioDTOBuilder withJob(String job) {
            portfolioDTO.setJob(job);
            return this;
        }

        public PortfolioDTOBuilder withWhatsApp(String whatsApp) {
            portfolioDTO.setWhatsApp(whatsApp);
            return this;
        }

        public PortfolioDTOBuilder withMail(String mail) {
            portfolioDTO.setMail(mail);
            return this;
        }

        public PortfolioDTOBuilder withPhone(String phone) {
            portfolioDTO.setPhone(phone);
            return this;
        }

        public PortfolioDTOBuilder withSocialMedia(SocialMedia socialMedia) {
            portfolioDTO.setSocialMedia(socialMedia);
            return this;
        }

        public PortfolioDTOBuilder withFormationsOrCourses(List<FormacaoDTO> formationsOrCourses) {
            portfolioDTO.setFormationsOrCourses(formationsOrCourses);
            return this;
        }

        public PortfolioDTOBuilder withLearnings(List<ConhecimentoDTO> learnings) {
            portfolioDTO.setLearnings(learnings);
            return this;
        }

        public PortfolioDTOBuilder withActive(Boolean active) {
            portfolioDTO.setActive(active);
            return this;
        }

        public PortfolioDTOBuilder withDatePost(LocalDateTime datePost) {
            portfolioDTO.setDatePost(datePost);
            return this;
        }

        public PortfolioDTO build() {
            return portfolioDTO;
        }
    }
}
