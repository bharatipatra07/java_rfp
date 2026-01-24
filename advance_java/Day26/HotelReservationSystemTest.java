package Day26;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HotelRatingUC5Test {

    @Test
    void givenHotels_whenRatingsAdded_thenRatingsAreStoredCorrectly() {

        Hotel lakewood = new Hotel("Lakewood", 3, 110, 90);
        Hotel bridgewood = new Hotel("Bridgewood", 4, 150, 50);
        Hotel ridgewood = new Hotel("Ridgewood", 5, 220, 150);

        assertEquals(3, lakewood.getRating());
        assertEquals(4, bridgewood.getRating());
        assertEquals(5, ridgewood.getRating());
    }
}
