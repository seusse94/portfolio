package com.zemoga.portfolio.service.portfolio;

import com.zemoga.portfolio.constant.PortfolioConstants;
import com.zemoga.portfolio.domain.Portfolio;
import com.zemoga.portfolio.dto.PortfolioEditedDto;
import com.zemoga.portfolio.exception.PortfolioException;
import com.zemoga.portfolio.repository.PortfolioRepository;
import com.zemoga.portfolio.service.portfolio.impl.DefaultPortfolioService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SpringBootTest
public class DefaultPortfolioServiceTest {


    @Mock
    private PortfolioRepository portfolioRepository;

    @InjectMocks
    private DefaultPortfolioService defaultPortfolioService;

    @Before
    public void init() {

    }

    @Test
    void updateUserInformationTest() {
        PortfolioEditedDto portfolioEditedDto = new PortfolioEditedDto();
        portfolioEditedDto.setTwitterUserName("NameTest");
        List<Portfolio> portfolios = Arrays.asList(new Portfolio(3, "", "", "", ""));
        Mockito.when(portfolioRepository.existsByTwitterUserName(portfolioEditedDto.getTwitterUserName())).thenReturn(Boolean.TRUE);
        Mockito.when(portfolioRepository.findAllByTwitterUserName(Mockito.anyString())).thenReturn(portfolios);
        defaultPortfolioService.updateUserInformation(portfolioEditedDto);
        Mockito.verify(portfolioRepository, Mockito.atLeastOnce()).save(Mockito.any(Portfolio.class));


    }

    @Test
    void updateUserInformationTestWhenThrowsException() {
        PortfolioEditedDto portfolioEditedDto = new PortfolioEditedDto();
        portfolioEditedDto.setTwitterUserName("NameTest");

        try {
            defaultPortfolioService.updateUserInformation(portfolioEditedDto);
            fail();
        } catch (Exception e) {
            assertEquals(e.getMessage(), PortfolioConstants.THE_USER_DOES_NOT_EXIST_IS_NOT_POSSIBLE_TO_EDIT);
            assertTrue(e instanceof PortfolioException);
        }

    }

    @Test
    void findAllByTwitterUserNameTest() {
        PortfolioEditedDto portfolioEditedDto = new PortfolioEditedDto();
        portfolioEditedDto.setTwitterUserName("NameTest");
        defaultPortfolioService.findAllByTwitterUserName(portfolioEditedDto.getTwitterUserName());
        Mockito.verify(portfolioRepository, Mockito.atLeastOnce()).findAllByTwitterUserName(Mockito.any(String.class));

    }


    @Test
    void setEditedInformationTest() {
        PortfolioEditedDto portfolioEditedDto = new PortfolioEditedDto();
        portfolioEditedDto.setImageUrl("ImageTestNew");
        portfolioEditedDto.setDescription("DescriptionTestNew");
        portfolioEditedDto.setTitle("TitleTestNew");

        Portfolio portfolio = new Portfolio();
        portfolio.setImageUrl("ImageTestBefore");
        portfolio.setDescription("DescriptionTestBefore");
        portfolio.setTitle("TitleTestBefore");

        Method privateMethod = null;
        try {
            privateMethod = DefaultPortfolioService.class.getDeclaredMethod("setEditedInformation", PortfolioEditedDto.class,Portfolio.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        privateMethod.setAccessible(true);
        try {

            privateMethod.invoke(defaultPortfolioService, portfolioEditedDto,portfolio);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        assertEquals(portfolio.getDescription(),"DescriptionTestNew");
        assertEquals(portfolio.getImageUrl(),"ImageTestNew");
        assertEquals(portfolio.getTitle(),"TitleTestNew");

    }

}
