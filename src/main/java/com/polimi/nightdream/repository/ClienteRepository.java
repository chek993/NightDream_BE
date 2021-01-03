package com.polimi.nightdream.repository;

import com.polimi.nightdream.model.Cliente;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Integer>{

    Cliente getByNome(String nome);
}
