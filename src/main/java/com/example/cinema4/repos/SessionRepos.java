package com.example.cinema4.repos;

import com.example.cinema4.entity.Session;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionRepos extends CrudRepository<Session, Long> {
    @Query("SELECT S.session_id, S.num_hall, S.time_of_start, F.name_film" +
            " from public.\"Session\" S " +
            "join public.\"Film\" F " +
            "on F.film_id = S.film_id " +
            "where name_film = :name_film")
    List<Session> findAllByNameFilm(@Param("name_film") String name_film);


}
