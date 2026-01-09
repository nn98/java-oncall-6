package oncall.util;

import java.time.Month;
import java.util.Arrays;
import java.util.List;
import oncall.domain.CustomDayOfWeek;
import oncall.domain.Employee;

public class OncallParser {

    public Month parseMonth(String input) {
        try {
            return Month.of(Integer.parseInt(input));
        } catch (Exception exception) {
            throw MissionError.INVALID_INPUT.exception();
        }
    }

    public CustomDayOfWeek parseDayOfWeek(String input) {
        return CustomDayOfWeek.findByKorName(input);
    }

    public List<Employee> parseEmployees(String input) {
        try {
            String[] tokens = input.split(",");
            return Arrays.stream(tokens)
                    .map(String::trim)
                    .map(Employee::new)
                    .toList();
        } catch (Exception exception) {
            throw MissionError.INVALID_INPUT.exception();
        }
    }
}
