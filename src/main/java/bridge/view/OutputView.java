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

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
