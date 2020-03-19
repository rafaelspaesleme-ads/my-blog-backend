package com.rplproject.myblog.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "tab_comments")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_seguidor")
    private Seguidor fkSeguidor;

    @ManyToOne
    @JoinColumn(name = "fk_forum")
    private Forum forum;

    @Column(columnDefinition = "TEXT")
    private String description;
    private String urlImage;

    @JsonIgnore
    @OneToMany(mappedBy = "comentario")
    private List<Tag> tags;
    private Boolean active;
    private LocalDateTime datePublish;

    public Comentario(Long id, Seguidor fkSeguidor, Forum forum, String description, String urlImage, List<Tag> tags, LocalDateTime datePublish) {
        this.id = id;
        this.fkSeguidor = fkSeguidor;
        this.forum = forum;
        this.description = description;
        this.urlImage = urlImage;
        this.tags = tags;
        this.datePublish = datePublish;
    }

    public Comentario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Seguidor getFkSeguidor() {
        return fkSeguidor;
    }

    public void setFkSeguidor(Seguidor fkSeguidor) {
        this.fkSeguidor = fkSeguidor;
    }

    public Forum getForum() {
        return forum;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
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

    public LocalDateTime getDatePublish() {
        return datePublish;
    }

    public void setDatePublish(LocalDateTime datePublish) {
        this.datePublish = datePublish;
    }

    public static final class ComentarioBuilder {
        private Comentario comentario;

        private ComentarioBuilder() {
            comentario = new Comentario();
        }

        public static ComentarioBuilder aComentario() {
            return new ComentarioBuilder();
        }

        public ComentarioBuilder withId(Long id) {
            comentario.setId(id);
            return this;
        }

        public ComentarioBuilder withFkSeguidor(Seguidor fkSeguidor) {
            comentario.setFkSeguidor(fkSeguidor);
            return this;
        }

        public ComentarioBuilder withForum(Forum forum) {
            comentario.setForum(forum);
            return this;
        }

        public ComentarioBuilder withDescription(String description) {
            comentario.setDescription(description);
            return this;
        }

        public ComentarioBuilder withUrlImage(String urlImage) {
            comentario.setUrlImage(urlImage);
            return this;
        }

        public ComentarioBuilder withTags(List<Tag> tags) {
            comentario.setTags(tags);
            return this;
        }

        public ComentarioBuilder withActive(Boolean active) {
            comentario.setActive(active);
            return this;
        }

        public ComentarioBuilder withDatePublish(LocalDateTime datePublish) {
            comentario.setDatePublish(datePublish);
            return this;
        }

        public Comentario build() {
            return comentario;
        }
    }
}
