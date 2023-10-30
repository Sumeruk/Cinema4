package com.example.cinema4.repos;

import com.example.cinema4.entity.Film;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepos extends CrudRepository<Film, Long> {
}
