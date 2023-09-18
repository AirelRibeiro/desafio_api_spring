package com.airel.jogadoresetimes.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.airel.jogadoresetimes.entities.Time;

@Service
public class TimeService {

  public static Map<String, List<String>> organizarTimes(List<String> jogadores) {
    // Cria um mapa para armazenar os grupos de jogadores com base na primeira letra
    // do sobrenome.
    Map<String, List<String>> grupos = new HashMap<>();

    // Itera sobre a lista de jogadores.
    for (String jogador : jogadores) {
      // Divide o nome do jogador em partes usando um espaço como separador.
      String[] partesDoNome = jogador.split(" ");

      // Verifica se o nome do jogador tem duas partes (nome e sobrenome).
      if (partesDoNome.length != 2) {
        continue; // Ignora jogadores com nomes inválidos.
      }

      // Obtém o sobrenome do jogador.
      String sobrenome = partesDoNome[1];

      // Obtém a primeira letra do sobrenome.
      char primeiraLetraCharacter = sobrenome.toUpperCase().charAt(0);
      String primeiraLetraString = String.valueOf(primeiraLetraCharacter);

      // Define a chave para o grupo com base na primeira letra do sobrenome.
      String chave = primeiraLetraString;

      // Verifica se a chave já está presente no mapa de grupos.
      if (grupos.containsKey(primeiraLetraString)) {
        // Verifica se o sobrenome do jogador já está em algum grupo existente.
        boolean sobrenomeRepetido = grupos.get(primeiraLetraString).stream()
            .anyMatch(nomeExistente -> nomeExistente.toLowerCase().endsWith(sobrenome.toLowerCase()));

        if (sobrenomeRepetido) {
          // Se o sobrenome estiver repetido, encontra todas as chaves com a mesma letra.
          List<String> chavesComLetra = new ArrayList<>();

          for (String key : grupos.keySet()) {
            if (key.contains(primeiraLetraString)) {
              boolean repetido = grupos.get(key).stream()
                  .anyMatch(nomeExistente -> nomeExistente.toLowerCase().endsWith(sobrenome.toLowerCase()));
              if (repetido) {
                chavesComLetra.add(key);
              } else {
                // Adiciona o jogador ao grupo e interrompe o loop.
                grupos.computeIfAbsent(key, k -> new ArrayList<>()).add(jogador);
                break;
              }
            }
          }
          // Cria uma nova chave baseada na repetição da primeira letra.
          char[] caracteres = new char[chavesComLetra.size() + 1];
          Arrays.fill(caracteres, primeiraLetraCharacter);
          chave = new String(caracteres);
        }
      }

      // Adiciona o jogador ao grupo correspondente no mapa.
      grupos.computeIfAbsent(chave, k -> new ArrayList<>()).add(jogador);
    }

    // Cria um novo mapa para representar os times com base nos grupos.
    Map<String, List<String>> times = new HashMap<>();

    // Itera sobre os grupos e cria nomes de times com base na primeira letra da
    // chave.
    for (Map.Entry<String, List<String>> entry : grupos.entrySet()) {
      String chave = entry.getKey();
      List<String> grupo = entry.getValue();
      char primeiraLetraDaChave = chave.charAt(0);

      // Define o nome do time como "Time" + primeira letra da chave + tamanho da
      // chave.
      Time time = new Time("Time " + primeiraLetraDaChave + chave.length(), grupo);
      times.put(time.getNome() + ": ", time.getJogadores());
    }

    // Retorna o mapa final com nomes de times formatados e constendo as listas de
    // jogadores.
    return times;
  }
}
