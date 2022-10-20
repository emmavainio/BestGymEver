import java.time.LocalDate;

public class DateComparator {

    public static boolean isLessThanOneYearAgo(LocalDate paymentDate) {
        LocalDate oneYearAgo = LocalDate.now().minusYears(1);
        return paymentDate.isAfter(oneYearAgo);
    }
}
