package TDD;

public class InvoiceGenerator {

    public double calculateFare(Ride ride) {
        double fare = (ride.distance * ride.rideType.costPerKm)
                    + (ride.time * ride.rideType.costPerMinute);

        return Math.max(fare, ride.rideType.minimumFare);
    }

    public InvoiceSummary calculateInvoiceSummary(Ride[] rides) {
        double totalFare = 0;

        for (Ride ride : rides) {
            totalFare += calculateFare(ride);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }
}
