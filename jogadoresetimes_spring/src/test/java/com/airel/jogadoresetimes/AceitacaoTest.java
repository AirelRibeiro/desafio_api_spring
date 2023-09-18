package com.airel.jogadoresetimes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.airel.jogadoresetimes.services.TimeService;

public class AceitacaoTest {

    @Test
    public void testOrganizarTimes() {

        // Caso de teste 1: Nenhum jogador
        List<String> jogadores1 = Arrays.asList();
        Map<String, List<String>> times1 = TimeService.organizarTimes(jogadores1);
        assertEquals(0, times1.size(), "Caso de teste 1: Nenhum jogador");

        // Caso de teste 2: Jogadores com sobrenomes diferentes
        List<String> jogadores2 = Arrays.asList("Lionel Messi", "Cristiano Ronaldo", "Neymar Jr.");
        Map<String, List<String>> times2 = TimeService.organizarTimes(jogadores2);
        assertEquals(3, times2.size(), "Caso de teste 2: Jogadores com sobrenomes diferentes");

        // Caso de teste 3: Um time com dois jogadores do mesmo sobrenome
        List<String> jogadores3 = Arrays.asList("Lionel Messi", "Lucas Messi", "Neymar Jr.");
        Map<String, List<String>> times3 = TimeService.organizarTimes(jogadores3);
        assertEquals(3, times3.size(), "Caso de teste 3: Um time com dois jogadores do mesmo sobrenome");

        // Caso de teste 4: Dois times com dois jogadores do mesmo sobrenome
        List<String> jogadores4 = Arrays.asList("Lionel Messi", "Lucas Messi", "Cristiano Ronaldo", "Carlos Ronaldo");
        Map<String, List<String>> times4 = TimeService.organizarTimes(jogadores4);
        assertEquals(4, times4.size(), "Caso de teste 4: Dois times com dois jogadores do mesmo sobrenome");

        // Caso de teste 5: Jogadores com sobrenomes diferentes e iguais em letras
        // diferentes
        List<String> jogadores5 = Arrays.asList("Lionel Messi", "Lucas Messi", "Cristiano Ronaldo", "Carlos Ronaldo",
                "Neymar Jr.");
        Map<String, List<String>> times5 = TimeService.organizarTimes(jogadores5);
        assertEquals(5, times5.size(),
                "Caso de teste 5: Jogadores com sobrenomes diferentes e iguais em letras diferentes");

        // Caso de teste 6: Todos os jogadores com o mesmo sobrenome
        List<String> jogadores6 = Arrays.asList("Neymar Jr.", "Neymar Jr.", "Neymar Jr.");
        Map<String, List<String>> times6 = TimeService.organizarTimes(jogadores6);
        assertEquals(3, times6.size(), "Caso de teste 6: Todos os jogadores com o mesmo sobrenome");

        // Caso de teste 7: Nomes com letras maiúsculas e minúsculas misturadas
        List<String> jogadores7 = Arrays.asList("Lionel Messi", "lucas messi", "Cristiano Ronaldo", "carlos Ronaldo",
                "Neymar Jr.");
        Map<String, List<String>> times7 = TimeService.organizarTimes(jogadores7);
        assertEquals(5, times7.size(), "Caso de teste 7: Nomes com letras maiúsculas e minúsculas misturadas");

        // Caso de teste 8: Nomes com acentos
        List<String> jogadores8 = Arrays.asList("José Silva", "João Sá", "Maria Alves", "Ângela Pereira");
        Map<String, List<String>> times8 = TimeService.organizarTimes(jogadores8);
        assertEquals(3, times8.size(), "Caso de teste 8: Nomes com acentos");

        // Caso de teste 10: Jogadores com sobrenomes iniciados por números
        List<String> jogadores10 = Arrays.asList("Lionel Messi", "Cristiano Ronaldo", "Neymar Jr.", "123ABC Adams",
                "1st Place");
        Map<String, List<String>> times10 = TimeService.organizarTimes(jogadores10);
        assertEquals(5, times10.size(), "Caso de teste 10: Jogadores com sobrenomes iniciados por números");
    }

}
