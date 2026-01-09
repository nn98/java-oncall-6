package oncall.service;

import java.time.Month;
import java.util.List;
import oncall.domain.CustomDate;
import oncall.domain.CustomDayOfWeek;
import oncall.domain.Employee;
import oncall.domain.Employees;
import oncall.domain.OncallEmployees;
import oncall.dto.CustomDateLine;
import oncall.util.MissionError;
import oncall.util.OncallParser;
import oncall.util.WorkerScheduler;

public class Service {

    private final OncallParser oncallParser;
    private final OncallEmployees oncallEmployees;
    private CustomDate beginDateInfo;

    public Service(OncallParser oncallParser) {
        this.oncallParser = oncallParser;
        this.oncallEmployees = new OncallEmployees();
    }

    public void setBeginDateInfo(String beginInfo) {
        try {
            String[] infoSplit = beginInfo.split(",");
            String month = infoSplit[0];
            String dayOfWeek = infoSplit[1];
            setBeginDateInfo(month, dayOfWeek);

        } catch (Exception exception) {
            throw MissionError.INVALID_INPUT.exception();
        }
    }

    private void setBeginDateInfo(String month, String dayOfWeek) {
        Month beginMonth = oncallParser.parseMonth(month);
        CustomDayOfWeek beginDayOfWeek = oncallParser.parseDayOfWeek(dayOfWeek);
        beginDateInfo = new CustomDate(beginMonth.getValue(), beginDayOfWeek);
    }

    public void setWeekdayEmployees(String weekdayEmployee) {
        Employees employees = new Employees(oncallParser.parseEmployees(weekdayEmployee));
        oncallEmployees.setWeekdayEmployees(employees);
    }

    public void setWeekendEmployees(String weekendEmployee) {
        Employees employees = new Employees(oncallParser.parseEmployees(weekendEmployee));
        oncallEmployees.setWeekendEmployees(employees);
    }

    public List<CustomDateLine> getCustomDateLines() {
        return beginDateInfo.getEveryDay();
    }

    public List<Employee> scheduling() {
        List<CustomDateLine> workingDay = beginDateInfo.getEveryDay();
        List<Employee> weekdayEmployees = oncallEmployees.getWeekdayEmployees();
        List<Employee> weekendEmployees = oncallEmployees.getWeekendEmployees();
        WorkerScheduler workerScheduler =
                new WorkerScheduler(workingDay, weekdayEmployees, weekendEmployees);
        return workerScheduler.getWorkers();
    }
}
