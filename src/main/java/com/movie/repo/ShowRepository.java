package com.movie.repo;

import com.movie.model.Show;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class ShowRepository {
    List<Show> findByMovieNameAndCityAndShowTimeBetween(
            String movie, String city, LocalDateTime start, LocalDateTime end){
        return null;
    }
}
