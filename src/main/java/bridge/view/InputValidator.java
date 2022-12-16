package bridge.view;

import static bridge.message.ErrorMsg.*;

public class InputValidator {

    private static final int LOWER_BRIDGE_SIZE_INCLUSIVE = 3;
    private static final int UPPER_BRIDGE_SIZE_INCLUSIVE = 20;

    public int convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MSG_BRIDGE_SIZE_MUST_BE_INTEGER_BETWEEN_3_AND_20.get());
        }
    }

    public void validateBridgeSize(int input) {
        if (input < LOWER_BRIDGE_SIZE_INCLUSIVE || input > UPPER_BRIDGE_SIZE_INCLUSIVE) {
            throw new IllegalArgumentException(ERROR_MSG_BRIDGE_SIZE_MUST_BE_INTEGER_BETWEEN_3_AND_20.get());
        }
    }
}
