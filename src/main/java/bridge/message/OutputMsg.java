package bridge.message;

public enum OutputMsg {
    OUTPUT_MSG_GAME_START("다리 건너기 게임을 시작합니다."),
    OPEN_BRAKET("[ "),
    MIDDLE_BRAKET(" | "),
    CLOSE_BRAKET(" ]");

    private final String message;

    OutputMsg(String message) {
        this.message = message;
    }

    public String get() {
        return this.message;
    }
}
