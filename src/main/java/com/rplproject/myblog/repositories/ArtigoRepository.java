package com.rplproject.myblog.repositories;

import com.rplproject.myblog.entities.Artigo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtigoRepository extends JpaRepository<Artigo, Long> {
    Page<Artigo> findAllByActive(Boolean active, Pageable pageable);
}
