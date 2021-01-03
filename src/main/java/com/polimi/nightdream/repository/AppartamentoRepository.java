package com.polimi.nightdream.repository;

import com.polimi.nightdream.model.Appartamento;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppartamentoRepository extends PagingAndSortingRepository<Appartamento, Integer> {

    Appartamento getByNome(String nome);

    void deleteById(Integer id);
}
