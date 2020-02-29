package com.rplproject.myblog.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tab_branch")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String fkRepository;
    private Boolean active;

    public Branch(Long id, String name, String fkRepository, Boolean active) {
        this.id = id;
        this.name = name;
        this.fkRepository = fkRepository;
        this.active = active;
    }

    public Branch() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFkRepository() {
        return fkRepository;
    }

    public void setFkRepository(String fkRepository) {
        this.fkRepository = fkRepository;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public static final class BranchsBuilder {
        private Branch branch;

        private BranchsBuilder() {
            branch = new Branch();
        }

        public static BranchsBuilder aBranchs() {
            return new BranchsBuilder();
        }

        public BranchsBuilder withId(Long id) {
            branch.setId(id);
            return this;
        }

        public BranchsBuilder withName(String name) {
            branch.setName(name);
            return this;
        }

        public BranchsBuilder withFkRepository(String fkRepository) {
            branch.setFkRepository(fkRepository);
            return this;
        }

        public BranchsBuilder withActive(Boolean active) {
            branch.setActive(active);
            return this;
        }

        public Branch build() {
            return branch;
        }
    }
}
