package com.rplproject.myblog.dto;

import java.time.LocalDateTime;

public class ArtigoDTO {
    private Long id;
    private String urlImage;
    private String title;
    private String subTitle;
    private String description;
    private String text;
    private Boolean active;
    private LocalDateTime datePost;

    public ArtigoDTO() {
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

    public static final class ArtigoDTOBuilder {
        private ArtigoDTO artigoDTO;

        private ArtigoDTOBuilder() {
            artigoDTO = new ArtigoDTO();
        }

        public static ArtigoDTOBuilder anArtigoDTO() {
            return new ArtigoDTOBuilder();
        }

        public ArtigoDTOBuilder withId(Long id) {
            artigoDTO.setId(id);
            return this;
        }

        public ArtigoDTOBuilder withUrlImage(String urlImage) {
            artigoDTO.setUrlImage(urlImage);
            return this;
        }

        public ArtigoDTOBuilder withTitle(String title) {
            artigoDTO.setTitle(title);
            return this;
        }

        public ArtigoDTOBuilder withSubTitle(String subTitle) {
            artigoDTO.setSubTitle(subTitle);
            return this;
        }

        public ArtigoDTOBuilder withDescription(String description) {
            artigoDTO.setDescription(description);
            return this;
        }

        public ArtigoDTOBuilder withText(String text) {
            artigoDTO.setText(text);
            return this;
        }

        public ArtigoDTOBuilder withActive(Boolean active) {
            artigoDTO.setActive(active);
            return this;
        }

        public ArtigoDTOBuilder withDatePost(LocalDateTime datePost) {
            artigoDTO.setDatePost(datePost);
            return this;
        }

        public ArtigoDTO build() {
            return artigoDTO;
        }
    }
}
