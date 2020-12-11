package com.polimi.nightdream.repository;

import com.polimi.nightdream.model.Appartamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppartamentoRepository extends JpaRepository<Appartamento, Integer>, JpaSpecificationExecutor<Appartamento> {

    Appartamento getById(Integer id);
    Appartamento getByNome(String nome);

    @Override
    List<Appartamento> findAll();
}
