package oncall;

import oncall.controller.Controller;
import oncall.controller.InputHandler;
import oncall.service.Service;
import oncall.util.OncallParser;
import oncall.view.InputView;
import oncall.view.OutputView;

public class Config {

    private InputView inputView;
    private OutputView outputView;
    private Controller controller;
    private Service service;
    private InputHandler inputHandler;
    private OncallParser parser;

    public Controller controller() {
        if (controller == null) {
            controller = new Controller(inputHandler(), outputView(), service());
        }
        return controller;
    }

    private InputView inputView() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    private OutputView outputView() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    private Service service() {
        if (service == null) {
            service = new Service(parser());
        }
        return service;
    }

    private OncallParser parser() {
        if (parser == null) {
            parser = new OncallParser();
        }
        return parser;
    }

    private InputHandler inputHandler() {
        if (inputHandler == null) {
            inputHandler = new InputHandler(inputView());
        }
        return inputHandler;
    }
}
