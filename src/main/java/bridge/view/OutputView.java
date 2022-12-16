package bridge.view;

import java.util.List;

import static bridge.message.OutputMsg.*;

public class OutputView {

    private static final int ONE = 1;

    public void printStart() {
        System.out.println(OUTPUT_MSG_GAME_START.get());
    }

    public void printMap(List<String> progressBridge) {
        System.out.print(OPEN_BRAKET.get());
        for (int index = 0; index < progressBridge.size(); index++) {
            System.out.print(progressBridge.get(index));
            if (index != progressBridge.size() - ONE) {
                System.out.print(MIDDLE_BRAKET.get());
            }
        }
        System.out.println(CLOSE_BRAKET.get());
    }

    public void printResult() {
        System.out.println(OUTPUT_MSG_GAME_OVER.get());
    }

    public void printStatus(boolean isSuccess, int runCount) {
        if (isSuccess) {
            System.out.println(OUTPUT_MSG_GAME_STATUS.get() + SUCCESS.get());
            System.out.println(OUTPUT_MSG_RUN_COUNT.get() + runCount);
            return;
        }

        System.out.println(OUTPUT_MSG_GAME_STATUS.get() + FAIL.get());
        System.out.println(OUTPUT_MSG_RUN_COUNT.get() + runCount);
    }
}
