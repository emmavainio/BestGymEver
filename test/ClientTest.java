import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

public class ClientTest {

    Client p = new Client("Emma Vainio", "9411285803", "2022-04-01");

    @Test
    public void parseDateTest() {
        LocalDate expectedDate = LocalDate.of(2022, Month.APRIL, 1);
        LocalDate notExpectedDate = LocalDate.of(2022, Month.NOVEMBER, 2);

        assert (p.getPaymentDate().equals(expectedDate));
        assert (!p.getPaymentDate().equals(notExpectedDate));
    }
}

