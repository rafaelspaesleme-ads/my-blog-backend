package com.rplproject.myblog.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tab_contributions")
public class Colaborador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String usernameGit;
    private Long fkRepository;
    private Boolean active;

    public Colaborador(Long id, String usernameGit, Long fkRepository, Boolean active) {
        this.id = id;
        this.usernameGit = usernameGit;
        this.fkRepository = fkRepository;
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

    public Long getFkRepository() {
        return fkRepository;
    }

    public void setFkRepository(Long fkRepository) {
        this.fkRepository = fkRepository;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public static final class ColaboradoresBuilder {
        private Colaborador colaborador;

        private ColaboradoresBuilder() {
            colaborador = new Colaborador();
        }

        public static ColaboradoresBuilder aColaboradores() {
            return new ColaboradoresBuilder();
        }

        public ColaboradoresBuilder withId(Long id) {
            colaborador.setId(id);
            return this;
        }

        public ColaboradoresBuilder withUsernameGit(String usernameGit) {
            colaborador.setUsernameGit(usernameGit);
            return this;
        }

        public ColaboradoresBuilder withFkRepository(Long fkRepository) {
            colaborador.setFkRepository(fkRepository);
            return this;
        }

        public ColaboradoresBuilder withActive(Boolean active) {
            colaborador.setActive(active);
            return this;
        }

        public Colaborador build() {
            return colaborador;
        }
    }
}
