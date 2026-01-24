
package Day26;

class HotelReservationException extends RuntimeException {

    public HotelReservationException(String message) {
        super(message);
    }
}

public class Hotel {

    private final String name;
    private final int rating;
    private final int regularWeekdayRate;
    private final int regularWeekendRate;
    private final int rewardWeekdayRate;
    private final int rewardWeekendRate;

    public Hotel(String name, int rating,
                 int regularWeekdayRate, int regularWeekendRate,
                 int rewardWeekdayRate, int rewardWeekendRate) {

        this.name = name;
        this.rating = rating;
        this.regularWeekdayRate = regularWeekdayRate;
        this.regularWeekendRate = regularWeekendRate;
        this.rewardWeekdayRate = rewardWeekdayRate;
        this.rewardWeekendRate = rewardWeekendRate;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public int getRate(CustomerType type, boolean isWeekend) {
        if (type == CustomerType.REWARD) {
            return isWeekend ? rewardWeekendRate : rewardWeekdayRate;
        }
        return isWeekend ? regularWeekendRate : regularWeekdayRate;
    }
}
