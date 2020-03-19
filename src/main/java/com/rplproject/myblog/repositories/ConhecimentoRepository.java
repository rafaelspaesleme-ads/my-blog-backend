package com.rplproject.myblog.repositories;

import com.rplproject.myblog.entities.Conhecimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConhecimentoRepository extends JpaRepository<Conhecimento, Long> {
}
