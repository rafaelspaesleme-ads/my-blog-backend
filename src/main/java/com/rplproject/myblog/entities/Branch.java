package com.rplproject.myblog.entities;

import javax.persistence.*;

@Entity(name = "tab_branches")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "fk_repositorio")
    private Repositorio repositorio;
    private Boolean active;

    public Branch(Long id, String name, Repositorio repositorio, Boolean active) {
        this.id = id;
        this.name = name;
        this.repositorio = repositorio;
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

    public Repositorio getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public static final class BranchBuilder {
        private Branch branch;

        private BranchBuilder() {
            branch = new Branch();
        }

        public static BranchBuilder aBranch() {
            return new BranchBuilder();
        }

        public BranchBuilder withId(Long id) {
            branch.setId(id);
            return this;
        }

        public BranchBuilder withName(String name) {
            branch.setName(name);
            return this;
        }

        public BranchBuilder withRepositorio(Repositorio repositorio) {
            branch.setRepositorio(repositorio);
            return this;
        }

        public BranchBuilder withActive(Boolean active) {
            branch.setActive(active);
            return this;
        }

        public Branch build() {
            return branch;
        }
    }
}
