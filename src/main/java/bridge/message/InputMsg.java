package bridge.message;

public enum InputMsg {
    INPUT_MSG_BRIDGE_SIZE("\n다리의 길이를 입력해주세요.");

    private final String message;

    InputMsg(String message) {
        this.message = message;
    }

    public String get() {
        return this.message;
    }
}
