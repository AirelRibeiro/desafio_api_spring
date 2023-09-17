package com.airel.jogadoresetimes.repositories;

import java.util.ArrayList;
import java.util.List;

import com.airel.jogadoresetimes.entities.Jogador;

public class JogadorRepository {

  private List<Jogador> jogadores = new ArrayList<>();

  public void adicionarJogador(Jogador jogador) {
    jogadores.add(jogador);

  }

  public List<Jogador> obterTodosJogadores() {
    return jogadores;
  }

  public void deletarTodosJogadores() {
    jogadores.clear();
  }

}
