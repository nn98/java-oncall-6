package oncall.domain;

import java.util.List;

public class OncallEmployees {

    private Employees weekdayEmployees;
    private Employees weekendEmployees;

    public OncallEmployees() {
    }

    public OncallEmployees(Employees weekdayEmployees, Employees weekendEmployees) {
        this.weekdayEmployees = weekdayEmployees;
        this.weekendEmployees = weekendEmployees;
    }

    @Override
    public String toString() {
        return "weekdayEmployees=" + weekdayEmployees +
                "\nweekendEmployees=" + weekendEmployees;
    }

    public List<Employee> getWeekdayEmployees() {
        return weekdayEmployees.employees();
    }

    public void setWeekdayEmployees(Employees employees) {
        this.weekdayEmployees = employees;
    }

    public List<Employee> getWeekendEmployees() {
        return weekendEmployees.employees();
    }

    public void setWeekendEmployees(Employees employees) {
        this.weekendEmployees = employees;
    }
}
