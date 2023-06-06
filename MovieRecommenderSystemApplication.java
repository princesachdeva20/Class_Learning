package io.datajek.spring.basics.movierecommendersystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class MovieRecommenderSystemApplication {

	public static void main(String[] args) {

		ApplicationContext appContext = SpringApplication.run(MovieRecommenderSystemApplication.class, args);

		RecommenderImplementation recommender = appContext.getBean(RecommenderImplementation.class);

		System.out.println(recommender);

		Movie movie01 = appContext.getBean(Movie.class);
		System.out.println(movie01);

		Movie movie02 = appContext.getBean(Movie.class);
		System.out.println(movie02);


		/*
		ContentBasedFilter filter = appContext.getBean(ContentBasedFilter.class);
		ContentBasedFilter filter2 = appContext.getBean(ContentBasedFilter.class);
		System.out.println("\nCBF bean with singleton scope");
		System.out.println(filter);
		System.out.println(filter2);

		Movie movie01 = filter.getMovie();
		Movie movie02 = filter2.getMovie();
		Movie movie03 = filter.getMovie();

		System.out.println("\nMovie bean with prototype scope");
		System.out.println(movie01);
		System.out.println(movie02);
		System.out.println(movie03);

		System.out.println("\nCBF instances created: " + ContentBasedFilter.getInstance());
		System.out.println("Movie instances created: " + Movie.getInstances());

		 */
	}

}
