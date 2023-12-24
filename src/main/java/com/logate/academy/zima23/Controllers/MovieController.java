package com.logate.academy.zima23.Controllers;

import com.logate.academy.zima23.DTO.MovieDTO;
import com.logate.academy.zima23.Filters.MovieFilter;
import com.logate.academy.zima23.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(path="/api/movies", method = RequestMethod.GET)
    public ResponseEntity<List<MovieDTO>> getAll() {
        List<MovieDTO> MovieDTOList = movieService.getAll();
        return new ResponseEntity<> (MovieDTOList, HttpStatus.OK);
    }

    @RequestMapping(path="/api/movies/{id}", method = RequestMethod.GET)
    public ResponseEntity<MovieDTO> getById (@PathVariable(value="id") Integer id) {
        MovieDTO movieDTO = movieService.getById(id);
        if(movieDTO != null) return new ResponseEntity<> (movieDTO, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path="/api/movies/movies-by-params", method = RequestMethod.GET)
    public ResponseEntity<List<MovieDTO>> getByParams(@QueryParam("term") String term,
                                                      @QueryParam("genre") String genre,
                                                      @QueryParam("year") Integer year,
                                                      @QueryParam("fromYear") Integer fromYear,
                                                      @QueryParam("toYear") Integer toYear,
                                                      @QueryParam("fromPrice") Double fromPrice,
                                                      @QueryParam("toPrice") Double toPrice) {
        List<MovieDTO> MovieDTOList = movieService.getByParams(term, genre, year, fromYear, toYear, fromPrice, toPrice);
        return new ResponseEntity<> (MovieDTOList, HttpStatus.OK);
    }

    @RequestMapping(path="/api/movies/movies-by-params-map", method = RequestMethod.GET)
    public ResponseEntity<List<MovieDTO>> getByParamsMap(@RequestParam Map<String, Objects> queryParams) {
        List<MovieDTO> movieDTOList = movieService.getByParamsMap(queryParams);
        return new ResponseEntity<>(movieDTOList, HttpStatus.OK);
    }

    @RequestMapping(path="/api/movies/movies-by-params-class", method = RequestMethod.GET)
    public ResponseEntity<List<MovieDTO>> getByParamsClass(@ModelAttribute MovieFilter movieFilter){
        List<MovieDTO> movieDTOList = movieService.getByParamsClass(movieFilter);
        return new ResponseEntity<>(movieDTOList, HttpStatus.OK);
    }
}
