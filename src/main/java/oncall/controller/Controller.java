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
        String beginInfo = inputHandler.inputBeginInfo();
        service.setBeginDateInfo(beginInfo);
        service.printBeginDateInfo();

        String weekdayEmployee = inputHandler.inputEmployee();
        service.setWeekdayEmployee(weekdayEmployee);

        String weekendEmployee = inputHandler.inputEmployee();
        service.setWeekendEmployee(weekendEmployee);

        execute();
    }

    public void execute() {

    }
}
