package com.rplproject.myblog.entities;

import javax.persistence.*;

@Entity(name = "tab_learnings")
public class Conhecimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer level;
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "fk_portfolio")
    private Portfolio portfolio;

    public Conhecimento(Long id, String title, Integer level, Boolean active, Portfolio portfolio) {
        this.id = id;
        this.title = title;
        this.level = level;
        this.active = active;
        this.portfolio = portfolio;
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

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
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

        public ConhecimentoBuilder withPortfolio(Portfolio portfolio) {
            conhecimento.setPortfolio(portfolio);
            return this;
        }

        public Conhecimento build() {
            return conhecimento;
        }
    }
}
