package com.rplproject.myblog.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity(name = "tab_repositories")
public class Repositorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "repositorio")
    private List<Branch> branches;
    private Long commitsNumber;
    private Long releasesNumber;

    @JsonIgnore
    @OneToMany(mappedBy = "repositorio")
    private List<Colaborador> contributors;
    private String urlRepository;
    private String domainGit;
    private Boolean active;
    private String usernameGit;
    private String programmingLanguage;

    public Repositorio(Long id, String title, String description, List<Branch> branches, Long commitsNumber, Long releasesNumber, List<Colaborador> contributors, String urlRepository, String domainGit, Boolean active, String usernameGit, String programmingLanguage) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.branches = branches;
        this.commitsNumber = commitsNumber;
        this.releasesNumber = releasesNumber;
        this.contributors = contributors;
        this.urlRepository = urlRepository;
        this.domainGit = domainGit;
        this.active = active;
        this.usernameGit = usernameGit;
        this.programmingLanguage = programmingLanguage;
    }

    public Repositorio() {
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

    public static final class RepositorioBuilder {
        private Repositorio repositorio;

        private RepositorioBuilder() {
            repositorio = new Repositorio();
        }

        public static RepositorioBuilder aRepositorio() {
            return new RepositorioBuilder();
        }

        public RepositorioBuilder withId(Long id) {
            repositorio.setId(id);
            return this;
        }

        public RepositorioBuilder withTitle(String title) {
            repositorio.setTitle(title);
            return this;
        }

        public RepositorioBuilder withDescription(String description) {
            repositorio.setDescription(description);
            return this;
        }

        public RepositorioBuilder withBranches(List<Branch> branches) {
            repositorio.setBranches(branches);
            return this;
        }

        public RepositorioBuilder withCommitsNumber(Long commitsNumber) {
            repositorio.setCommitsNumber(commitsNumber);
            return this;
        }

        public RepositorioBuilder withReleasesNumber(Long releasesNumber) {
            repositorio.setReleasesNumber(releasesNumber);
            return this;
        }

        public RepositorioBuilder withContributors(List<Colaborador> contributors) {
            repositorio.setContributors(contributors);
            return this;
        }

        public RepositorioBuilder withUrlRepository(String urlRepository) {
            repositorio.setUrlRepository(urlRepository);
            return this;
        }

        public RepositorioBuilder withDomainGit(String domainGit) {
            repositorio.setDomainGit(domainGit);
            return this;
        }

        public RepositorioBuilder withActive(Boolean active) {
            repositorio.setActive(active);
            return this;
        }

        public RepositorioBuilder withUsernameGit(String usernameGit) {
            repositorio.setUsernameGit(usernameGit);
            return this;
        }

        public RepositorioBuilder withProgrammingLanguage(String programmingLanguage) {
            repositorio.setProgrammingLanguage(programmingLanguage);
            return this;
        }

        public Repositorio build() {
            return repositorio;
        }
    }
}
