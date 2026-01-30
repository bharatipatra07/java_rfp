package TDD;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvoiceServiceTest {

    @Test
    public void givenUserId_ShouldReturnInvoiceSummary() {
        RideRepository rideRepository = new RideRepository();
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        InvoiceService invoiceService = new InvoiceService(rideRepository, invoiceGenerator);

        String userId = "user1";

        Ride[] rides = {
                new Ride(2.0, 5),   // 25
                new Ride(0.1, 1)    // 5
        };

        rideRepository.addRides(userId, rides);

        InvoiceSummary summary = invoiceService.getInvoiceSummary(userId);

        Assertions.assertEquals(2, summary.totalRides);
        Assertions.assertEquals(30, summary.totalFare);
        Assertions.assertEquals(15, summary.averageFare);
    }
}
