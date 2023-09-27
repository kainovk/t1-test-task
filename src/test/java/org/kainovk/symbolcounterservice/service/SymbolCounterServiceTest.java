package org.kainovk.symbolcounterservice.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class SymbolCounterServiceTest {

    @Autowired
    private SymbolCounterService symbolCounterService;

    @Test
    public void testCountSymbolsEmptyString() {
        Map<Character, Integer> result = symbolCounterService.countSymbols("");
        assertTrue(result.isEmpty());
    }


    @Test
    public void testCountSymbolsSingleCharacter() {
        Map<Character, Integer> result = symbolCounterService.countSymbols("a");
        assertEquals(1, result.size());
        assertEquals(1, result.get('a').intValue());
    }

    @Test
    public void testCountSymbolsDistinctCharacters() {
        Map<Character, Integer> result = symbolCounterService.countSymbols("abcdefg");
        assertEquals(7, result.size());
        assertEquals(1, result.get('a').intValue());
        assertEquals(1, result.get('b').intValue());
        assertEquals(1, result.get('c').intValue());
        assertEquals(1, result.get('d').intValue());
        assertEquals(1, result.get('e').intValue());
        assertEquals(1, result.get('f').intValue());
        assertEquals(1, result.get('g').intValue());
    }

    @Test
    public void testCountSymbolsRepeatedCharacters() {
        Map<Character, Integer> result = symbolCounterService.countSymbols("abracadabra");
        assertEquals(5, result.size());
        assertEquals(5, result.get('a').intValue());
        assertEquals(2, result.get('b').intValue());
        assertEquals(2, result.get('r').intValue());
        assertEquals(1, result.get('c').intValue());
        assertEquals(1, result.get('d').intValue());
    }

    @Test
    public void testCountSymbolsMixedCharacters() {
        Map<Character, Integer> result = symbolCounterService.countSymbols("Hello, World!");
        assertEquals(10, result.size());
        assertEquals(3, result.get('l').intValue());
        assertEquals(2, result.get('o').intValue());
        assertEquals(1, result.get('H').intValue());
        assertEquals(1, result.get('e').intValue());
        assertEquals(1, result.get(',').intValue());
        assertEquals(1, result.get(' ').intValue());
        assertEquals(1, result.get('W').intValue());
        assertEquals(1, result.get('r').intValue());
        assertEquals(1, result.get('d').intValue());
        assertEquals(1, result.get('!').intValue());
    }

    @Test
    public void testCountSymbolsRussianCharacters() {
        Map<Character, Integer> result = symbolCounterService.countSymbols("Привет, мир!");
        assertEquals(10, result.size());
        assertEquals(1, result.get('П').intValue());
        assertEquals(2, result.get('р').intValue());
        assertEquals(2, result.get('и').intValue());
        assertEquals(1, result.get('в').intValue());
        assertEquals(1, result.get('е').intValue());
        assertEquals(1, result.get('т').intValue());
        assertEquals(1, result.get(',').intValue());
        assertEquals(1, result.get(' ').intValue());
        assertEquals(1, result.get('!').intValue());
    }

    @Test
    public void testCountSymbolsDescendingOrder() {
        String input = "aaabbbccc";
        Map<Character, Integer> result = symbolCounterService.countSymbols(input);

        List<Map.Entry<Character, Integer>> sortedEntries = new ArrayList<>(result.entrySet());

        for (int i = 0; i < sortedEntries.size() - 1; i++) {
            int currentCount = sortedEntries.get(i).getValue();
            int nextCount = sortedEntries.get(i + 1).getValue();
            assertTrue(currentCount >= nextCount);
        }
    }
}