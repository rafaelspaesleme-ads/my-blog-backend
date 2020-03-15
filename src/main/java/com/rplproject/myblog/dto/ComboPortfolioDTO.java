package com.rplproject.myblog.dto;

public class ComboPortfolioDTO {
    private PortfolioDTO portfolioDTO;
    private SocialMediaDTO socialMediaDTO;
    private SeguidorDTO seguidorDTO;
    private ProfissaoDTO profissaoDTO;

    public ComboPortfolioDTO() {
    }

    public PortfolioDTO getPortfolioDTO() {
        return portfolioDTO;
    }

    public void setPortfolioDTO(PortfolioDTO portfolioDTO) {
        this.portfolioDTO = portfolioDTO;
    }

    public SocialMediaDTO getSocialMediaDTO() {
        return socialMediaDTO;
    }

    public void setSocialMediaDTO(SocialMediaDTO socialMediaDTO) {
        this.socialMediaDTO = socialMediaDTO;
    }

    public SeguidorDTO getSeguidorDTO() {
        return seguidorDTO;
    }

    public void setSeguidorDTO(SeguidorDTO seguidorDTO) {
        this.seguidorDTO = seguidorDTO;
    }

    public ProfissaoDTO getProfissaoDTO() {
        return profissaoDTO;
    }

    public void setProfissaoDTO(ProfissaoDTO profissaoDTO) {
        this.profissaoDTO = profissaoDTO;
    }

    public static final class ComboPortfolioDTOBuilder {
        private ComboPortfolioDTO comboPortfolioDTO;

        private ComboPortfolioDTOBuilder() {
            comboPortfolioDTO = new ComboPortfolioDTO();
        }

        public static ComboPortfolioDTOBuilder aComboPortfolioDTO() {
            return new ComboPortfolioDTOBuilder();
        }

        public ComboPortfolioDTOBuilder withPortfolioDTO(PortfolioDTO portfolioDTO) {
            comboPortfolioDTO.setPortfolioDTO(portfolioDTO);
            return this;
        }

        public ComboPortfolioDTOBuilder withSocialMediaDTO(SocialMediaDTO socialMediaDTO) {
            comboPortfolioDTO.setSocialMediaDTO(socialMediaDTO);
            return this;
        }

        public ComboPortfolioDTOBuilder withSeguidorDTO(SeguidorDTO seguidorDTO) {
            comboPortfolioDTO.setSeguidorDTO(seguidorDTO);
            return this;
        }

        public ComboPortfolioDTOBuilder withProfissaoDTO(ProfissaoDTO profissaoDTO) {
            comboPortfolioDTO.setProfissaoDTO(profissaoDTO);
            return this;
        }

        public ComboPortfolioDTO build() {
            return comboPortfolioDTO;
        }
    }
}
