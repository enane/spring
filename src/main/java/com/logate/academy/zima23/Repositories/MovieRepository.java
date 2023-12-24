package com.logate.academy.zima23.Repositories;

import com.logate.academy.zima23.DTO.MovieDTO;
import com.logate.academy.zima23.Filters.MovieFilter;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class MovieRepository {

    public List<MovieDTO> getAll() {
        MovieDTO movie1 = new MovieDTO();
        movie1.setId(1);
        movie1.setYear(2022);
        movie1.setTitle("The Blockbuster");
        movie1.setGenre("Action");
        movie1.setDescription("An action-packed movie with thrilling sequences.");
        movie1.setTicket(10.99);

        MovieDTO movie2 = new MovieDTO();
        movie2.setId(2);
        movie2.setYear(2021);
        movie2.setTitle("Romantic Sunset");
        movie2.setGenre("Action");
        movie2.setDescription("A heartwarming story of love and serenity.");
        movie2.setTicket(8.99);

        MovieDTO movie3 = new MovieDTO();
        movie3.setId(3);
        movie3.setYear(2023);
        movie3.setTitle("Sci-Fi Adventure");
        movie3.setGenre("Sci-Fi");
        movie3.setDescription("A thrilling journey through space and time.");
        movie3.setTicket(12.99);

        MovieDTO movie4 = new MovieDTO();
        movie4.setId(4);
        movie4.setYear(2020);
        movie4.setTitle("Mystery Mansion");
        movie4.setGenre("Mystery");
        movie4.setDescription("Unravel the secrets of a mysterious mansion.");
        movie4.setTicket(9.99);

        MovieDTO movie5 = new MovieDTO();
        movie5.setId(5);
        movie5.setYear(2021);
        movie5.setTitle("Animated Fantasy");
        movie5.setGenre("Animation");
        movie5.setDescription("Embark on a magical adventure in an animated world.");
        movie5.setTicket(11.49);

        return List.of(movie1, movie2, movie3, movie4, movie5);
    }

    public MovieDTO getById(Integer id) {
        return getAll()
                .stream()
                .filter(movie -> movie.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<MovieDTO> getByParams(String term, String genre, Integer year, Integer fromYear, Integer toYear, Double fromPrice, Double toPrice) {
        return getAll()
                .stream()
                .filter(movie ->
                        (term == null || (movie.getTitle().toLowerCase().contains(term) || movie.getDescription().toLowerCase().contains(term))) &&
                        (genre == null || movie.getGenre().equals(genre)) &&
                        (year == null || movie.getYear().equals(year)) &&
                        (fromYear == null || movie.getYear() >= fromYear) &&
                        (toYear == null || movie.getYear() <= toYear) &&
                        (fromPrice == null || movie.getTicket() >= fromPrice) &&
                        (toPrice == null || movie.getTicket() <= toPrice)
                        )
                .collect(Collectors.toList());
    }

    public List<MovieDTO> getByParamsMap(Map<String, Objects> queryParams) {
        return getAll()
                .stream()
                .filter(movie -> {
                    Object term = queryParams.get("term");
                    Object genre = queryParams.get("genre");
                    Object year = queryParams.get("year");
                    Object fromYear = queryParams.get("fromYear");
                    Object toYear = queryParams.get("toYear");
                    Object fromPrice = queryParams.get("fromPrice");
                    Object toPrice = queryParams.get("toPrice");

                    return (term == null || (movie.getTitle().contains((String) term) || movie.getDescription().contains((String) term))) &&
                            (genre == null || movie.getGenre().equals(genre)) &&
                            (year == null || movie.getYear().equals(Integer.parseInt(year.toString()))) &&
                            (fromYear == null || movie.getYear() >= Integer.parseInt(fromYear.toString())) &&
                            (toYear == null || movie.getYear() <=  Integer.parseInt(toYear.toString())) &&
                            (fromPrice == null || movie.getTicket() >= Double.parseDouble(fromPrice.toString())) &&
                            (toPrice == null || movie.getTicket() <=  Double.parseDouble(toPrice.toString()));
                })
                .collect(Collectors.toList());
    }

    public List<MovieDTO> getByParamsClass(MovieFilter movieFilter) {
        return getAll()
                .stream()
                .filter(movie -> {
                    String term = movieFilter.getTerm();
                    String genre = movieFilter.getGenre();
                    Integer year = movieFilter.getYear();
                    Integer fromYear = movieFilter.getFromYear();
                    Integer toYear = movieFilter.getToYear();
                    Double fromPrice = movieFilter.getFromPrice();
                    Double toPrice = movieFilter.getToPrice();

                    return (term == null || (movie.getTitle().contains(term) || movie.getDescription().contains(term))) &&
                            (genre == null || movie.getGenre().equals(genre)) &&
                            (year == null || movie.getYear().equals(year) &&
                            (fromYear == null || movie.getYear() >= fromYear) &&
                            (toYear == null || movie.getYear() <=  toYear) &&
                            (fromPrice == null || movie.getTicket() >= fromPrice) &&
                            (toPrice == null || movie.getTicket() <=  toPrice));
                })
                .collect(Collectors.toList())
                ;
    }
}
