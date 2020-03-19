package com.rplproject.myblog.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tab_professions")
public class Profissao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Boolean active;

    public Profissao(Long id, String title, Boolean active) {
        this.id = id;
        this.title = title;
        this.active = active;
    }

    public Profissao() {
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public static final class ProfissaoBuilder {
        private Profissao profissao;

        private ProfissaoBuilder() {
            profissao = new Profissao();
        }

        public static ProfissaoBuilder aProfissao() {
            return new ProfissaoBuilder();
        }

        public ProfissaoBuilder withId(Long id) {
            profissao.setId(id);
            return this;
        }

        public ProfissaoBuilder withTitle(String title) {
            profissao.setTitle(title);
            return this;
        }

        public ProfissaoBuilder withActive(Boolean active) {
            profissao.setActive(active);
            return this;
        }

        public Profissao build() {
            return profissao;
        }
    }
}
