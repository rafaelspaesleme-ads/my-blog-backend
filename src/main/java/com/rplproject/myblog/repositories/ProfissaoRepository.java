package com.rplproject.myblog.repositories;

import com.rplproject.myblog.entities.Profissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfissaoRepository extends JpaRepository<Profissao, Long> {
}
