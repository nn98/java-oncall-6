package oncall.util;

public enum Message {

    BEGIN_MONTH_DAY_OF_WEEK("비상 근무를 배정할 월과 시작 요일을 입력하세요> "),
    BEGIN_MONTH_WEEKDAY("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> "),
    BEGIN_MONTH_WEEKEND("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> "),
    ONCALL_DAY_EMPLOYEE("%s%s %s");

    public final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
