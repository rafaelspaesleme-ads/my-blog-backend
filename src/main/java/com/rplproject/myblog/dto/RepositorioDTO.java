package com.rplproject.myblog.dto;

import com.rplproject.myblog.entities.Branch;
import com.rplproject.myblog.entities.Colaborador;

import java.time.LocalDateTime;
import java.util.List;

public class RepositorioDTO {
    private Long id;
    private String title;
    private String description;
    private List<Branch> branches;
    private Long commitsNumber;
    private Long releasesNumber;
    private List<Colaborador> contributors;
    private String urlRepository;
    private String domainGit;
    private Boolean active;
    private String usernameGit;
    private String programmingLanguage;
    private LocalDateTime datePost;

    public RepositorioDTO() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }

    public Long getCommitsNumber() {
        return commitsNumber;
    }

    public void setCommitsNumber(Long commitsNumber) {
        this.commitsNumber = commitsNumber;
    }

    public Long getReleasesNumber() {
        return releasesNumber;
    }

    public void setReleasesNumber(Long releasesNumber) {
        this.releasesNumber = releasesNumber;
    }

    public List<Colaborador> getContributors() {
        return contributors;
    }

    public void setContributors(List<Colaborador> contributors) {
        this.contributors = contributors;
    }

    public String getUrlRepository() {
        return urlRepository;
    }

    public void setUrlRepository(String urlRepository) {
        this.urlRepository = urlRepository;
    }

    public String getDomainGit() {
        return domainGit;
    }

    public void setDomainGit(String domainGit) {
        this.domainGit = domainGit;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getUsernameGit() {
        return usernameGit;
    }

    public void setUsernameGit(String usernameGit) {
        this.usernameGit = usernameGit;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public LocalDateTime getDatePost() {
        return datePost;
    }

    public void setDatePost(LocalDateTime datePost) {
        this.datePost = datePost;
    }

    public static final class RepositorioDTOBuilder {
        private RepositorioDTO repositorioDTO;

        private RepositorioDTOBuilder() {
            repositorioDTO = new RepositorioDTO();
        }

        public static RepositorioDTOBuilder aRepositorioDTO() {
            return new RepositorioDTOBuilder();
        }

        public RepositorioDTOBuilder withId(Long id) {
            repositorioDTO.setId(id);
            return this;
        }

        public RepositorioDTOBuilder withTitle(String title) {
            repositorioDTO.setTitle(title);
            return this;
        }

        public RepositorioDTOBuilder withDescription(String description) {
            repositorioDTO.setDescription(description);
            return this;
        }

        public RepositorioDTOBuilder withBranches(List<Branch> branches) {
            repositorioDTO.setBranches(branches);
            return this;
        }

        public RepositorioDTOBuilder withCommitsNumber(Long commitsNumber) {
            repositorioDTO.setCommitsNumber(commitsNumber);
            return this;
        }

        public RepositorioDTOBuilder withReleasesNumber(Long releasesNumber) {
            repositorioDTO.setReleasesNumber(releasesNumber);
            return this;
        }

        public RepositorioDTOBuilder withContributors(List<Colaborador> contributors) {
            repositorioDTO.setContributors(contributors);
            return this;
        }

        public RepositorioDTOBuilder withUrlRepository(String urlRepository) {
            repositorioDTO.setUrlRepository(urlRepository);
            return this;
        }

        public RepositorioDTOBuilder withDomainGit(String domainGit) {
            repositorioDTO.setDomainGit(domainGit);
            return this;
        }

        public RepositorioDTOBuilder withActive(Boolean active) {
            repositorioDTO.setActive(active);
            return this;
        }

        public RepositorioDTOBuilder withUsernameGit(String usernameGit) {
            repositorioDTO.setUsernameGit(usernameGit);
            return this;
        }

        public RepositorioDTOBuilder withProgrammingLanguage(String programmingLanguage) {
            repositorioDTO.setProgrammingLanguage(programmingLanguage);
            return this;
        }

        public RepositorioDTOBuilder withDatePost(LocalDateTime datePost) {
            repositorioDTO.setDatePost(datePost);
            return this;
        }

        public RepositorioDTO build() {
            return repositorioDTO;
        }
    }
}
