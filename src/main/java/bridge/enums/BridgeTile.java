package bridge.enums;

import java.util.stream.Stream;

public enum BridgeTile {
    DOWN(0, "D"),
    UP(1, "U");

    private final int number;
    private final String value;

    BridgeTile(int number, String value) {
        this.number = number;
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static BridgeTile from(int number) {
        return Stream.of(values())
                .filter(tile -> tile.number == number)
                .findFirst()
                .get();
    }
}
