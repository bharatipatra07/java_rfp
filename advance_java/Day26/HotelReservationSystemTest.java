package Day26;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HotelReservationSystemTest {

    @Test
    void givenRewardCustomer_whenCalculatingCost_thenApplyRewardRates() {

        Hotel ridgewood = new Hotel(
                "Ridgewood", 5,
                220, 150,
                100, 40
        );

        HotelReservationSystem system =
                new HotelReservationSystem(List.of(ridgewood));

        List<LocalDate> dates = List.of(
                LocalDate.of(2020, 9, 11), // Friday
                LocalDate.of(2020, 9, 12)  // Saturday
        );

        int totalCost = system.calculateTotalCost(
                ridgewood,
                dates,
                CustomerType.REWARD
        );

        assertEquals(140, totalCost);
    }
}
