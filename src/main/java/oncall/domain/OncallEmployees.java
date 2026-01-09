package oncall.domain;

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

    public void setWeekdayEmployees(Employees employees) {
        this.weekdayEmployees = employees;
    }

    public void setWeekendEmployees(Employees employees) {
        this.weekendEmployees = employees;
    }
}
