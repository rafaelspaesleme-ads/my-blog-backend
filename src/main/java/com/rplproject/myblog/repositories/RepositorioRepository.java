package com.rplproject.myblog.repositories;

import com.rplproject.myblog.entities.Repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioRepository extends JpaRepository<Repositorio, Long> {
}
