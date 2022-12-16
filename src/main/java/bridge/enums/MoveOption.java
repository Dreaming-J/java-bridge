package bridge.enums;

import java.util.Objects;
import java.util.stream.Stream;

public enum MoveOption {
    DOWN("D", 0),
    UP("U", 1);

    private final String command;
    private final int number;

    MoveOption(String command, int number) {
        this.command = command;
        this.number = number;
    }

    public String getCommand() {
        return this.command;
    }

    public MoveOption getAnotherOption() {
        return Stream.of(values())
                .filter(option -> !Objects.equals(option, this))
                .findFirst()
                .get();
    }

    public static MoveOption fromCommand(String command) {
        return Stream.of(values())
                .filter(option -> Objects.equals(option.command, command))
                .findFirst()
                .get();
    }

    public static MoveOption fromNumber(int number) {
        return Stream.of(values())
                .filter(option -> option.number == number)
                .findFirst()
                .get();
    }
}
