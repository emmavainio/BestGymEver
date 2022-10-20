import java.time.LocalDate;

public class DateComparator {

    public static boolean isLessThanOneYearAgo(LocalDate todaysDate, LocalDate paymentDate) {
        LocalDate oneYearAgo = todaysDate.minusYears(1);
        return paymentDate.isAfter(oneYearAgo);
    }
}
