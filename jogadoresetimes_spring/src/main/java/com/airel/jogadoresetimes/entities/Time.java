package com.airel.jogadoresetimes.entities;

import java.util.List;

public class Time {
  private String nome;
  private List<String> jogadores;

  public Time(String nome, List<String> jogadores) {
    this.nome = nome;
    this.jogadores = jogadores;
  }

  public String getNome() {
    return nome;
  }

  public List<String> getJogadores() {
    return jogadores;
  }
}
