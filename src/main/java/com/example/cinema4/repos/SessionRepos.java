package com.example.cinema4.repos;

import com.example.cinema4.DTO.FilmSessionDTO;
import com.example.cinema4.entity.Session;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SessionRepos extends CrudRepository<Session, Long> {

    @Query("SELECT name_film, session_id, time_of_start, date_film" +
            " FROM \"Film\" JOIN \"Session\" USING(film_id)" +
            "ORDER BY date_film, time_of_start")
    List<FilmSessionDTO> findAllWithNameFilm();
    @Query("SELECT num_hall, name_film, session_id, time_of_start, date_film" +
            " FROM \"Film\" JOIN \"Session\" USING(film_id)" +
            "WHERE session_id = :session_id")
    FilmSessionDTO findAllWithNameFilmBySession_id(@Param("session_id") Long session_id);

    @Query("SELECT num_hall FROM \"Session\" WHERE session_id = :session_id")
    Integer findNumHallBySession_id(@Param("session_id") Long session_id);
    @Query("SELECT * FROM \"Session\" WHERE session_id = :session_id")
    Session findSessionBySession_id(@Param("session_id") Long session_id);


}
