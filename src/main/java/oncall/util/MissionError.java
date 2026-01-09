package oncall.util;

public enum MissionError {

    ERROR_PREFIX("[ERROR] "),
    INVALID_INPUT("유효하지 않은 입력값입니다."),
    RETRY_INPUT(" 다시 입력해 주세요.");

    private final String message;

    MissionError(String message) {
        this.message = message;
    }

    private String fullMessage() {
        return ERROR_PREFIX + message + RETRY_INPUT;
    }

    public IllegalArgumentException exception() {
        return new IllegalArgumentException(fullMessage());
    }
}
