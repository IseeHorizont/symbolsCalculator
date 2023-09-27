package ru.t1.task.symbolscalculator.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.t1.task.symbolscalculator.service.SymbolsCalculatorService;
import java.util.HashMap;
import java.util.Map;
import static ru.t1.task.symbolscalculator.util.SorterHelper.sortMapByValueDESC;

@Service
@Slf4j
public class SymbolsCalculatorServiceImpl implements SymbolsCalculatorService {

    @Override
    public Map<Character, Integer> countSymbolFrequencyInLine(String line) {

        Map<Character, Integer> symbolsMap = line.chars()
                .mapToObj(symbol -> (char) symbol)
                .collect(HashMap::new, (map, symbol) -> {
                    map.put(symbol, map.getOrDefault(symbol,0) + 1);
                }, HashMap::putAll);
        log.info("After calculate frequency all symbols: {}", symbolsMap);

        Map<Character, Integer> sortedMap = sortMapByValueDESC(symbolsMap);
        log.info("Symbols after sorting DESC by frequency: {}", sortedMap);
        return sortedMap;
    }
}
