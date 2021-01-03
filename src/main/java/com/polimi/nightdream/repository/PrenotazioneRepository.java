package com.polimi.nightdream.repository;

import com.polimi.nightdream.model.Prenotazione;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneRepository extends PagingAndSortingRepository<Prenotazione, Integer> {

    Prenotazione getById(Integer id);

    //restituisce il numero di conflitti di prenotazione in base alle date (può essere 0 o 1)
    @Query(value = "SELECT count(*) as num_conflicts FROM prenotazione WHERE appartamento_id = :appartamento_id and (data_inizio <= :checkOut) and (data_fine >= :checkIn)", nativeQuery = true)
    int getConflictsForDates(Integer appartamento_id, LocalDate checkIn, LocalDate checkOut);

    @Query(value = "SELECT p.* FROM prenotazione p, appartamento a WHERE p.appartamento_id = a.id and a.proprietario_id = :proprietarioId ORDER BY a.nome DESC", nativeQuery = true)
    List<Prenotazione> getPrenotazioniByProprietarioId(Integer proprietarioId);

    /*@Query(value = "SELECT count(*) as num_prenotazioni FROM prenotazione WHERE appartamento_id = :appartamento_id and (creation_time <= :nowTime) and (data_fine >= :nowDate)", nativeQuery = true)
    int getConflictsForModify(Integer appartamento_id, LocalDateTime nowTime, LocalDate nowDate);*/

}
