package Day26;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class HotelReservationSystem {

    private final List<Hotel> hotels;

    public HotelReservationSystem(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public String findCheapestBestRatedHotel(
            CustomerType customerType,
            List<LocalDate> dates) {

        validateInputs(customerType, dates);

        return hotels.stream()
                .map(hotel -> new HotelCost(
                        hotel,
                        calculateTotalCost(hotel, customerType, dates)))
                .min(Comparator
                        .comparingInt(HotelCost::getTotalCost)
                        .thenComparing(
                                hc -> hc.getHotel().getRating(),
                                Comparator.reverseOrder()))
                .map(hc -> hc.getHotel().getName()
                        + ", Rating: " + hc.getHotel().getRating()
                        + " and Total Rates: $" + hc.getTotalCost())
                .orElseThrow(() ->
                        new HotelReservationException("No hotels available"));
    }

    private int calculateTotalCost(
            Hotel hotel,
            CustomerType customerType,
            List<LocalDate> dates) {

        int total = 0;

        for (LocalDate date : dates) {
            boolean isWeekend =
                    date.getDayOfWeek() == DayOfWeek.SATURDAY ||
                            date.getDayOfWeek() == DayOfWeek.SUNDAY;

            total += hotel.getRate(customerType, isWeekend);
        }
        return total;
    }

    private void validateInputs(
            CustomerType customerType,
            List<LocalDate> dates) {

        if (customerType == null) {
            throw new HotelReservationException("Invalid customer type");
        }

        if (dates == null || dates.isEmpty()) {
            throw new HotelReservationException("Invalid date range");
        }
    }

    // Helper class
    private static class HotelCost {
        private final Hotel hotel;
        private final int totalCost;

        HotelCost(Hotel hotel, int totalCost) {
            this.hotel = hotel;
            this.totalCost = totalCost;
        }

        public Hotel getHotel() {
            return hotel;
        }

        public int getTotalCost() {
            return totalCost;
        }
    }
}
