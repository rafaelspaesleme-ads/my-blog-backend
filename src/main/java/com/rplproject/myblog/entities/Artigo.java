package com.rplproject.myblog.entities;

import javax.persistence.*;

@Entity(name = "tab_articles")
public class Artigo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String urlImage;
    private String title;
    private String subTitle;
    private String description;

    @Column(columnDefinition = "TEXT")
    private String text;
    private Boolean active;

    public Artigo(Long id, String urlImage, String title, String subTitle, String description, String text, Boolean active) {
        this.id = id;
        this.urlImage = urlImage;
        this.title = title;
        this.subTitle = subTitle;
        this.description = description;
        this.text = text;
        this.active = active;
    }

    public Artigo() {
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

    public static final class ArtigoBuilder {
        private Artigo artigo;

        private ArtigoBuilder() {
            artigo = new Artigo();
        }

        public static ArtigoBuilder anArtigo() {
            return new ArtigoBuilder();
        }

        public ArtigoBuilder withId(Long id) {
            artigo.setId(id);
            return this;
        }

        public ArtigoBuilder withUrlImage(String urlImage) {
            artigo.setUrlImage(urlImage);
            return this;
        }

        public ArtigoBuilder withTitle(String title) {
            artigo.setTitle(title);
            return this;
        }

        public ArtigoBuilder withSubTitle(String subTitle) {
            artigo.setSubTitle(subTitle);
            return this;
        }

        public ArtigoBuilder withDescription(String description) {
            artigo.setDescription(description);
            return this;
        }

        public ArtigoBuilder withText(String text) {
            artigo.setText(text);
            return this;
        }

        public ArtigoBuilder withActive(Boolean active) {
            artigo.setActive(active);
            return this;
        }

        public Artigo build() {
            return artigo;
        }
    }
}
