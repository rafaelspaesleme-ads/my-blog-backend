package com.rplproject.myblog.dto;

import com.rplproject.myblog.entities.Portfolio;
import com.rplproject.myblog.entities.enums.TypeCourses;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

public class FormacaoDTO {
    private Long id;
    private String title;
    private String institution;
    private LocalDate dateInitial;
    private LocalDate dateFinal;
    private Boolean active;

    @Enumerated(EnumType.STRING)
    private TypeCourses typeCourses;

    public FormacaoDTO() {
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

    public static final class FormacaoDTOBuilder {
        private FormacaoDTO formacaoDTO;

        private FormacaoDTOBuilder() {
            formacaoDTO = new FormacaoDTO();
        }

        public static FormacaoDTOBuilder aFormacaoDTO() {
            return new FormacaoDTOBuilder();
        }

        public FormacaoDTOBuilder withId(Long id) {
            formacaoDTO.setId(id);
            return this;
        }

        public FormacaoDTOBuilder withTitle(String title) {
            formacaoDTO.setTitle(title);
            return this;
        }

        public FormacaoDTOBuilder withInstitution(String institution) {
            formacaoDTO.setInstitution(institution);
            return this;
        }

        public FormacaoDTOBuilder withDateInitial(LocalDate dateInitial) {
            formacaoDTO.setDateInitial(dateInitial);
            return this;
        }

        public FormacaoDTOBuilder withDateFinal(LocalDate dateFinal) {
            formacaoDTO.setDateFinal(dateFinal);
            return this;
        }

        public FormacaoDTOBuilder withActive(Boolean active) {
            formacaoDTO.setActive(active);
            return this;
        }

        public FormacaoDTOBuilder withTypeCourses(TypeCourses typeCourses) {
            formacaoDTO.setTypeCourses(typeCourses);
            return this;
        }

        public FormacaoDTO build() {
            return formacaoDTO;
        }
    }
}
