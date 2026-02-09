package com.movie.repo;

import com.movie.model.ShowSeat;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShowSeatRepository {

    //@Lock(LockModeType.PESSIMISTIC_WRITE)
    public List<ShowSeat> findByShowIdAndSeatNumberIn(Long showId, List<String> seats){
        return null;
    }
}
