package TDD;

public class InvoiceService {

    private final RideRepository rideRepository;
    private final InvoiceGenerator invoiceGenerator;

    public InvoiceService(RideRepository rideRepository, InvoiceGenerator invoiceGenerator) {
        this.rideRepository = rideRepository;
        this.invoiceGenerator = invoiceGenerator;
    }

    public InvoiceSummary getInvoiceSummary(String userId) {
        Ride[] rides = rideRepository.getRides(userId);
        return invoiceGenerator.calculateInvoiceSummary(rides);
    }
}
