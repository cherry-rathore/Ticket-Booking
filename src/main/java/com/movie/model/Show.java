package com.movie.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class Show {

    private Long id;
    private String movieName;
    private String city;
    private LocalDateTime showTime;
}
