package com.rplproject.myblog.entities;

import javax.persistence.*;

@Entity(name = "tab_contributors")
public class Colaborador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String usernameGit;

    @ManyToOne
    @JoinColumn(name = "fk_repositorio")
    private Repositorio repositorio;
    private Boolean active;

    public Colaborador(Long id, String usernameGit, Repositorio repositorio, Boolean active) {
        this.id = id;
        this.usernameGit = usernameGit;
        this.repositorio = repositorio;
        this.active = active;
    }

    public Colaborador() {
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

    public static final class ColaboradorBuilder {
        private Colaborador colaborador;

        private ColaboradorBuilder() {
            colaborador = new Colaborador();
        }

        public static ColaboradorBuilder aColaborador() {
            return new ColaboradorBuilder();
        }

        public ColaboradorBuilder withId(Long id) {
            colaborador.setId(id);
            return this;
        }

        public ColaboradorBuilder withUsernameGit(String usernameGit) {
            colaborador.setUsernameGit(usernameGit);
            return this;
        }

        public ColaboradorBuilder withRepositorio(Repositorio repositorio) {
            colaborador.setRepositorio(repositorio);
            return this;
        }

        public ColaboradorBuilder withActive(Boolean active) {
            colaborador.setActive(active);
            return this;
        }

        public Colaborador build() {
            return colaborador;
        }
    }
}
