package io.datajek.spring.basics.movierecommendersystem;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@Qualifier("CBF")
public class ContentBasedFilter implements Filter{

    private static int instances = 0;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Movie movie;

    public ContentBasedFilter(){
        super();
        instances++;
        logger.info("CBF constructor method...");

    }

    @PostConstruct
    private void postContruct(){
        logger.info("CBF postConstruct method...");
    }

    @PreDestroy
    private void preDestroy(){
        logger.info("CBF preDestroy method...");
    }

    public Movie getMovie(){
        return movie;
    }

    public static int getInstance(){
        return ContentBasedFilter.instances;
    }


    public String[] getRecommendations(String movie) {
        return new String[] {"The Matrix", "John Wick", "The Batman"};
    }
}
