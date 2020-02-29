package com.rplproject.myblog.repositories;

import com.rplproject.myblog.entities.Postagem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
    Page<Postagem> findAllByActive(Boolean active, Pageable pageable);
}
