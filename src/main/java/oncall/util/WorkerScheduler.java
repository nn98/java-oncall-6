package oncall.util;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import oncall.domain.Employee;
import oncall.dto.CustomDateLine;

public class WorkerScheduler {

    private final List<CustomDateLine> customDateLines;
    private final List<Employee> weekdayEmployees;
    private final List<Employee> weekendEmployees;
    private final List<Employee> workers;

    private Employee currentWorker;
    private Employee changedWeekdayWorker;
    private Employee changedHolidayWorker;
    private int weekdayCounter;
    private int weekendCounter;

    public WorkerScheduler(
            List<CustomDateLine> customDateLines,
            List<Employee> weekdayEmployees,
            List<Employee> weekendEmployees) {
        this.customDateLines = customDateLines;
        this.weekdayEmployees = weekdayEmployees;
        this.weekendEmployees = weekendEmployees;
        workers = new ArrayList<>();
        currentWorker = null;
        changedWeekdayWorker = null;
        changedHolidayWorker = null;
        weekdayCounter = 0;
        weekendCounter = 0;
        scheduling();
    }

    public void scheduling() {
        do {
            CustomDateLine today = customDateLines.remove(0);
            boolean isHoliday = isHoliday(today);
            boolean isScheduled = scheduleEmployee(isHoliday);
            currentWorker = workers.get(workers.size() - 1);
        } while (!customDateLines.isEmpty());
    }

    private boolean scheduleEmployee(boolean isHoliday) {
        if (isHoliday) {
            return scheduleHoliday();
        }
        return scheduleWeekday();
    }

    private boolean checkChangedWeekdayWorker(Employee worker) {
        if (worker != null) {
            workers.add(worker);
            return true;
        }
        return false;
    }

    private boolean checkChangedWeekendWorker(Employee worker) {
        if (worker != null) {
            workers.add(worker);
            return true;
        }
        return false;
    }

    private boolean scheduleWeekday() {
        boolean isScheduled = checkChangedWeekdayWorker(changedWeekdayWorker);
        if (isScheduled) {
            changedWeekdayWorker = null;
            nextWeekendCounter();
            return isScheduled;
        }
        isScheduled = scheduleWeekdayIfNotDuplicated();
        if (isScheduled) {
            nextWeekdayCounter();
        }
        return isScheduled;
    }

    private boolean scheduleHoliday() {
        boolean isScheduled = checkChangedWeekendWorker(changedHolidayWorker);
        if (isScheduled) {
            changedHolidayWorker = null;
            nextWeekendCounter();
            return isScheduled;
        }
        isScheduled = scheduleHolidayIfNotDuplicated();
        if (isScheduled) {
            nextWeekendCounter();
        }
        return isScheduled;
    }

    private boolean scheduleWeekdayIfNotDuplicated() {
        Employee worker = weekdayEmployees.get(weekdayCounter);
        if (worker.equals(currentWorker)) {
            changedWeekdayWorker = worker;
            nextWeekdayCounter();
            workers.add(weekdayEmployees.get(weekdayCounter));
            return false;
        }
        workers.add(worker);
        return true;
    }

    private boolean scheduleHolidayIfNotDuplicated() {
        Employee worker = weekendEmployees.get(weekendCounter);
        if (worker.equals(currentWorker)) {
            changedHolidayWorker = worker;
            nextWeekendCounter();
            workers.add(weekendEmployees.get(weekendCounter));
            return false;
        }
        workers.add(worker);
        return true;
    }

    private void nextWeekendCounter() {
        weekendCounter += 1;
        weekendCounter %= weekendEmployees.size();
    }

    private void nextWeekdayCounter() {
        weekdayCounter += 1;
        weekdayCounter %= weekdayEmployees.size();
    }

    private boolean isHoliday(CustomDateLine today) {
        if (today.isPublicHoliday()) {
            return true;
        }
        DayOfWeek dayOfWeek = today.dayOfWeek();
        return dayOfWeek.equals(DayOfWeek.SATURDAY) || dayOfWeek.equals(DayOfWeek.SUNDAY);
    }

    public List<Employee> getWorkers() {
        return workers;
    }
}
