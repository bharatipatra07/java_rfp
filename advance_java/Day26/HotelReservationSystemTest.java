package Day26;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HotelReservationSystemUC3Test {

    @Test
    void givenHotels_whenAdded_thenAllHotelsHaveWeekdayAndWeekendRates() {
        HotelReservationSystem system = new HotelReservationSystem();

        system.addHotel(new Hotel("Lakewood", 3, 110, 90));
        system.addHotel(new Hotel("Bridgewood", 4, 150, 50));
        system.addHotel(new Hotel("Ridgewood", 5, 220, 150));

        assertEquals(3, system.getHotels().size());

        assertEquals("Lakewood", system.getHotels().get(0).getName());
        assertEquals("Bridgewood", system.getHotels().get(1).getName());
        assertEquals("Ridgewood", system.getHotels().get(2).getName());
    }
}
