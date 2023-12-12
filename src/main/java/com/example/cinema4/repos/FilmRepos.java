package com.example.cinema4.repos;

import com.example.cinema4.entity.Film;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepos extends CrudRepository<Film, Long> {
//    @Query("SELECT name_film FROM \"Film\"")
//    List<String> findFilm_id();

    @Query("SELECT * FROM \"Film\" WHERE name_film = :name")
    List<Film> findAllByName_film(@Param("name") String name_film);

    @Query("SELECT film_id FROM \"Film\" WHERE name_film = :name_film")
    Integer findFilm_idByName_film(@Param("name_film") String name_film);
    @Query("SELECT * FROM \"Film\" WHERE film_id = :fId")
    Film findFilmByFilm_id(@Param("fId") Long fId);
}
