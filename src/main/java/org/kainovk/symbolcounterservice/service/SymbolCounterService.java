package org.kainovk.symbolcounterservice.service;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Service
public class SymbolCounterService {

    public Map<Character, Integer> countSymbols(String text) {
        if (text == null || text.isEmpty()) {
            return Collections.emptyMap();
        }

        Map<Character, Integer> map = new TreeMap<>();
        for (char c : text.toCharArray()) {
            Integer count = map.computeIfAbsent(c, ch -> 0);
            map.put(c, count + 1);
        }

        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new
                ));
    }
}
