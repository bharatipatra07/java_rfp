package Day26;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HotelReservationSystemTest {

    @Test
    void givenRewardCustomer_whenFindingCheapestBestRatedHotel_thenReturnRidgewood() {

        List<Hotel> hotels = List.of(
                new Hotel("Lakewood", 3, 110, 90, 80, 80),
                new Hotel("Bridgewood", 4, 150, 50, 110, 50),
                new Hotel("Ridgewood", 5, 220, 150, 100, 40)
        );

        HotelReservationSystem system =
                new HotelReservationSystem(hotels);

        String result = system.findCheapestBestRatedHotel(
                "REWARD",
                List.of("11Sep2020", "12Sep2020")
        );

        assertEquals(
                "Ridgewood, Rating: 5 and Total Rates: $140",
                result);
    }
}
