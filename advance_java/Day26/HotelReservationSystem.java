package Day26;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HotelReservationSystem {

    private final List<Hotel> hotels = new ArrayList<>();

    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }
    // UC6: cheapest + best rated hotel
    public String findCheapestBestRatedHotelOutput(List<LocalDate> dates) {

        Hotel bestHotel = hotels.stream()
                .min(Comparator
                        .comparingInt((Hotel h) -> h.calculateTotalRate(dates))
                        .thenComparing(Hotel::getRating, Comparator.reverseOrder()))
                .orElseThrow(() -> new RuntimeException("No hotels available"));

        int totalRate = bestHotel.calculateTotalRate(dates);

        return bestHotel.getName()
                + ", Rating: " + bestHotel.getRating()
                + " and Total Rates: $" + totalRate;
    }
}
