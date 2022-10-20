import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class DateComparatorTest {
    LocalDate todaysDate = LocalDate.now();
    LocalDate lessThanOneYearAgo = todaysDate.minusMonths(6);
    LocalDate moreThanOneYearAgo = todaysDate.minusYears(2);

    @Test
    public void isMoreThanOneYearAgoTest() {
        assertTrue(DateComparator.isLessThanOneYearAgo(lessThanOneYearAgo));
        assertFalse(DateComparator.isLessThanOneYearAgo(moreThanOneYearAgo));
    }
}
