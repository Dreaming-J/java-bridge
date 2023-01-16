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

    public String readMoving() {
        System.out.println(INPUT_MSG_MOVE_COMMAND.get());
        String moveCommand = Console.readLine();
        inputValidator.validateMoveCommand(moveCommand);

        return moveCommand;
    }

    public String readGameCommand() {
        System.out.println(INPUT_MSG_RETRY_COMMAND.get());
        String retryCommand = Console.readLine();
        inputValidator.validateRetryCommand(retryCommand);

        return retryCommand;
    }
}
