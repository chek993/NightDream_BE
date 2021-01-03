package com.polimi.nightdream.repository;

import com.polimi.nightdream.model.Proprietario;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProprietarioRepository extends PagingAndSortingRepository<Proprietario, Integer> {

    Proprietario getByEmail(String email);

    Proprietario getByEmailAndPassword(String email, String password);
}
