package ru.t1.task.symbolscalculator.service;

import java.util.Map;

public interface SymbolsCalculatorService {

    Map<Character, Integer> countSymbolFrequencyInLine(String line);
}
