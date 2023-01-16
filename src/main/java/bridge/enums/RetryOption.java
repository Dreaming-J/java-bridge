package bridge.enums;

import java.util.Objects;
import java.util.stream.Stream;

public enum RetryOption {
    RETRY("R"),
    QUIT("Q");

    private final String command;

    RetryOption(String command) {
        this.command = command;
    }

    public static boolean isRetry(String command) {
        return Objects.equals(RETRY.command, command);
    }

    public static boolean isNotContaionsCommand(String command) {
        return !Stream.of(values())
                .anyMatch(option -> option.command.equals(command));
    }
}