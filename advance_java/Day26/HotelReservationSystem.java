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

    public List<Hotel> findCheapestHotels(List<LocalDate> dates) {

        int minimumCost = hotels.stream()
                .mapToInt(h -> h.calculateTotalRate(dates))
                .min()
                .orElseThrow(() -> new RuntimeException("No hotels available"));

        return hotels.stream()
                .filter(h -> h.calculateTotalRate(dates) == minimumCost)
                .collect(Collectors.toList());
    }
    public String getCheapestHotelOutput(List<LocalDate> dates) {

        List<Hotel> cheapestHotels = findCheapestHotels(dates);
        int totalRate = cheapestHotels.get(0).calculateTotalRate(dates);

        String hotelNames = cheapestHotels.stream()
                .map(Hotel::getName)
                .collect(Collectors.joining(" and "));

        return hotelNames + " with Total Rates $" + totalRate;
    }
}
