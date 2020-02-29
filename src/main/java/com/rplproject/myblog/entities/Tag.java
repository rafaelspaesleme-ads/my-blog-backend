package com.rplproject.myblog.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tab_tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tagName;
    private Long fkForum;
    private Long fkComentario;
    private Boolean active;

    public Tag(Long id, String tagName, Long fkForum, Long fkComentario, Boolean active) {
        this.id = id;
        this.tagName = tagName;
        this.fkForum = fkForum;
        this.fkComentario = fkComentario;
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

    public Long getFkForum() {
        return fkForum;
    }

    public void setFkForum(Long fkForum) {
        this.fkForum = fkForum;
    }

    public Long getFkComentario() {
        return fkComentario;
    }

    public void setFkComentario(Long fkComentario) {
        this.fkComentario = fkComentario;
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

        public TagBuilder withFkForum(Long fkForum) {
            tag.setFkForum(fkForum);
            return this;
        }

        public TagBuilder withFkComentario(Long fkComentario) {
            tag.setFkComentario(fkComentario);
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
