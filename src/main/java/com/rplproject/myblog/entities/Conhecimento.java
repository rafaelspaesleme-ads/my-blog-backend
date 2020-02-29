package com.rplproject.myblog.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tab_learning")
public class Conhecimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer level;
    private Boolean active;
    private Long fkPortfolio;

    public Conhecimento(Long id, String title, Integer level, Boolean active, Long fkPortfolio) {
        this.id = id;
        this.title = title;
        this.level = level;
        this.active = active;
        this.fkPortfolio = fkPortfolio;
    }

    public Conhecimento() {
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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Long getFkPortfolio() {
        return fkPortfolio;
    }

    public void setFkPortfolio(Long fkPortfolio) {
        this.fkPortfolio = fkPortfolio;
    }

    public static final class ConhecimentoBuilder {
        private Conhecimento conhecimento;

        private ConhecimentoBuilder() {
            conhecimento = new Conhecimento();
        }

        public static ConhecimentoBuilder aConhecimento() {
            return new ConhecimentoBuilder();
        }

        public ConhecimentoBuilder withId(Long id) {
            conhecimento.setId(id);
            return this;
        }

        public ConhecimentoBuilder withTitle(String title) {
            conhecimento.setTitle(title);
            return this;
        }

        public ConhecimentoBuilder withLevel(Integer level) {
            conhecimento.setLevel(level);
            return this;
        }

        public ConhecimentoBuilder withActive(Boolean active) {
            conhecimento.setActive(active);
            return this;
        }

        public ConhecimentoBuilder withFkPortfolio(Long fkPortfolio) {
            conhecimento.setFkPortfolio(fkPortfolio);
            return this;
        }

        public Conhecimento build() {
            return conhecimento;
        }
    }
}
