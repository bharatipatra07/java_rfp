package Day26;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

public class HotelReservationSystem {

    private static final Pattern DATE_PATTERN =
            Pattern.compile("\\d{2}[A-Za-z]{3}\\d{4}");

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("ddMMMyyyy");

    private final List<Hotel> hotels;

    public HotelReservationSystem(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public String findCheapestBestRatedHotel(
            String customerTypeInput,
            List<String> dateInputs) {

        CustomerType customerType = validateCustomerType(customerTypeInput);
        List<LocalDate> dates = validateAndParseDates(dateInputs);

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
                        new HotelReservationException("No hotel found"));
    }

    private int calculateTotalCost(
            Hotel hotel,
            CustomerType type,
            List<LocalDate> dates) {

        return dates.stream()
                .mapToInt(date -> {
                    boolean isWeekend =
                            date.getDayOfWeek() == DayOfWeek.SATURDAY ||
                                    date.getDayOfWeek() == DayOfWeek.SUNDAY;
                    return hotel.getRate(type, isWeekend);
                })
                .sum();
    }

    private CustomerType validateCustomerType(String input) {
        try {
            return CustomerType.valueOf(input.toUpperCase());
        } catch (Exception e) {
            throw new HotelReservationException("Invalid customer type");
        }
    }

    private List<LocalDate> validateAndParseDates(List<String> dateInputs) {

        if (dateInputs == null || dateInputs.isEmpty()) {
            throw new HotelReservationException("Date range cannot be empty");
        }

        return dateInputs.stream()
                .peek(date -> {
                    if (!DATE_PATTERN.matcher(date).matches()) {
                        throw new HotelReservationException(
                                "Invalid date format: " + date);
                    }
                })
                .map(date -> LocalDate.parse(date, FORMATTER))
                .toList();
    }

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
