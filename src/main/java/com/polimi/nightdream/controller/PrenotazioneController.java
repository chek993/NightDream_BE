package com.polimi.nightdream.controller;

import com.polimi.nightdream.model.Prenotazione;
import com.polimi.nightdream.repository.AppartamentoRepository;
import com.polimi.nightdream.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@RestController
@RequestMapping("/api/controller/prenotazione")
public class PrenotazioneController
{
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private AppartamentoRepository appartamentoRepository;


    @GetMapping("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Prenotazione> getPrenotazioniByProprietarioId(@PathVariable(name = "id") Integer id){
        return prenotazioneRepository.getPrenotazioniByProprietarioId(id);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllPrenotazioni(){
        return ResponseEntity.ok(prenotazioneRepository.findAll());

    }

    //return NULL = data_fine <= data_inizio || appartamento non disponibile per quelle date
    @PostMapping("/insert")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Prenotazione insertPrenotazione(@RequestBody Prenotazione prenotazione){

        long giorniTot = DAYS.between(prenotazione.getDataInizio(), prenotazione.getDataFine());

        if(giorniTot >= 1) {
            if (prenotazioneRepository.getConflictsForDates(prenotazione.getAppartamento().getId(), prenotazione.getDataInizio(), prenotazione.getDataFine()) == 0) {
                prenotazione.setCreationTime(LocalDateTime.now());
                prenotazione.setTotale((giorniTot * appartamentoRepository.findById(prenotazione.getAppartamento().getId()).get().getPrezzo()));
                return prenotazioneRepository.save(prenotazione);
            }
        }
        return null;
    }

}