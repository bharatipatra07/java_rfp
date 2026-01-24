package Day26;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class Hotel {

    private final String name;
    private final int rating;
    private final int weekdayRate;
    private final int weekendRate;

    public Hotel(String name, int rating, int weekdayRate, int weekendRate) {
        this.name = name;
        this.rating = rating;
        this.weekdayRate = weekdayRate;
        this.weekendRate = weekendRate;
    }

    public String getName() {
        return name;
    }

    public int calculateTotalRate(List<LocalDate> dates) {
        return dates.stream()
                .mapToInt(date -> {
                    DayOfWeek day = date.getDayOfWeek();
                    boolean isWeekend =
                            day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
                    return isWeekend ? weekendRate : weekdayRate;
                })
                .sum();
    }

}
