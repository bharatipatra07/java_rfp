package TDD;

public enum RideType {

    NORMAL(10, 1, 5),
    PREMIUM(15, 2, 20);

    public final int costPerKm;
    public final int costPerMinute;
    public final int minimumFare;

    RideType(int costPerKm, int costPerMinute, int minimumFare) {
        this.costPerKm = costPerKm;
        this.costPerMinute = costPerMinute;
        this.minimumFare = minimumFare;
    }
}
