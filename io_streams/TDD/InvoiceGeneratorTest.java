package TDD;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class InvoiceGeneratorTest {

    @Test
    public void givenMultipleRides_ShouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

        Ride[] rides = {
                new Ride(2.0, 5),
                new Ride(0.1, 1)
        };

        double totalFare = invoiceGenerator.calculateFare(rides);

        Assertions.assertEquals(26, totalFare);
    }
}
