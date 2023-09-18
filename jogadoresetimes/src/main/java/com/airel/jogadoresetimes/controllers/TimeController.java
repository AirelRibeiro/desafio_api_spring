package com.airel.jogadoresetimes.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airel.jogadoresetimes.entities.Jogador;
import com.airel.jogadoresetimes.services.JogadorService;
import com.airel.jogadoresetimes.services.TimeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TimeController {

  @Autowired
  JogadorService jogadorService;

  @GetMapping("/times")
  public Map<String, List<String>> obterTodosJogadores() {
    List<String> nomesJogadores = new ArrayList<>();
    for (Jogador jogador : jogadorService.obterTodosJogadores()) {
      nomesJogadores.add(jogador.getNome());
    }
    return TimeService.organizarTimes(nomesJogadores);
  }

}
