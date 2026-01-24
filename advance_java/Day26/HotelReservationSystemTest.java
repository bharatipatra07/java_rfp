package Day26;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HotelReservationSystemUC2Test {

    @Test
    void givenDateRange_whenFindingCheapestHotel_thenReturnLakewood() {
        HotelReservationSystem system = new HotelReservationSystem();

        system.addHotel(new Hotel("Lakewood", 3, 110, 90));
        system.addHotel(new Hotel("Bridgewood", 4, 160, 60));
        system.addHotel(new Hotel("Ridgewood", 5, 220, 150));

        List<LocalDate> dates = List.of(
                LocalDate.of(2020, 9, 10),
                LocalDate.of(2020, 9, 11)
        );

        Hotel cheapestHotel = system.findCheapestHotel(dates);
        int totalRate = cheapestHotel.calculateTotalRate(dates);

        assertEquals("Lakewood", cheapestHotel.getName());
        assertEquals(220, totalRate);
    }
}
