package com.polimi.nightdream.service;

import com.polimi.nightdream.model.Prenotazione;
import com.polimi.nightdream.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;

@Service
@RestController
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @PostMapping("/api/control/prenotaziones")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Prenotazione insertPrenotazione(@RequestBody Prenotazione prenotazione){
        if (prenotazioneRepository.getConflictsForDates(prenotazione.getAppartamento().getId(), prenotazione.getDataInizio(), prenotazione.getDataFine()) == 0){
            prenotazione.setCreationTime(LocalDateTime.now());
            return prenotazioneRepository.save(prenotazione);
        }
        return null;
    }

}
