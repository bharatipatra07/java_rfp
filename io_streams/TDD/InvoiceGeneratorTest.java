package TDD;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvoiceGeneratorTest {

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

        Ride[] rides = {
                new Ride(2.0, 5),   // fare = 25
                new Ride(0.1, 1)    // fare = 5 (minimum)
        };

        InvoiceSummary summary = invoiceGenerator.calculateInvoiceSummary(rides);

        Assertions.assertEquals(2, summary.totalRides);
        Assertions.assertEquals(30, summary.totalFare);
        Assertions.assertEquals(15, summary.averageFare);
    }
}
