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

    // Find cheapest hotel
    public Hotel findCheapestHotel(CustomerType customerType, List<LocalDate> dates) {
        return hotels.stream()
                .min(Comparator
                        .comparingInt((Hotel h) -> h.calculateTotalCost(customerType, dates))
                        .thenComparing(Hotel::getRating, Comparator.reverseOrder()))
                .orElseThrow(() -> new RuntimeException("No hotels available"));
    }
}
