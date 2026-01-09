package oncall.util;

public enum MissionError {

    ERROR_PREFIX("[ERROR] "),
    RETRY_INPUT(" 다시 입력해 주세요."),
    INVALID_INPUT("유효하지 않은 입력값입니다."),
    OUT_OF_SCOPE_EMPLOYEES("근무자는 5명 이상 35명 이하여야 합니다."),
    DUPLICATED_EMPLOYEE_NICKNAME("근무자 닉네임은 중복되지 않아야 합니다."),
    OUT_OF_SCOPE_EMPLOYEE_NICKNAME("근무자 닉네임은 최대 5자여야 합니다.");

    private final String message;

    MissionError(String message) {
        this.message = message;
    }

    private String fullMessage() {
        return ERROR_PREFIX.message + message + RETRY_INPUT.message;
    }

    public IllegalArgumentException exception() {
        return new IllegalArgumentException(fullMessage());
    }
}
