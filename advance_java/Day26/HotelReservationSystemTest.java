package Day26;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HotelReservationSystemTest {

    @Test
    void givenDateRange_whenFindingBestRatedHotel_thenReturnRidgewoodWithTotalRates() {

        List<Hotel> hotels = List.of(
                new Hotel("Lakewood", 3, 110, 90),
                new Hotel("Bridgewood", 4, 150, 50),
                new Hotel("Ridgewood", 5, 220, 150)
        );

        HotelReservationSystem system = new HotelReservationSystem(hotels);

        List<LocalDate> dates = List.of(
                LocalDate.of(2020, 9, 11),
                LocalDate.of(2020, 9, 12)
        );

        String output = system.findBestRatedHotelWithTotalCost(dates);

        assertEquals("Ridgewood & Total Rates $370", output);
    }
}
