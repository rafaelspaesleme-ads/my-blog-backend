package com.rplproject.myblog.dto;

import javax.persistence.Column;
import java.time.LocalDateTime;

public class PostagemDTO {
    private Long id;
    private String title;
    private String subTitle;
    private String description;
    private String text;
    private Boolean active;
    private LocalDateTime datePost;

    public PostagemDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public static final class PostagemDTOBuilder {
        private PostagemDTO postagemDTO;

        private PostagemDTOBuilder() {
            postagemDTO = new PostagemDTO();
        }

        public static PostagemDTOBuilder aPostagemDTO() {
            return new PostagemDTOBuilder();
        }

        public PostagemDTOBuilder withId(Long id) {
            postagemDTO.setId(id);
            return this;
        }

        public PostagemDTOBuilder withTitle(String title) {
            postagemDTO.setTitle(title);
            return this;
        }

        public PostagemDTOBuilder withSubTitle(String subTitle) {
            postagemDTO.setSubTitle(subTitle);
            return this;
        }

        public PostagemDTOBuilder withDescription(String description) {
            postagemDTO.setDescription(description);
            return this;
        }

        public PostagemDTOBuilder withText(String text) {
            postagemDTO.setText(text);
            return this;
        }

        public PostagemDTOBuilder withActive(Boolean active) {
            postagemDTO.setActive(active);
            return this;
        }

        public PostagemDTOBuilder withDatePost(LocalDateTime datePost) {
            postagemDTO.setDatePost(datePost);
            return this;
        }

        public PostagemDTO build() {
            return postagemDTO;
        }
    }
}
