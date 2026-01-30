package TDD;

public class InvoiceGenerator {

    private static final double COST_PER_KM = 10;
    private static final double COST_PER_MINUTE = 1;
    private static final double MIN_FARE = 5;

    public double calculateFare(double distance, int time) {
        double fare = (distance * COST_PER_KM) + (time * COST_PER_MINUTE);
        return Math.max(fare, MIN_FARE);
    }

    public double calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += calculateFare(ride.distance, ride.time);
        }
        return totalFare;
    }

    public InvoiceSummary calculateInvoiceSummary(Ride[] rides) {
        double totalFare = calculateFare(rides);
        return new InvoiceSummary(rides.length, totalFare);
    }
}
