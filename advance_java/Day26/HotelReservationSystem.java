package Day26;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class HotelReservationSystem {

    private final List<Hotel> hotels;

    public HotelReservationSystem(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public int calculateTotalCost(Hotel hotel,
                                  List<LocalDate> dates,
                                  CustomerType customerType) {

        int total = 0;

        for (LocalDate date : dates) {
            boolean isWeekend =
                    date.getDayOfWeek() == DayOfWeek.SATURDAY ||
                            date.getDayOfWeek() == DayOfWeek.SUNDAY;

            total += hotel.getRate(customerType, isWeekend);
        }
        return total;
    }
}
