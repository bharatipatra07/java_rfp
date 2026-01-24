package Day26;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class Hotel {

    private final String name;
    private final int rating;
    private final int weekdayRegular;
    private final int weekdayRewards;
    private final int weekendRegular;
    private final int weekendRewards;

    public Hotel(String name, int rating,
                 int weekdayRegular, int weekdayRewards,
                 int weekendRegular, int weekendRewards) {

        this.name = name;
        this.rating = rating;
        this.weekdayRegular = weekdayRegular;
        this.weekdayRewards = weekdayRewards;
        this.weekendRegular = weekendRegular;
        this.weekendRewards = weekendRewards;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public int calculateTotalCost(CustomerType customerType, List<LocalDate> dates) {
        return dates.stream()
                .mapToInt(date -> {
                    boolean isWeekend = date.getDayOfWeek() == DayOfWeek.SATURDAY
                            || date.getDayOfWeek() == DayOfWeek.SUNDAY;

                    if (customerType == CustomerType.REGULAR) {
                        return isWeekend ? weekendRegular : weekdayRegular;
                    } else {
                        return isWeekend ? weekendRewards : weekdayRewards;
                    }
                })
                .sum();
    }
}
