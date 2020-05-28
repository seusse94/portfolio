package com.zemoga.portfolio.service.portfolio.impl;

import com.zemoga.portfolio.constant.PortfolioConstants;
import com.zemoga.portfolio.domain.Portfolio;
import com.zemoga.portfolio.dto.PortfolioEditedDto;
import com.zemoga.portfolio.exception.PortfolioException;
import com.zemoga.portfolio.repository.PortfolioRepository;
import com.zemoga.portfolio.service.portfolio.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultPortfolioService implements PortfolioService {



    @Autowired
    private PortfolioRepository portfolioRepository;

    @Override
    public List<Portfolio> findAllByTwitterUserName(String username) {
        return portfolioRepository.findAllByTwitterUserName(username);
    }

    @Override
    public void updateUserInformation(PortfolioEditedDto portfolioEditedDto) {

        if (portfolioRepository.existsByTwitterUserName(portfolioEditedDto.getTwitterUserName())) {
            Optional<Portfolio> firstPortfolioOpt = findAllByTwitterUserName(portfolioEditedDto.getTwitterUserName()).stream().findFirst();
            Portfolio portfolio = firstPortfolioOpt.orElseThrow(() -> new PortfolioException(PortfolioConstants.THE_USER_DOES_NOT_EXIST_IS_NOT_POSSIBLE_TO_EDIT));
            setEditedInformation(portfolioEditedDto, portfolio);
            portfolioRepository.save(portfolio);
        } else {
            throw new PortfolioException(PortfolioConstants.THE_USER_DOES_NOT_EXIST_IS_NOT_POSSIBLE_TO_EDIT);
        }
    }

    private void setEditedInformation(PortfolioEditedDto portfolioEditedDto, Portfolio portfolio) {
        portfolio.setImageUrl(portfolioEditedDto.getImageUrl());
        portfolio.setDescription(portfolioEditedDto.getDescription());
        portfolio.setTitle(portfolioEditedDto.getTitle());
    }
}
