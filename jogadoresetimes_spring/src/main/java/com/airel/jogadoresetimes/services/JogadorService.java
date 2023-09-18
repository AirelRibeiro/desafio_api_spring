package com.airel.jogadoresetimes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airel.jogadoresetimes.entities.Jogador;
import com.airel.jogadoresetimes.repositories.JogadorRepository;

@Service
public class JogadorService {

  @Autowired
  JogadorRepository jogadorRepository;

  public String adicionarJogador(Jogador jogador) {
    try {
      jogadorRepository.adicionarJogador(jogador);
      return "Jogador inserido com sucesso!";
    } catch (Exception e) {
      throw e;
    }
  }

  public List<Jogador> obterTodosJogadores() {
    return jogadorRepository.obterTodosJogadores();
  }

  public void deletarTodosJogadores() {
    jogadorRepository.deletarTodosJogadores();
  }

}
