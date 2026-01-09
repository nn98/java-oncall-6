package oncall.service;

import java.time.Month;
import oncall.domain.CustomDate;
import oncall.domain.CustomDayOfWeek;
import oncall.util.MissionError;
import oncall.util.OncallParser;

public class Service {

    private final OncallParser oncallParser;
    private CustomDate beginDateInfo;

    public Service(OncallParser oncallParser) {
        this.oncallParser = oncallParser;
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
        beginDateInfo = new CustomDate(beginMonth, beginDayOfWeek);
    }

    public void setWeekdayEmployee(String weekdayEmployee) {

    }

    public void setWeekendEmployee(String weekendEmployee) {

    }

    public

    public void printBeginDateInfo() {
        System.out.println(beginDateInfo);
    }
}
