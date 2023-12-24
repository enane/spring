package com.logate.academy.zima23.Services;

import com.logate.academy.zima23.DTO.MovieDTO;
import com.logate.academy.zima23.Filters.MovieFilter;
import com.logate.academy.zima23.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<MovieDTO> getAll() {
        return movieRepository.getAll();
    }

    public MovieDTO getById(Integer id) {
        return movieRepository.getById(id);
    }

    public List<MovieDTO> getByParams(String term, String genre, Integer year, Integer fromYear, Integer toYear, Double fromPrice, Double toPrice) {
        return movieRepository.getByParams(term, genre, year, fromYear, toYear, fromPrice, toPrice);
    }

    public List<MovieDTO> getByParamsMap(@RequestParam Map<String, Objects> queryParams) {
        return movieRepository.getByParamsMap(queryParams);
    }

    public List<MovieDTO> getByParamsClass(MovieFilter movieFilter) {
        return movieRepository.getByParamsClass(movieFilter);
    }
}
