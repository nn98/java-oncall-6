package oncall.util;

import java.util.List;
import oncall.domain.Employee;
import oncall.domain.Employees;
import oncall.dto.CustomDateLine;

public class WorkerMapper {

    private final List<CustomDateLine> customDateLines;
    private final List<Employee> weekdayEmployees;
    private final List<Employee> weekendEmployees;

    public WorkerMapper(
            List<CustomDateLine> customDateLines,
            List<Employee> weekdayEmployees,
            List<Employee> weekendEmployees) {
        this.customDateLines = customDateLines;
        this.weekdayEmployees = weekdayEmployees;
        this.weekendEmployees = weekendEmployees;
    }

    public 
}
