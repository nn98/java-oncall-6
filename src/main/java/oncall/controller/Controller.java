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
                break;
            } catch (IllegalArgumentException exception) {
                outputView.printException(exception.getMessage());
            }
        }
        while (true) {
            try {
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
    }

    private void initOncallEmployees() {
        initWeekdayEmployees();
        initWeekendEmployees();
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
        outputView.printOncall(service.getCustomDateLines(), service.scheduling());
    }
}
