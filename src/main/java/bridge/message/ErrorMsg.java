package bridge.message;

public enum ErrorMsg {
    ERROR_MSG_BRIDGE_SIZE_MUST_BE_INTEGER_BETWEEN_3_AND_20("3~20 사이의 숫자만 입력해주세요.");

    private final String message;

    ErrorMsg(String message) {
        this.message = message;
    }

    public String get() {
        return this.message;
    }
}
