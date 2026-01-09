package oncall.domain;

public class Employee {

    private final String nickname;

    public Employee(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return nickname;
    }
}
