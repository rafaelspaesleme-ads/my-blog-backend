package com.rplproject.myblog.dto;

import com.rplproject.myblog.entities.Repositorio;

public class BranchDTO {
    private Long id;
    private String name;
    private Repositorio repositorio;
    private Boolean active;

    public BranchDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public static final class BranchDTOBuilder {
        private BranchDTO branchDTO;

        private BranchDTOBuilder() {
            branchDTO = new BranchDTO();
        }

        public static BranchDTOBuilder aBranchDTO() {
            return new BranchDTOBuilder();
        }

        public BranchDTOBuilder withId(Long id) {
            branchDTO.setId(id);
            return this;
        }

        public BranchDTOBuilder withName(String name) {
            branchDTO.setName(name);
            return this;
        }

        public BranchDTOBuilder withRepositorio(Repositorio repositorio) {
            branchDTO.setRepositorio(repositorio);
            return this;
        }

        public BranchDTOBuilder withActive(Boolean active) {
            branchDTO.setActive(active);
            return this;
        }

        public BranchDTO build() {
            return branchDTO;
        }
    }
}
