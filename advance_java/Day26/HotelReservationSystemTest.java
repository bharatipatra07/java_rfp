package Day26;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HotelReservationSystemUC6Test {

    @Test
    void givenDateRange_whenFindingCheapestBestRatedHotel_thenReturnBridgewood() {

        HotelReservationSystem system = new HotelReservationSystem();

        system.addHotel(new Hotel("Lakewood", 3, 110, 90));
        system.addHotel(new Hotel("Bridgewood", 4, 150, 50));
        system.addHotel(new Hotel("Ridgewood", 5, 220, 150));

        List<LocalDate> dates = List.of(
                LocalDate.of(2020, 9, 11),
                LocalDate.of(2020, 9, 12)
        );

        String output = system.findCheapestBestRatedHotelOutput(dates);

        assertEquals(
                "Bridgewood, Rating: 4 and Total Rates: $200",
                output
        );
    }
}
