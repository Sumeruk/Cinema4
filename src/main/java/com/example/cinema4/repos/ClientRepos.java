package com.example.cinema4.repos;

import com.example.cinema4.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepos extends CrudRepository<Client, Long> {
}
