package ru.t1.task.symbolscalculator.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class SymbolsCalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void calculate_shouldReturnSortedMap() throws Exception {
        mockMvc
                .perform(get("/calculate")
                        .param("line", "bbabagbb"))
                .andExpect(status().isOk())
                .andExpect(content().json("{'b':5,'a':2,'g':1}"));
    }

    @Test
    public void calculateWithEmptyLine_shouldReturnValidationError() throws Exception {
        mockMvc
                .perform(get("/calculate")
                        .param("line", ""))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("errorMessage")
                                .value("Ошибка валидации входных данных"));
    }

    @Test
    public void calculate101SymbolLine_shouldReturnValidationError() throws Exception {
        String lineWith101Symbol = "qwertyuiopasdfghjkl;qwertyuiopasdfghjkl;zxcvbnm,./qwertyuiopasdfghjkl" +
                                   ";qwertyuiopasdfghjkl;zxcvbnm';ls";
        mockMvc
                .perform(get("/calculate")
                        .param("line", lineWith101Symbol))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("errorMessage")
                        .value("Ошибка валидации входных данных"));
    }
}
