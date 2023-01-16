package bridge.message;

public enum ErrorMsg {
    ERROR_MSG_BRIDGE_SIZE_MUST_BE_INTEGER_BETWEEN_3_AND_20("3~20 사이의 숫자만 입력해주세요."),
    ERROR_MSG_COMMAND_DOES_NOT_EXIST("해당 입력은 사용할 수 없습니다.");

    private final String message;

    ErrorMsg(String message) {
        this.message = message;
    }

    public String get() {
        return this.message;
    }
}
