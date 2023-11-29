package com.example.cinema4.controllers;

import com.example.cinema4.DTO.ClientDTO;
import com.example.cinema4.entity.Client;
import com.example.cinema4.repos.ClientRepos;
import com.example.cinema4.servicies.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ClientController {
    private final ClientRepos clientRepos;
    private final ClientService clientService;

    @GetMapping("/clients")
    public String getClient(Model model){
        model.addAttribute("newClient", new ClientDTO());
        model.addAttribute("clients", clientRepos.findAll());
        return "Client";
    }

    @PostMapping("/clients/newClient")
    public String saveClient(@ModelAttribute("newClient") ClientDTO clientDTO){
        clientService.processingInputData(clientDTO);
        return "redirect:/clients";
    }
}
