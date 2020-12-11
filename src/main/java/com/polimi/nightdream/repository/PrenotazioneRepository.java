package com.polimi.nightdream.repository;

import com.polimi.nightdream.model.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer>, JpaSpecificationExecutor<Prenotazione> {

    Prenotazione getById(Integer id);

    //restituisce il numero di conflitti di prenotazione in base alle date (può essere 0 o 1)
    @Query(value = "select count(*) as num_conflicts from prenotazione where appartamento_id = :appartamento_id and (data_inizio <= :checkOut) and (data_fine >= :checkIn)", nativeQuery = true)
    int getConflictsForDates(Integer appartamento_id, LocalDate checkIn, LocalDate checkOut);
}
