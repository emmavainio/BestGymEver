import java.time.LocalDate;

public class Person {

    String name;
    String ssn;
    LocalDate paymentDate;

    public Person(String name, String socialSecurityNumber, String paymentDate) {
        this.name = name;
        this.ssn = socialSecurityNumber;
        this.paymentDate = parseDate(paymentDate);
    }

    public String getName() {
        return name;
    }

    public String getSsn() {
        return ssn;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public LocalDate parseDate (String paymentDate) {
        return LocalDate.parse(paymentDate.trim());
    }
}
