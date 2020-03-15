package com.rplproject.myblog.dto;

public class ProfissaoDTO {
    private Long id;
    private String title;
    private Boolean active;

    public ProfissaoDTO() {
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

    public static final class ProfissaoDTOBuilder {
        private ProfissaoDTO profissaoDTO;

        private ProfissaoDTOBuilder() {
            profissaoDTO = new ProfissaoDTO();
        }

        public static ProfissaoDTOBuilder aProfissaoDTO() {
            return new ProfissaoDTOBuilder();
        }

        public ProfissaoDTOBuilder withId(Long id) {
            profissaoDTO.setId(id);
            return this;
        }

        public ProfissaoDTOBuilder withTitle(String title) {
            profissaoDTO.setTitle(title);
            return this;
        }

        public ProfissaoDTOBuilder withActive(Boolean active) {
            profissaoDTO.setActive(active);
            return this;
        }

        public ProfissaoDTO build() {
            return profissaoDTO;
        }
    }
}
