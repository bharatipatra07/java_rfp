package Day26;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

        List<LocalDate> dates = List.of(
                LocalDate.of(2020, 9, 11),
                LocalDate.of(2020, 9, 12)
        );

        String result = system.findCheapestBestRatedHotel(
                CustomerType.REWARD, dates);

        assertEquals(
                "Ridgewood, Rating: 5 and Total Rates: $140",
                result);
    }

    @Test
    void givenInvalidCustomerType_thenThrowException() {

        HotelReservationSystem system =
                new HotelReservationSystem(List.of());

        assertThrows(HotelReservationException.class, () ->
                system.findCheapestBestRatedHotel(
                        null, List.of(LocalDate.now())));
    }
}
