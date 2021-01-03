package com.polimi.nightdream.controller;

import com.polimi.nightdream.repository.AppartamentoRepository;
import com.polimi.nightdream.model.Appartamento;
import com.polimi.nightdream.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@RestController
@RequestMapping("/api/controller/appartamentoes")
public class AppartamentoController {
    @Autowired
    private AppartamentoRepository appartamentoRepository;

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @PostMapping("/insert")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Appartamento insertAppartamento(@RequestBody Appartamento appartamento){
        if (appartamentoRepository.getByNome(appartamento.getNome()) == null){
            return appartamentoRepository.save(appartamento);
        }
        return null;
    }

    @PutMapping("/modify")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Appartamento modifyAppartamento(@RequestBody Appartamento appartamento){
        return appartamentoRepository.save(appartamento);
    }

    /*@DeleteMapping("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Appartamento deleteAppartamento(@PathVariable(name = "id") Integer id){
        Appartamento appartamento = appartamentoRepository.getById(id);
        if
        appartamentoRepository.deleteById(id);
    }*/

    /*@GetMapping("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Appartamento getAppartamento(@PathVariable(name = "id") Integer id){
        Appartamento appartamento = appartamentoRepository.getById(id);
        appartamento.setNome("TEST");
        return appartamento;
    }*/

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
