package io.datajek.spring.basics.movierecommendersystem;

public interface Filter {
    public String[] getRecommendations(String movie);
}
