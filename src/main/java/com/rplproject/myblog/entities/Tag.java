package com.rplproject.myblog.entities;

import javax.persistence.*;

@Entity(name = "tab_tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tagName;

    @ManyToOne
    @JoinColumn(name = "fk_forum")
    private Forum forum;

    @ManyToOne
    @JoinColumn(name = "fk_comentario")
    private Comentario comentario;
    private Boolean active;

    public Tag(Long id, String tagName, Forum forum, Comentario comentario, Boolean active) {
        this.id = id;
        this.tagName = tagName;
        this.forum = forum;
        this.comentario = comentario;
        this.active = active;
    }

    public Tag() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Forum getForum() {
        return forum;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public static final class TagBuilder {
        private Tag tag;

        private TagBuilder() {
            tag = new Tag();
        }

        public static TagBuilder aTag() {
            return new TagBuilder();
        }

        public TagBuilder withId(Long id) {
            tag.setId(id);
            return this;
        }

        public TagBuilder withTagName(String tagName) {
            tag.setTagName(tagName);
            return this;
        }

        public TagBuilder withForum(Forum forum) {
            tag.setForum(forum);
            return this;
        }

        public TagBuilder withComentario(Comentario comentario) {
            tag.setComentario(comentario);
            return this;
        }

        public TagBuilder withActive(Boolean active) {
            tag.setActive(active);
            return this;
        }

        public Tag build() {
            return tag;
        }
    }
}
