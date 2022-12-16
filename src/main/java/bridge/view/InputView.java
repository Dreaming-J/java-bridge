package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import static bridge.message.InputMsg.*;

public class InputView {

    private final InputValidator inputValidator = new InputValidator();

    public int readBridgeSize() {
        System.out.println(INPUT_MSG_BRIDGE_SIZE.get());
        int bridgeSize = inputValidator.convertStringToInt(Console.readLine());
        inputValidator.validateBridgeSize(bridgeSize);

        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }


}
