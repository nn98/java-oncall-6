package oncall.util;

import java.time.Month;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
            List<Employee> employees = parseValidEmployees(input);
            return employees;
        } catch (Exception exception) {
            throw exception;
        }
    }

    private List<Employee> parseValidEmployees(String input) {
        String[] employees = checkValidEmployeeNumber(input);

        List<Employee> employeeList = parseValidEmployees(employees);

        isDuplicatedNickname(employeeList);

        return employeeList;
    }

    private String[] checkValidEmployeeNumber(String input) {
        String[] employees = input.split(",");
        if (employees.length < 5 || employees.length > 35) {
            throw MissionError.OUT_OF_SCOPE_EMPLOYEES.exception();
        }
        return employees;
    }

    private List<Employee> parseValidEmployees(String[] employees) {
        return Arrays.stream(employees)
                .map(String::trim)
                .map(this::isValidNicknameOrElseThrow)
                .map(Employee::new)
                .toList();
    }

    private String isValidNicknameOrElseThrow(String nickname) {
        if (nickname.length() > 5) {
            throw MissionError.OUT_OF_SCOPE_EMPLOYEE_NICKNAME.exception();
        }
        return nickname;
    }

    private void isDuplicatedNickname(List<Employee> employeeList) {
        Set<Employee> employeeSet = new HashSet<>(employeeList);
        if (employeeList.size() != employeeSet.size()) {
            throw MissionError.DUPLICATED_EMPLOYEE_NICKNAME.exception();
        }
    }

}
