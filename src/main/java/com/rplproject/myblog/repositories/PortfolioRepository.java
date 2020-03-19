package com.rplproject.myblog.repositories;

import com.rplproject.myblog.entities.Portfolio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
    Page<Portfolio> findAllByActive(Boolean active, Pageable pageable);
}
