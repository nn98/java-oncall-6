package oncall.domain;

import java.util.Arrays;

public enum Holidays {

    신정(1, 1),
    삼일절(3, 1),
    어린이날(5, 5),
    현충일(6, 6),
    광복절(8, 15),
    개천절(10, 3),
    한글날(10, 9),
    성탄절(12, 25);

    private final int month;
    private final int day;

    Holidays(int month, int day) {
        this.month = month;
        this.day = day;
    }

    public static Holidays findBy(int month, int day) {
        return Arrays.stream(values())
                .filter(holidays -> holidays.month == month && holidays.day == day)
                .findFirst()
                .orElse(null);
    }

    public static boolean isHoliday(int month, int day) {
        return Arrays.stream(values())
                .anyMatch(holidays -> holidays.month == month && holidays.day == day);
    }
}
