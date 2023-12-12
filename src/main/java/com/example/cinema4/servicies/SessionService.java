package com.example.cinema4.servicies;

import com.example.cinema4.DTO.SessionDTO;
import com.example.cinema4.entity.Session;
import com.example.cinema4.repos.FilmRepos;
import com.example.cinema4.repos.HallRepos;
import com.example.cinema4.repos.SessionRepos;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@Data
@Service
@RequiredArgsConstructor
public class SessionService {
    //private final SessionDTO sessionDTO;
    private final SessionRepos sessionRepos;
    private final FilmRepos filmRepos;
    private final HallRepos hallRepos;
    private boolean result = true;

    public void saveUpdSession(Session oldSession, SessionDTO sessionDTO){
        String time_of_start = sessionDTO.getTime_of_start();
        String date_film = sessionDTO.getDate_film();
        Long filmId = sessionDTO.getFilm_id();
        int num_hall = sessionDTO.getNumHall();

        if (!Objects.equals(num_hall, 0)) {
            oldSession.setNumHall(num_hall);
        }

        if(!Objects.equals(time_of_start, "")){
            oldSession.setTime_of_start(treatmentTime(time_of_start));
        }

        if (filmId != -1){
            oldSession.setFilmId(filmId);
        }

        if(!Objects.equals(date_film, "")){
            oldSession.setDate_film(treatmentDate(date_film));
        }

        sessionRepos.save(oldSession);

    }

    public void processingInputData(SessionDTO sessionDTO) {
        String time_of_start = sessionDTO.getTime_of_start();
        String date_film = sessionDTO.getDate_film();
        Long filmId = sessionDTO.getFilm_id();
        Integer num_hall = sessionDTO.getNumHall();

        Time inTime = treatmentTime(time_of_start);
        Date inDate = treatmentDate(date_film);

        saveSession(num_hall, inTime, inDate, filmId);
    }

    private void saveSession(Integer num_hall, Time inputTime, Date inputDate, Long filmId){
        Session newSession = new Session(num_hall, inputTime, filmId, inputDate);
        sessionRepos.save(newSession);
    }

    private Time treatmentTime(String timeString){
        return Time.valueOf(timeString + ":00");
    }

    private Date treatmentDate(String dateString){return Date.valueOf(dateString);}


}
