import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

package Day26;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HotelReservationSystemTest {

    private HotelReservationSystem system;

    @BeforeEach
    void setup() {
        system = new HotelReservationSystem();

        system.addHotel(new Hotel("Lakewood", 3, 110, 80, 90, 80));
        system.addHotel(new Hotel("Bridgewood", 4, 160, 110, 60, 50));
        system.addHotel(new Hotel("Ridgewood", 5, 220, 100, 150, 40));
    }

}
