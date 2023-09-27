package ru.t1.task.symbolscalculator;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;
import ru.t1.task.symbolscalculator.service.SymbolsCalculatorServiceTest;
import ru.t1.task.symbolscalculator.util.SorterHelperTest;
import ru.t1.task.symbolscalculator.web.SymbolsCalculatorControllerTest;

@Suite
@SuiteDisplayName("Service layer tests")
@SelectClasses({SymbolsCalculatorServiceTest.class,
                SorterHelperTest.class,
                SymbolsCalculatorControllerTest.class})
class SymbolsCalculatorApplicationTests {
}
