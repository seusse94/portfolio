package com.zemoga.portfolio.service.portfolio;

import com.zemoga.portfolio.domain.Portfolio;
import com.zemoga.portfolio.dto.PortfolioEditedDto;

import java.util.List;


public interface PortfolioService {

    void updateUserInformation(PortfolioEditedDto portfolioEditedDto);

    List<Portfolio> findAllByTwitterUserName(String username);
}
