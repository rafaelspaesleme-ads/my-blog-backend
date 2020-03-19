package com.rplproject.myblog.repositories;

import com.rplproject.myblog.entities.Contato;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
    Page<Contato> findAllByActive(Boolean active, Pageable pageable);
}
