package com.airel.jogadoresetimes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.airel.jogadoresetimes.entities.Jogador;
import com.airel.jogadoresetimes.services.JogadorService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class JogadorController {

  @Autowired
  JogadorService jogadorService;

  @PostMapping("/jogador")
  public void adicionarJogador(@RequestBody Jogador jogador) {
    try {
      jogadorService.adicionarJogador(jogador);
    } catch (Exception e) {
      throw e;
    }
  }

  @GetMapping("/jogador")
  public List<Jogador> obterTodosJogadores() {
    return jogadorService.obterTodosJogadores();
  }

  @DeleteMapping("/jogador/all")
  public void deletarTodosJogadores() {
    jogadorService.deletarTodosJogadores();
  }

}
