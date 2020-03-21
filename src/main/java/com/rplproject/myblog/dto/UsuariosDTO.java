package com.rplproject.myblog.dto;

public class UsuariosDTO {
    private Long id;
    private String nome;
    private String usuario;
    private String senha;
    private Boolean ativo;
    private String email;

    public UsuariosDTO() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static final class UsuariosDTOBuilder {
        private UsuariosDTO usuariosDTO;

        private UsuariosDTOBuilder() {
            usuariosDTO = new UsuariosDTO();
        }

        public static UsuariosDTOBuilder anUsuariosDTO() {
            return new UsuariosDTOBuilder();
        }

        public UsuariosDTOBuilder withId(Long id) {
            usuariosDTO.setId(id);
            return this;
        }

        public UsuariosDTOBuilder withNome(String nome) {
            usuariosDTO.setNome(nome);
            return this;
        }

        public UsuariosDTOBuilder withUsuario(String usuario) {
            usuariosDTO.setUsuario(usuario);
            return this;
        }

        public UsuariosDTOBuilder withSenha(String senha) {
            usuariosDTO.setSenha(senha);
            return this;
        }

        public UsuariosDTOBuilder withAtivo(Boolean ativo) {
            usuariosDTO.setAtivo(ativo);
            return this;
        }

        public UsuariosDTOBuilder withEmail(String email) {
            usuariosDTO.setEmail(email);
            return this;
        }

        public UsuariosDTO build() {
            return usuariosDTO;
        }
    }
}
