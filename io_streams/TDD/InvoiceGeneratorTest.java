package TDD;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvoiceGeneratorTest {

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double fare = invoiceGenerator.calculateFare(1, 1);
        Assertions.assertEquals(11, fare);
    }

    @Test
    public void givenZeroDistanceAndTime_ShouldReturnMinimumFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double fare = invoiceGenerator.calculateFare(0, 0);
        Assertions.assertEquals(5, fare);
    }

    @Test
    public void givenMultipleDistanceAndTime_ShouldReturnCorrectFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double fare = invoiceGenerator.calculateFare(2, 5);
        Assertions.assertEquals(25, fare);
    }
}
