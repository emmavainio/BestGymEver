import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class DateComparatorTest {
    LocalDate testTodaysDate = LocalDate.of(2022, 10, 19);
    LocalDate lessThanOneYearAgo = LocalDate.of(2022, 4, 20);
    LocalDate moreThanOneYearAgo = LocalDate.of(2021, 10, 18);

    @Test
    public void isMoreThanOneYearAgoTest() {
        assertTrue(DateComparator.isLessThanOneYearAgo(testTodaysDate, lessThanOneYearAgo));
        assertFalse(DateComparator.isLessThanOneYearAgo(testTodaysDate, moreThanOneYearAgo));
    }
}
