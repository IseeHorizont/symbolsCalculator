package ru.t1.task.symbolscalculator.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class SorterHelperTest {

    @Test
    public void shuffledSourceMap_shouldReturnSortedDescMap() {
        Map<Character, Integer> sourceMap = new HashMap<>() {{
            put('d', 3);
            put('a', 2);
            put('j', 7);
        }};
        Map<Character, Integer> expectedMap = new HashMap<>() {{
            put('j', 7);
            put('d', 3);
            put('a', 2);
        }};
        Assertions.assertTrue(expectedMap.equals(SorterHelper.sortMapByValueDESC(sourceMap)),
                    "Ожидается, что Map будет отсортирована по убыванию значений в Map");
    }
}
