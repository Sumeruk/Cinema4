package com.example.cinema4.servicies;

import com.example.cinema4.DTO.HallTicketDTO;
import com.example.cinema4.repos.HallRepos;
import com.example.cinema4.repos.TicketRepos;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@Data
@RequiredArgsConstructor
public class TicketService {
    private final HallRepos hallRepos;
    private final TicketRepos ticketRepos;
    private List<HallTicketDTO> hallTicketDTOList;

    public Map<Integer, List<Integer>> getFreeSeats(List<HallTicketDTO> hallTicketDTOList){
        if(hallTicketDTOList.isEmpty()){
            System.out.println("Cписок пуст");
            return new HashMap<>();
        }

        Long num_hall = hallTicketDTOList.get(0).getNum_hall();
        Long session_id = hallTicketDTOList.get(0).getSession_id();

        int totalSeatsInRow = hallRepos.findNum_of_seat_rowByNum_hall(num_hall);
        int totalRow = hallRepos.findNum_of_rowByNum_hall(num_hall);

        Map<Integer, List<Integer>> occupied_places = getOccupied_places(totalRow, num_hall, session_id);

        //System.out.println("getFreeSeats" + findingFree_places(totalRow, totalSeatsInRow, occupied_places));
        return findingFree_places(totalRow, totalSeatsInRow, occupied_places);
    }

    private Map<Integer, List<Integer>> getOccupied_places(int totalRow, Long num_hall, Long session_id){
        Map<Integer, List<Integer>> occupied_places = new HashMap<>();

        for(int num_of_row = 1; num_of_row <= totalRow; num_of_row++){
            List<Integer> occupied_places_in_row = hallRepos.findOccupiedSeatsInRow(num_of_row, num_hall, session_id);

            occupied_places.put(num_of_row, occupied_places_in_row);
        }
        //System.out.println("getOccupied_places" + occupied_places);
        return occupied_places;
    }

    private Map<Integer, List<Integer>> findingFree_places(int totalRow, int totalSeatsInRow,
                                                           Map<Integer, List<Integer>> occupied_places){

        Map<Integer, List<Integer>> freeSeats = new HashMap<>();

        List<Integer> freeSeatsInRow = IntStream.rangeClosed(1,totalSeatsInRow).boxed().toList();

        for(int num_of_row = 1; num_of_row <= totalRow; num_of_row++){
            List<Integer> occupiedSeatsInRow = occupied_places.get(num_of_row);

            List<Integer> diff = new ArrayList<>(freeSeatsInRow);
            occupiedSeatsInRow.forEach(diff::remove);

            freeSeats.put(num_of_row,diff);
            //System.out.println("freeSeats" + freeSeats);
        }
        return freeSeats;
    }


}
