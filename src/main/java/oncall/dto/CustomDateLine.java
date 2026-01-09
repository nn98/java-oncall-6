package oncall.dto;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

public record CustomDateLine(int month, int day, DayOfWeek dayOfWeek, boolean isPublicHoliday) {
    @Override
    public String toString() {
        String dayOfWeekDisplayName = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.KOREAN);
        String holiday = "";
        if (isPublicHoliday) {
            holiday = "(휴일)";
        }
        return String.format(
                "%d월 %d일 %s%s",
                month, day, dayOfWeekDisplayName, holiday);
    }
}
