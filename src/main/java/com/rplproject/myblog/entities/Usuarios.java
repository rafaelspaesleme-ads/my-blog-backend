package com.rplproject.myblog.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rplproject.myblog.configurations.ProfileUserConfiguration;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Entity(name = "tab_users")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true, nullable = false)
    private String usuario;

    @JsonIgnore
    @Column(columnDefinition = "TEXT", nullable = false)
    private String senha;
    private Boolean ativo;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "users_profile")
    private Set<String> perfis = new HashSet<>();

    @Column(unique = true, nullable = false)
    private String email;

    public Usuarios(Long id, String nome, String usuario, String senha, Boolean ativo, String email) {
        this.id = id;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.ativo = ativo;
        this.email = email;
    }

    public Usuarios() {
        addPerfil(ProfileUserConfiguration.ROLE_USER);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Set<ProfileUserConfiguration> getPerfis() {
        return perfis.stream().map(ProfileUserConfiguration::valueOf).collect(Collectors.toSet());
    }

    public void addPerfil(ProfileUserConfiguration profileUserConfiguration){
        perfis.add(profileUserConfiguration.toString());
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuarios usuarios = (Usuarios) o;
        return id.equals(usuarios.id) &&
                nome.equals(usuarios.nome) &&
                usuario.equals(usuarios.usuario) &&
                senha.equals(usuarios.senha) &&
                ativo.equals(usuarios.ativo) &&
                perfis.equals(usuarios.perfis) &&
                email.equals(usuarios.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, usuario, senha, ativo, perfis, email);
    }

    public static final class UsuariosBuilder {
        private Usuarios usuarios;

        private UsuariosBuilder() {
            usuarios = new Usuarios();
        }

        public static UsuariosBuilder anUsuarios() {
            return new UsuariosBuilder();
        }

        public UsuariosBuilder withId(Long id) {
            usuarios.setId(id);
            return this;
        }

        public UsuariosBuilder withNome(String nome) {
            usuarios.setNome(nome);
            return this;
        }

        public UsuariosBuilder withUsuario(String usuario) {
            usuarios.setUsuario(usuario);
            return this;
        }

        public UsuariosBuilder withSenha(String senha) {
            usuarios.setSenha(senha);
            return this;
        }

        public UsuariosBuilder withAtivo(Boolean ativo) {
            usuarios.setAtivo(ativo);
            return this;
        }

        public UsuariosBuilder withEmail(String email) {
            usuarios.setEmail(email);
            return this;
        }

        public Usuarios build() {
            return usuarios;
        }
    }
}
