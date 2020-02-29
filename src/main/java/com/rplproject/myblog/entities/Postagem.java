package com.rplproject.myblog.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "tab_post")
public class Postagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String subTitle;
    private String description;

    @Column(columnDefinition = "TEXT")
    private String text;
    private Boolean active;
    private LocalDateTime datePost;

    public Postagem(Long id, String title, String subTitle, String description, String text, Boolean active, LocalDateTime datePost) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.description = description;
        this.text = text;
        this.active = active;
        this.datePost = datePost;
    }

    public Postagem() {
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

    public static final class PostagemBuilder {
        private Postagem postagem;

        private PostagemBuilder() {
            postagem = new Postagem();
        }

        public static PostagemBuilder aPostagem() {
            return new PostagemBuilder();
        }

        public PostagemBuilder withId(Long id) {
            postagem.setId(id);
            return this;
        }

        public PostagemBuilder withTitle(String title) {
            postagem.setTitle(title);
            return this;
        }

        public PostagemBuilder withSubTitle(String subTitle) {
            postagem.setSubTitle(subTitle);
            return this;
        }

        public PostagemBuilder withDescription(String description) {
            postagem.setDescription(description);
            return this;
        }

        public PostagemBuilder withText(String text) {
            postagem.setText(text);
            return this;
        }

        public PostagemBuilder withActive(Boolean active) {
            postagem.setActive(active);
            return this;
        }

        public PostagemBuilder withDatePost(LocalDateTime datePost) {
            postagem.setDatePost(datePost);
            return this;
        }

        public Postagem build() {
            return postagem;
        }
    }
}
