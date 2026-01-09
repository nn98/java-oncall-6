package oncall.domain;

import java.util.List;

public record Employees(List<Employee> employees) {

    @Override
    public String toString() {
        return employees.toString();
    }
}
