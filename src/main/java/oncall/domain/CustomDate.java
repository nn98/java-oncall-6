package oncall.domain;

import java.time.DayOfWeek;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import oncall.dto.CustomDateLine;

public class CustomDate {

    private final int month;
    private final CustomDayOfWeek beginDayOfWeek;

    public CustomDate(int month, CustomDayOfWeek beginDayOfWeek) {
        this.month = month;
        this.beginDayOfWeek = beginDayOfWeek;
    }

    public DayOfWeek getDayOfWeek(int days) {
        DayOfWeek dayOfWeek = beginDayOfWeek.getDayOfWeek();
        return dayOfWeek.plus(days);
    }

    public List<CustomDateLine> getEveryDay() {
        List<CustomDateLine> everyDay = new ArrayList<>();
        YearMonth yearMonth = YearMonth.of(2024, month);
        int daysInMonth = yearMonth.lengthOfMonth();
        for (int passed = 0; passed < daysInMonth; passed += 1) {
            int day = passed + 1;
            boolean isHoliday = Holidays.isHoliday(month, day);
            everyDay.add(new CustomDateLine(month, day, getDayOfWeek(passed), isHoliday));
        }
        return everyDay;
    }

    @Override
    public String toString() {
        return "CustomDate{" +
                "month=" + month +
                ", beginDayOfWeek=" + beginDayOfWeek +
                '}';
    }
}
