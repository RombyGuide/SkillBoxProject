import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import homework_02.Periods;

@DisplayName("Периоды")
class PeriodsTest {

    private static Stream<Arguments> getTestData() {
        return Stream.of(
            Arguments.of(LocalDate.of(1995, 5, 23), LocalDate.of(2021, 11, 1), "years:26, months:5, days:9"),
            Arguments.of(LocalDate.of(2021, 11, 1), LocalDate.of(2021, 11, 1), "years:0, months:0, days:0"),
            Arguments.of(LocalDate.of(2021, 11, 1), LocalDate.of(2021, 11, 2), "years:0, months:0, days:1"),
            Arguments.of(LocalDate.of(-1000, 1, 1), LocalDate.of(2000, 1, 1), "years:3000, months:0, days:0")
        );
    }

    @DisplayName("Проверка расчета периода")
    @ParameterizedTest
    @MethodSource("getTestData")
    public void countPeriods(LocalDate firstDate, LocalDate secondDate, String expected) {
        String actual = Periods.getPeriodFromBirthday(firstDate, secondDate);
        assertEquals(expected, actual);
    }


}