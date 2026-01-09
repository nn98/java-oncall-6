package oncall.controller;

import oncall.view.InputView;

public class InputHandler {

    private final InputView inputView;

    public InputHandler(InputView inputView) {
        this.inputView = inputView;
    }

    public String inputCrewName() {
        String crewName = inputView.readLine();
        return crewName;
    }

    public String inputAttendanceTime() {
        String attendanceTime = inputView.readLine();
        return attendanceTime;
    }

    public int inputDate() {
        String day = inputView.readLine();
        int date = Integer.parseInt(day);
        return date;
    }

    public String inputTime() {
        String time = inputView.readLine();
        return time;
    }

    public String inputBeginInfo() {
        String beginInfo = inputView.readLine();
        return beginInfo;
    }

    public String inputEmployee() {
        String employees = inputView.readLine();
        return employees;
    }
}
