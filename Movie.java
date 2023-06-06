package io.datajek.spring.basics.movierecommendersystem;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Movie {

    private static int instances = 0;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private int id;
    private String name;
    private String genre;
    private String producer;

    public Movie(){
        //Super();
        instances++;
        System.out.println("Movie constructor called...");
    }

    @PostConstruct
    private void postConstruct(){
        logger.info("Movie postConstruct method...");
    }

    public static int getInstances(){
        return Movie.instances;
    }

    @PreDestroy
    private void preDestory(){
        logger.info("Movie preDestroy method..");
    }

}
