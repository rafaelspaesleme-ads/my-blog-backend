package com.rplproject.myblog.dto;

import com.rplproject.myblog.entities.Repositorio;

public class ColaboradorDTO {
    private Long id;
    private String usernameGit;
    private Repositorio repositorio;
    private Boolean active;

    public ColaboradorDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsernameGit() {
        return usernameGit;
    }

    public void setUsernameGit(String usernameGit) {
        this.usernameGit = usernameGit;
    }

    public Repositorio getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public static final class ColaboradorDTOBuilder {
        private ColaboradorDTO colaboradorDTO;

        private ColaboradorDTOBuilder() {
            colaboradorDTO = new ColaboradorDTO();
        }

        public static ColaboradorDTOBuilder aColaboradorDTO() {
            return new ColaboradorDTOBuilder();
        }

        public ColaboradorDTOBuilder withId(Long id) {
            colaboradorDTO.setId(id);
            return this;
        }

        public ColaboradorDTOBuilder withUsernameGit(String usernameGit) {
            colaboradorDTO.setUsernameGit(usernameGit);
            return this;
        }

        public ColaboradorDTOBuilder withRepositorio(Repositorio repositorio) {
            colaboradorDTO.setRepositorio(repositorio);
            return this;
        }

        public ColaboradorDTOBuilder withActive(Boolean active) {
            colaboradorDTO.setActive(active);
            return this;
        }

        public ColaboradorDTO build() {
            return colaboradorDTO;
        }
    }
}
