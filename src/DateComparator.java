import java.time.LocalDate;

public class DateComparator {

    public static boolean isLessThanOneYearAgo(LocalDate paymentDate) {
        LocalDate todaysDate = LocalDate.now();
        LocalDate oneYearAgo = todaysDate.minusYears(1);
        return paymentDate.isAfter(oneYearAgo);
    }
}
