package Day26;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class HotelReservationSystem {

    private final List<Hotel> hotels;

    public HotelReservationSystem(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    // UC7: Best rated hotel + total cost
    public String findBestRatedHotelWithTotalCost(List<LocalDate> dates) {

        Hotel bestRatedHotel = hotels.stream()
                .max(Comparator.comparingInt(Hotel::getRating))
                .orElseThrow();

        int totalCost = calculateTotalCost(bestRatedHotel, dates);

        return bestRatedHotel.getName()
                + " & Total Rates $" + totalCost;
    }

    private int calculateTotalCost(Hotel hotel, List<LocalDate> dates) {
        int total = 0;

        for (LocalDate date : dates) {
            DayOfWeek day = date.getDayOfWeek();
            if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) {
                total += hotel.getWeekendRate();
            } else {
                total += hotel.getWeekdayRate();
            }
        }
        return total;
    }
}
