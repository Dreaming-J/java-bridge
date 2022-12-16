package bridge.message;

public enum OutputMsg {
    OUTPUT_MSG_GAME_START("다리 건너기 게임을 시작합니다."),
    OPEN_BRAKET("[ "),
    MIDDLE_BRAKET(" | "),
    CLOSE_BRAKET(" ]"),
    OUTPUT_MSG_GAME_OVER("최종 게임 결과"),
    OUTPUT_MSG_GAME_STATUS("게임 성공 여부: "),
    SUCCESS("성공"),
    FAIL("실패"),
    OUTPUT_MSG_RUN_COUNT("총 시도한 횟수: ");

    private final String message;

    OutputMsg(String message) {
        this.message = message;
    }

    public String get() {
        return this.message;
    }
}
