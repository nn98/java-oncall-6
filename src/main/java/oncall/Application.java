package oncall;

import oncall.controller.Controller;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Config().controller();
        controller.run();
    }
}
