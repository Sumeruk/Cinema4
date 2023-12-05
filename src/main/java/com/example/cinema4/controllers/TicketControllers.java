package com.example.cinema4.controllers;

import com.example.cinema4.DTO.HallTicketCartDTO;
import com.example.cinema4.DTO.HallTicketDTO;
import com.example.cinema4.DTO.SessionDTO;
import com.example.cinema4.entity.Film;
import com.example.cinema4.entity.Ticket;
import com.example.cinema4.repos.ClientRepos;
import com.example.cinema4.repos.SessionRepos;
import com.example.cinema4.repos.TicketRepos;
import com.example.cinema4.servicies.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class TicketControllers {

    private final TicketRepos ticketRepos;
    private final TicketService ticketService;
    private final ClientRepos clientRepos;
    private final SessionRepos sessionRepos;
    @Autowired
    private HallTicketCartDTO hallTicketCartDTO;

    @GetMapping("/tickets")
    public String getTickets(Model model){
        model.addAttribute("newTicket", new HallTicketDTO());
        model.addAttribute("ticketsInCart",  hallTicketCartDTO);
        return "Tickets";
    }

    @GetMapping("/tickets/{sessionId}")
    public String processingReceiptsFromSession(@PathVariable Integer sessionId){
        hallTicketCartDTO = new HallTicketCartDTO();
        return "redirect:/tickets/cart/{sessionId}";
    }

    @GetMapping("/tickets/cart/{sessionId}")
    public String getFreeTicketsBySession(@ModelAttribute("newTicket") HallTicketDTO hallTicketDTO,
                                          Model model, @PathVariable Integer sessionId){


        model.addAttribute("ticketsInCart",  hallTicketCartDTO);

        List<HallTicketDTO> hallTicketDTOS = ticketRepos.findTicketsBySession_id(sessionId);
        Map<Integer, List<Integer>> freeSeats = ticketService.getFreeSeats(hallTicketDTOS, sessionId);

        model.addAttribute("tickets", hallTicketDTOS);
        model.addAttribute("keys", freeSeats.keySet());
        model.addAttribute("freeSeats", freeSeats);

        //model.addAttribute("values", new ArrayList<>());
        return "Tickets";
    }

    @PostMapping("/tickets/cart/{sessionId}")
    public String setRow(Model model, @PathVariable Integer sessionId,
                         @ModelAttribute("newTicket") HallTicketDTO hallTicketDTO) {

        hallTicketDTO.setNum_hall(Long.valueOf(sessionRepos.findNumHallBySession_id(Long.valueOf(sessionId))));
        hallTicketDTO.setSession_id(Long.valueOf(sessionId));
        hallTicketDTO.setPrice(250);

        hallTicketCartDTO.addToCart(hallTicketDTO);

        return "redirect:/tickets/cart/{sessionId}";
    }

    @GetMapping("/ticket/saveCart")
    public String goToClients(){
        return "redirect:/clients";
    }

    @GetMapping("/tickets/buyTicket/{client}")
    public String getTicketsAndClient(Model model, @PathVariable Integer client){
        model.addAttribute("infoFromCart", hallTicketCartDTO.getList());
        model.addAttribute("clientInfo", clientRepos.findClientByClient_id(Long.valueOf(client)));
        return "BuyTicket";
    }

    @PostMapping("/tickets/buyTicket/{client}")
    public String saveTickets(@PathVariable Long client){
        ticketService.saveCartOfTickets(hallTicketCartDTO, client);
        return "index";
    }


}
