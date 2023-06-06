package io.datajek.spring.basics.movierecommendersystem;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class RecommenderImplementation {

    private Filter filter;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    @Qualifier("CBF")
    public void setFilter(Filter _filter){
        logger.info("RI setter method...");
        this.filter = _filter;
    }

    @PostConstruct
    public void postContruct(){
        logger.info("RI postConstruct method");
    }

    @PreDestroy
    public void preDestory(){
        logger.info("RI preDestroy method");
    }

    @Autowired
    public RecommenderImplementation(@Qualifier("CBF") Filter _filter){
        this.filter = _filter;
        System.out.println("Constructor invoked...");
    }

    public String[] recommendMovies(String movie){

        System.out.println("Name of the filter in use: " + filter + "\n");

        String[] results = filter.getRecommendations(movie);

        return results;
    }
}
