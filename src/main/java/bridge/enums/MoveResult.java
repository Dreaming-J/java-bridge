package bridge.enums;

import java.util.stream.Stream;

public enum MoveResult {
    PASS("O"),
    UNPASS("X"),
    UNUSED(" ");

    private final String result;

    MoveResult(String result) {
        this.result = result;
    }

    public String get() {
        return this.result;
    }
}
