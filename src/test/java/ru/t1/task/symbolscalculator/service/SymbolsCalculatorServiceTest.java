package ru.t1.task.symbolscalculator.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.t1.task.symbolscalculator.service.impl.SymbolsCalculatorServiceImpl;

import java.util.HashMap;
import java.util.Map;


public class SymbolsCalculatorServiceTest {

    @Test
    public void inputLineWithOnlyEnglishLowerLetter_shouldReturnSortedMap() {
        String inputLine = "baabbgbb";
        Map<Character, Integer> expectedMap = new HashMap<>() {{
            put('b', 5);
            put('a', 2);
            put('g', 1);
        }};

        SymbolsCalculatorService service = new SymbolsCalculatorServiceImpl();
        Assertions.assertTrue(service.countSymbolFrequencyInLine(inputLine).equals(expectedMap),
                    "Результат, полученный из SymbolsCalculatorService не соответствует ожидаемому");
    }

    @Test
    public void inputLineWithDifferenceSymbols_shouldReturnSortedMap() {
        String inputLine = "$bQaab*abgbb11Q";
        Map<Character, Integer> expectedMap = new HashMap<>() {{
            put('b', 5);
            put('a', 3);
            put('1', 2);
            put('Q', 2);
            put('g', 1);
            put('$', 1);
            put('*', 1);
        }};

        SymbolsCalculatorService service = new SymbolsCalculatorServiceImpl();
        Assertions.assertTrue(service.countSymbolFrequencyInLine(inputLine).equals(expectedMap),
                "Результат, полученный из SymbolsCalculatorService не соответствует ожидаемому");
    }
}
