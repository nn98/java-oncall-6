package oncall.domain;

import java.time.DayOfWeek;
import java.util.Arrays;

public enum CustomDayOfWeek {

    MONDAY("월", DayOfWeek.MONDAY),
    TUESDAY("화", DayOfWeek.TUESDAY),
    WEDNESDAY("수", DayOfWeek.WEDNESDAY),
    THURSDAY("목", DayOfWeek.THURSDAY),
    FRIDAY("금", DayOfWeek.FRIDAY),
    SATURDAY("토", DayOfWeek.SATURDAY),
    SUNDAY("일", DayOfWeek.SUNDAY);

    private final String korName;
    private final DayOfWeek dayOfWeek;

    CustomDayOfWeek(String korName, DayOfWeek dayOfWeek) {
        this.korName = korName;
        this.dayOfWeek = dayOfWeek;
    }

    public static CustomDayOfWeek findByKorName(String korName) {
        return Arrays.stream(values())
                .filter(customDayOfWeek -> {
                    return customDayOfWeek.korName.equals(korName);
                })
                .findFirst()
                .orElseThrow();
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public String getKorName() {
        return korName;
    }
}
