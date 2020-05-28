package com.zemoga.portfolio;

import com.zemoga.portfolio.domain.Portfolio;
import com.zemoga.portfolio.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

@SpringBootApplication
public class PortfolioApplication {


    @Autowired
    PortfolioRepository portfolioRepository;

    public static void main(String[] args) {
        SpringApplication.run(PortfolioApplication.class, args);
    }

    @Bean
    public CommandLineRunner setup() {
        return (args) ->
                createInitialData();
    }

    @Bean
    public ErrorPageRegistrar errorPageRegistrar() {
        return (ErrorPageRegistry epr) -> {
            epr.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/index.html"));
        };
    }
    private void createInitialData() {

        if(!portfolioRepository.existsByTwitterUserName("BreakingNews"))
            portfolioRepository.save(new Portfolio(1929293, "Breaking news, interchangeably termed late-breaking news and also known as a special report or special coverage or news flash, is a current issue that broadcasters feel warrants the interruption of scheduled programming or current news in order to report its details. Its use is also assigned to the most significant story of the moment or a story that is being covered live. It could be a story that is simply of wide interest to viewers and has little impact otherwise.", "https://wpcdn.us-east-1.vip.tn-cloud.net/www.kxly.com/content/uploads/2019/12/1-BREAKING-NEWS-1024x576.png", "BreakingNews", "Breaking News"));

        if (!portfolioRepository.existsByTwitterUserName("SEBAS_EUSSE"))
            portfolioRepository.save(new Portfolio(1929294, "I'm a person who likes to learn every day, I don't close the doors to a difficulty, on the contrary, I can learn from mistakes and improve for another opportunity", "https://instagram.feoh4-1.fna.fbcdn.net/v/t51.2885-19/s320x320/73178204_422465185124045_8803160588462063616_n.jpg?_nc_ht=instagram.feoh4-1.fna.fbcdn.net&_nc_ohc=HYQJt0Wj6t8AX-lxvTq&oh=e89c7a3d473a64572f64de46bf169896&oe=5EF6FAD8", "SEBAS_EUSSE", "Sebastian Eusse E."));

    }


}
