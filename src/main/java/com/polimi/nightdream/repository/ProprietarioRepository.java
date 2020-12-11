package com.polimi.nightdream.repository;

import com.polimi.nightdream.model.Proprietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProprietarioRepository extends JpaRepository<Proprietario, Integer>, JpaSpecificationExecutor<Proprietario> {

    Proprietario getByNome(String nome);
}
