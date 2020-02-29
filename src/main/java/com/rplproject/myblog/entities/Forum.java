package com.rplproject.myblog.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "tab_forum")
public class Forum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Seguidor fkSeguidor;
    private String title;
    private String urlImage;

    @Column(columnDefinition = "TEXT")
    private String description;
    private List<Tag> tags;
    private Boolean active;
    private LocalDateTime datePublish;

    @OneToMany(mappedBy = "tab_coment", cascade = CascadeType.ALL)
    private List<Comentario> comentarios;

    public Forum(Long id, Seguidor fkSeguidor, String title, String urlImage, String description, List<Tag> tags, Boolean active, LocalDateTime datePublish, List<Comentario> comentarios) {
        this.id = id;
        this.fkSeguidor = fkSeguidor;
        this.title = title;
        this.urlImage = urlImage;
        this.description = description;
        this.tags = tags;
        this.active = active;
        this.datePublish = datePublish;
        this.comentarios = comentarios;
    }

    public Forum() {
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

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public Seguidor getFkSeguidor() {
        return fkSeguidor;
    }

    public void setFkSeguidor(Seguidor fkSeguidor) {
        this.fkSeguidor = fkSeguidor;
    }

    public LocalDateTime getDatePublish() {
        return datePublish;
    }

    public void setDatePublish(LocalDateTime datePublish) {
        this.datePublish = datePublish;
    }

    public static final class ForumBuilder {
        private Forum forum;

        private ForumBuilder() {
            forum = new Forum();
        }

        public static ForumBuilder aForum() {
            return new ForumBuilder();
        }

        public ForumBuilder withId(Long id) {
            forum.setId(id);
            return this;
        }

        public ForumBuilder withFkSeguidor(Seguidor fkSeguidor) {
            forum.setFkSeguidor(fkSeguidor);
            return this;
        }

        public ForumBuilder withTitle(String title) {
            forum.setTitle(title);
            return this;
        }

        public ForumBuilder withUrlImage(String urlImage) {
            forum.setUrlImage(urlImage);
            return this;
        }

        public ForumBuilder withDescription(String description) {
            forum.setDescription(description);
            return this;
        }

        public ForumBuilder withTags(List<Tag> tags) {
            forum.setTags(tags);
            return this;
        }

        public ForumBuilder withActive(Boolean active) {
            forum.setActive(active);
            return this;
        }

        public ForumBuilder withDatePublish(LocalDateTime datePublish) {
            forum.setDatePublish(datePublish);
            return this;
        }

        public ForumBuilder withComentarios(List<Comentario> comentarios) {
            forum.setComentarios(comentarios);
            return this;
        }

        public Forum build() {
            return forum;
        }
    }
}
