package com.zemoga.portfolio.builder;

import com.zemoga.portfolio.domain.Portfolio;
import com.zemoga.portfolio.dto.PortfolioDto;
import org.springframework.stereotype.Component;

@Component
public class PortfolioBuilder extends AbstractBuilder<Portfolio, PortfolioDto> {

    public PortfolioBuilder() {
        super();
        this.setClassD(PortfolioDto.class);
        this.setClassE(Portfolio.class);
    }






}
