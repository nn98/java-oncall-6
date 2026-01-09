package oncall.domain;

import java.time.DayOfWeek;
import java.time.Month;

public class CustomDate {

    private final Month month;
    private final CustomDayOfWeek beginDayOfWeek;

    public CustomDate(Month month, CustomDayOfWeek beginDayOfWeek) {
        this.month = month;
        this.beginDayOfWeek = beginDayOfWeek;
    }

    public DayOfWeek getDayOfWeek(int days) {
        DayOfWeek dayOfWeek = beginDayOfWeek.getDayOfWeek();
        return dayOfWeek.plus(days);
    }

    @Override
    public String toString() {
        return "CustomDate{" +
                "month=" + month +
                ", beginDayOfWeek=" + beginDayOfWeek +
                '}';
    }
}
