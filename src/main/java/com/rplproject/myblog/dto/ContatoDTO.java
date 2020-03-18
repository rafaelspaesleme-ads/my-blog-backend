package com.rplproject.myblog.dto;

import java.time.LocalDateTime;

public class ContatoDTO {
    private Long id;
    private String title;
    private String address;
    private String nameSemanticIcon;
    private String typeContact;
    private Boolean active;
    private LocalDateTime datePost;

    public ContatoDTO() {
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

    public static final class ContatoDTOBuilder {
        private ContatoDTO contatoDTO;

        private ContatoDTOBuilder() {
            contatoDTO = new ContatoDTO();
        }

        public static ContatoDTOBuilder aContatoDTO() {
            return new ContatoDTOBuilder();
        }

        public ContatoDTOBuilder withId(Long id) {
            contatoDTO.setId(id);
            return this;
        }

        public ContatoDTOBuilder withTitle(String title) {
            contatoDTO.setTitle(title);
            return this;
        }

        public ContatoDTOBuilder withAddress(String address) {
            contatoDTO.setAddress(address);
            return this;
        }

        public ContatoDTOBuilder withNameSemanticIcon(String nameSemanticIcon) {
            contatoDTO.setNameSemanticIcon(nameSemanticIcon);
            return this;
        }

        public ContatoDTOBuilder withTypeContact(String typeContact) {
            contatoDTO.setTypeContact(typeContact);
            return this;
        }

        public ContatoDTOBuilder withActive(Boolean active) {
            contatoDTO.setActive(active);
            return this;
        }

        public ContatoDTOBuilder withDatePost(LocalDateTime datePost) {
            contatoDTO.setDatePost(datePost);
            return this;
        }

        public ContatoDTO build() {
            return contatoDTO;
        }
    }
}
