package oncall.controller;

import oncall.service.Service;
import oncall.view.OutputView;

public class Controller {

    private final InputHandler inputHandler;
    private final OutputView outputView;
    private final Service service;

    public Controller(InputHandler inputHandler, OutputView outputView, Service service) {
        this.inputHandler = inputHandler;
        this.outputView = outputView;
        this.service = service;
    }

    public void run() {
        while (true) {
            try {
                initBeginInfo();
                initOncallEmployees();
                break;
            } catch (IllegalArgumentException exception) {
                outputView.printException(exception.getMessage());
            }
        }
        execute();
    }

    private void initBeginInfo() {
        outputView.printInputNoticeBeginInfo();
        String beginInfo = inputHandler.inputBeginInfo();
        service.setBeginDateInfo(beginInfo);
        service.printBeginDateInfo();
    }

    private void initOncallEmployees() {
        initWeekdayEmployees();
        initWeekendEmployees();
        service.printOncallEmployees();
    }

    private void initWeekdayEmployees() {
        outputView.printInputNoticeWeekdayEmployees();
        String weekdayEmployee = inputHandler.inputEmployee();
        service.setWeekdayEmployees(weekdayEmployee);

    }

    private void initWeekendEmployees() {
        outputView.printInputNoticeWeekendEmployees();
        String weekendEmployee = inputHandler.inputEmployee();
        service.setWeekendEmployees(weekendEmployee);
    }

    public void execute() {
        outputView.printCustomDateLines(service.getCustomDateLines());
    }
}
