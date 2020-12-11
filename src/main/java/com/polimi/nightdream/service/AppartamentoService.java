package com.polimi.nightdream.service;

import com.polimi.nightdream.repository.AppartamentoRepository;
import com.polimi.nightdream.model.Appartamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Service
@RestController
public class AppartamentoService {
    @Autowired
    private AppartamentoRepository appartamentoRepository;

    @GetMapping("/api/appartamentoes/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Appartamento getAppartamento(@PathVariable(name = "id") Integer id){
        Appartamento appartamento = appartamentoRepository.getById(id);
        appartamento.setNome("TEST");
        return appartamento;
    }

    /*@PostMapping("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Appartamento findAppartamento(@RequestBody Appartamento appartamento1){
        return appartamento.getById(appartamento1.getId());
    }

    @GetMapping ("/nome/{nome}")
    @Produces(MediaType.TEXT_HTML)
    public String getAppartamento(@RequestParam("nome") String nome){
        //return appartamento.getByNome(nome);
        return "ciao";
    }*/

}
