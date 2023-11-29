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

@Data
@Service
@RequiredArgsConstructor
public class SessionService {
    //private final SessionDTO sessionDTO;
    private final SessionRepos sessionRepos;
    private final FilmRepos filmRepos;
    private final HallRepos hallRepos;
    private boolean result = true;

    public void processingInputData(SessionDTO sessionDTO) {
        String time_of_start = sessionDTO.getTime_of_start();
        String date_film = sessionDTO.getDate_film();
        String name_film = sessionDTO.getFilm_name();
        Integer num_hall = sessionDTO.getNumHall();

        Time inTime = treatmentTime(time_of_start);
        Date inDate = treatmentDate(date_film);

//todo сделать нормальный поиск фильма

        Integer filmId = filmRepos.findFilm_idByName_film(name_film);

        saveSession(num_hall, inTime, inDate, filmId);
    }

    private void saveSession(Integer num_hall, Time inputTime, Date inputDate, Integer filmId){
        Session newSession = new Session(num_hall, inputTime, filmId, inputDate);
        sessionRepos.save(newSession);
    }

    private Time treatmentTime(String timeString){
        return Time.valueOf(timeString + ":00");
    }

    private Date treatmentDate(String dateString){return Date.valueOf(dateString);}


}
