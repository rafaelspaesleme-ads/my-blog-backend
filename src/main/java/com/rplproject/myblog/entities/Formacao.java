package com.rplproject.myblog.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rplproject.myblog.entities.enums.TypeCourses;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "tab_formations")
public class Formacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String institution;
    private LocalDate dateInitial;
    private LocalDate dateFinal;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "fk_portfolio")
    private Portfolio portfolio;
    private Boolean active;

    @Enumerated(EnumType.STRING)
    private TypeCourses typeCourses;

    public Formacao(Long id, String title, String institution, LocalDate dateInitial, LocalDate dateFinal, Portfolio portfolio, Boolean active, TypeCourses typeCourses) {
        this.id = id;
        this.title = title;
        this.institution = institution;
        this.dateInitial = dateInitial;
        this.dateFinal = dateFinal;
        this.portfolio = portfolio;
        this.active = active;
        this.typeCourses = typeCourses;
    }

    public Formacao() {
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

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public LocalDate getDateInitial() {
        return dateInitial;
    }

    public void setDateInitial(LocalDate dateInitial) {
        this.dateInitial = dateInitial;
    }

    public LocalDate getDateFinal() {
        return dateFinal;
    }

    public void setDateFinal(LocalDate dateFinal) {
        this.dateFinal = dateFinal;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public TypeCourses getTypeCourses() {
        return typeCourses;
    }

    public void setTypeCourses(TypeCourses typeCourses) {
        this.typeCourses = typeCourses;
    }

    public static final class FormacaoBuilder {
        private Formacao formacao;

        private FormacaoBuilder() {
            formacao = new Formacao();
        }

        public static FormacaoBuilder aFormacao() {
            return new FormacaoBuilder();
        }

        public FormacaoBuilder withId(Long id) {
            formacao.setId(id);
            return this;
        }

        public FormacaoBuilder withTitle(String title) {
            formacao.setTitle(title);
            return this;
        }

        public FormacaoBuilder withInstitution(String institution) {
            formacao.setInstitution(institution);
            return this;
        }

        public FormacaoBuilder withDateInitial(LocalDate dateInitial) {
            formacao.setDateInitial(dateInitial);
            return this;
        }

        public FormacaoBuilder withDateFinal(LocalDate dateFinal) {
            formacao.setDateFinal(dateFinal);
            return this;
        }

        public FormacaoBuilder withPortfolio(Portfolio portfolio) {
            formacao.setPortfolio(portfolio);
            return this;
        }

        public FormacaoBuilder withActive(Boolean active) {
            formacao.setActive(active);
            return this;
        }

        public FormacaoBuilder withTypeCourses(TypeCourses typeCourses) {
            formacao.setTypeCourses(typeCourses);
            return this;
        }

        public Formacao build() {
            return formacao;
        }
    }
}
