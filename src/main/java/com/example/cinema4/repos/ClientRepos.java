package com.example.cinema4.repos;

import com.example.cinema4.entity.Client;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepos extends CrudRepository<Client, Long> {

    @Query("SELECT * FROM \"Client\" WHERE name = :name")
    List<Client> findClientByName(@Param("name") String name);

    @Query("SELECT * FROM \"Client\" ORDER BY client_id DESC")
    List<Client> findAllDESC();
    @Query("SELECT * FROM \"Client\" WHERE client_id = :id")
    Client findClientByClient_id(@Param("id") Long id);
}
