package com.zemoga.portfolio.repository;

import com.zemoga.portfolio.domain.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {

    Boolean existsByTwitterUserName(String userName);

    List<Portfolio> findAllByTwitterUserName(String userName);
}
