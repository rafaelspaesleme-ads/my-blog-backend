package com.rplproject.myblog.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "tab_contacts")
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String address;
    private String nameSemanticIcon;
    private String typeContact;
    private Boolean active;
    private LocalDateTime datePost;

    public Contato() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNameSemanticIcon() {
        return nameSemanticIcon;
    }

    public void setNameSemanticIcon(String nameSemanticIcon) {
        this.nameSemanticIcon = nameSemanticIcon;
    }

    public String getTypeContact() {
        return typeContact;
    }

    public void setTypeContact(String typeContact) {
        this.typeContact = typeContact;
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

    public static final class ContatoBuilder {
        private Contato contato;

        private ContatoBuilder() {
            contato = new Contato();
        }

        public static ContatoBuilder aContato() {
            return new ContatoBuilder();
        }

        public ContatoBuilder withId(Long id) {
            contato.setId(id);
            return this;
        }

        public ContatoBuilder withTitle(String title) {
            contato.setTitle(title);
            return this;
        }

        public ContatoBuilder withAddress(String address) {
            contato.setAddress(address);
            return this;
        }

        public ContatoBuilder withNameSemanticIcon(String nameSemanticIcon) {
            contato.setNameSemanticIcon(nameSemanticIcon);
            return this;
        }

        public ContatoBuilder withTypeContact(String typeContact) {
            contato.setTypeContact(typeContact);
            return this;
        }

        public ContatoBuilder withActive(Boolean active) {
            contato.setActive(active);
            return this;
        }

        public ContatoBuilder withDatePost(LocalDateTime datePost) {
            contato.setDatePost(datePost);
            return this;
        }

        public Contato build() {
            return contato;
        }
    }
}
