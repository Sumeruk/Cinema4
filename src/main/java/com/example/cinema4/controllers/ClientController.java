package com.example.cinema4.controllers;

import com.example.cinema4.DTO.ClientDTO;
import com.example.cinema4.entity.Client;
import com.example.cinema4.repos.ClientRepos;
import com.example.cinema4.servicies.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ClientController {
    private final ClientRepos clientRepos;
    private final ClientService clientService;
    private List<Client> clients;

    @GetMapping("/clients")
    public String getClient(Model model) {
        model.addAttribute("client", new ClientDTO());
        clients = clientRepos.findAllDESC();
        model.addAttribute("clients", clients);
        return "Client";
    }

    @PostMapping("/clients/newClient")
    public String saveOrCheckClient(@ModelAttribute("client") ClientDTO clientDTO, @RequestParam String submitButton,
                                    Model model) {

        clientService.processingInputData(clientDTO);
        if (submitButton.equals("checkButton")) {
            clients = clientService.getClient(clientDTO.getName());
            if (clients.isEmpty()) {
                return "redirect:/clients";
            }
            return "redirect:/clients/foundClients";
        }
        return "redirect:/clients";
    }

    @GetMapping("/clients/foundClients")
    public String getFoundClient(@ModelAttribute("inName") String name, Model model) {
        System.out.println(clientRepos.findClientByName(name));
        model.addAttribute("client", new ClientDTO());
        model.addAttribute("hrefClients", clientRepos.findClientByName(name));
        return "Client";
    }
}
