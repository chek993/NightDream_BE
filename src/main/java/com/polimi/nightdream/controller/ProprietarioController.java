package com.polimi.nightdream.controller;

import com.polimi.nightdream.model.Proprietario;
import com.polimi.nightdream.repository.ProprietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Service
@RestController
@RequestMapping("/api/controller/proprietarioes")
public class ProprietarioController {
    @Autowired
    private ProprietarioRepository proprietarioRepository;

    @PostMapping("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Proprietario insertProprietario(@RequestBody Proprietario proprietario){
        if (proprietarioRepository.getByEmail(proprietario.getEmail()) == null){
            return proprietarioRepository.save(proprietario);
        }
        return null;
    }

    @GetMapping("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Proprietario getProprietario(@RequestBody Proprietario proprietario){
        return proprietarioRepository.getByEmailAndPassword(proprietario.getEmail(), proprietario.getPassword());
    }

}
