package com.rplproject.myblog.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tab_usermasters")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String name;
    private Boolean active;

    public Usuario(Long id, String username, String password, String name, Boolean active) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.active = active;
    }

    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public static final class UsuarioBuilder {
        private Usuario usuario;

        private UsuarioBuilder() {
            usuario = new Usuario();
        }

        public static UsuarioBuilder anUsuario() {
            return new UsuarioBuilder();
        }

        public UsuarioBuilder withId(Long id) {
            usuario.setId(id);
            return this;
        }

        public UsuarioBuilder withUsername(String username) {
            usuario.setUsername(username);
            return this;
        }

        public UsuarioBuilder withPassword(String password) {
            usuario.setPassword(password);
            return this;
        }

        public UsuarioBuilder withName(String name) {
            usuario.setName(name);
            return this;
        }

        public UsuarioBuilder withActive(Boolean active) {
            usuario.setActive(active);
            return this;
        }

        public Usuario build() {
            return usuario;
        }
    }
}
