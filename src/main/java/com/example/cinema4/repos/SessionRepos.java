package com.example.cinema4.repos;

import com.example.cinema4.entity.Film;
import com.example.cinema4.entity.Session;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepos extends CrudRepository<Session, Long> {
}
