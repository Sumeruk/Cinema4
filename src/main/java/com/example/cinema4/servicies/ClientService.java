package com.example.cinema4.servicies;

import com.example.cinema4.DTO.ClientDTO;
import com.example.cinema4.DTO.SessionDTO;
import com.example.cinema4.entity.Client;
import com.example.cinema4.repos.ClientRepos;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
@Data
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepos clientRepos;

    public void processingInputData(ClientDTO clientDTO) {
        String name = clientDTO.getName();
        String birthdayString = clientDTO.getBirthday();

        Date birthday = treatmentDate(birthdayString);

        saveClient(name, birthday);
    }

    private void saveClient(String name, Date birthday) {
        Client client = new Client();
        client.setName(name);
        client.setBirthday(birthday);

        clientRepos.save(client);
    }

    private Date treatmentDate(String dateString) {
        return Date.valueOf(dateString);
    }
}
