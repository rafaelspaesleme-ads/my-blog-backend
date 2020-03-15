package com.rplproject.myblog.dto;

public class ConhecimentoDTO {
    private Long id;
    private String title;
    private Integer level;
    private Boolean active;

    public ConhecimentoDTO() {
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

    public static final class ConhecimentoDTOBuilder {
        private ConhecimentoDTO conhecimentoDTO;

        private ConhecimentoDTOBuilder() {
            conhecimentoDTO = new ConhecimentoDTO();
        }

        public static ConhecimentoDTOBuilder aConhecimentoDTO() {
            return new ConhecimentoDTOBuilder();
        }

        public ConhecimentoDTOBuilder withId(Long id) {
            conhecimentoDTO.setId(id);
            return this;
        }

        public ConhecimentoDTOBuilder withTitle(String title) {
            conhecimentoDTO.setTitle(title);
            return this;
        }

        public ConhecimentoDTOBuilder withLevel(Integer level) {
            conhecimentoDTO.setLevel(level);
            return this;
        }

        public ConhecimentoDTOBuilder withActive(Boolean active) {
            conhecimentoDTO.setActive(active);
            return this;
        }

        public ConhecimentoDTO build() {
            return conhecimentoDTO;
        }
    }
}
