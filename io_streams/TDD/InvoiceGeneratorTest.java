package TDD;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvoiceGeneratorTest {

    @Test
    public void givenNormalRide_ShouldCalculateFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

        Ride ride = new Ride(2.0, 5, RideType.NORMAL);
        double fare = invoiceGenerator.calculateFare(ride);

        Assertions.assertEquals(25, fare);
    }

    @Test
    public void givenPremiumRide_ShouldCalculateFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

        Ride ride = new Ride(2.0, 5, RideType.PREMIUM);
        double fare = invoiceGenerator.calculateFare(ride);

        Assertions.assertEquals(40, fare);
    }
}
