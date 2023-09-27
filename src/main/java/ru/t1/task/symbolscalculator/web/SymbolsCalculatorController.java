package ru.t1.task.symbolscalculator.web;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.t1.task.symbolscalculator.service.SymbolsCalculatorService;
import java.util.Map;

@RestController
@RequestMapping("/calculate")
@Slf4j
@Validated
public class SymbolsCalculatorController {

    private final SymbolsCalculatorService symbolsCalculatorService;

    public SymbolsCalculatorController(SymbolsCalculatorService symbolsCalculatorService) {
        this.symbolsCalculatorService = symbolsCalculatorService;
    }

    @GetMapping("")
    public Map<Character, Integer> calculateSymbolsInLine(
            @NotBlank(message = "Строка не должна быть пустой")
            @Size(min = 1, max = 100, message = "Длина строки должна быть не менее 1 и не более 100 символов")
            @RequestParam(name = "line") String line
    ) {
        return symbolsCalculatorService.countSymbolFrequencyInLine(line);
    }
}
