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
    @Query("SELECT S.session_id, S.num_hall, S.time_of_start, F.name_film" +
            " from public.\"Session\" S " +
            "join public.\"Film\" F " +
            "on F.film_id = S.film_id " +
            "where name_film = :name_film")
    List<Session> findAllByNameFilm(@Param("name_film") String name_film);

    @Query("SELECT name_film, session_id, time_of_start, date_film" +
            " FROM \"Film\" JOIN \"Session\" USING(film_id)" +
            "ORDER BY date_film, time_of_start")
    List<FilmSessionDTO> findAllWithNameFilm();
    @Query("SELECT film_id FROM \"Film\" WHERE name_film = :name_film")
    Integer findSession_idByName_film(@Param("name_film") String name_film);


}
