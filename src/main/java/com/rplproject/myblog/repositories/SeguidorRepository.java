package com.rplproject.myblog.repositories;

import com.rplproject.myblog.entities.Seguidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeguidorRepository extends JpaRepository<Seguidor, Long> {
}
