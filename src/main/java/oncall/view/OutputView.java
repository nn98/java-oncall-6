package oncall.view;

import java.util.List;
import oncall.dto.CustomDateLine;
import oncall.util.Message;

public class OutputView {

    public void printLine(String line) {
        System.out.println(line);
    }

    public void printException(String message) {
        printLine(message);
    }

    public void printInputNoticeBeginInfo() {
        System.out.print(Message.BEGIN_MONTH_DAY_OF_WEEK.message);
    }

    public void printInputNoticeWeekdayEmployees() {
        System.out.print(Message.BEGIN_MONTH_WEEKDAY.message);
    }

    public void printInputNoticeWeekendEmployees() {
        System.out.print(Message.BEGIN_MONTH_WEEKEND.message);
    }

    public void printCustomDateLines(List<CustomDateLine> customDateLines) {
        customDateLines.stream().map(CustomDateLine::toString).forEach(this::printLine);
    }
}
