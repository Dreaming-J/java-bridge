package bridge.message;

public enum InputMsg {
    INPUT_MSG_BRIDGE_SIZE("\n다리의 길이를 입력해주세요."),
    INPUT_MSG_MOVE_COMMAND("\n이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_MSG_RETRY_COMMAND("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

    private final String message;

    InputMsg(String message) {
        this.message = message;
    }

    public String get() {
        return this.message;
    }
}
