package com.rplproject.myblog.repositories;

import com.rplproject.myblog.entities.Usuario;
import com.rplproject.myblog.entities.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
    List<Usuarios> findAllByUsuario(String usuario);

    Optional<Usuarios> findByUsuario(String usuario);

    Optional<Usuarios> findByEmail(String email);

    @Query(value = "SELECT * FROM usuarios WHERE nome LIKE %?1%", nativeQuery = true)
    List<Usuarios> findByContemNome(String nome);

    @Query(value = "SELECT * FROM usuarios WHERE usuario LIKE %?1%", nativeQuery = true)
    List<Usuarios> findByContemUsuario(String usuario);
}
