package bridge.util;

import static bridge.enums.ErrorMsg.*;

public class ConvertData {

    public static String mappingBridgeCellIntToString(int number) {
        String value = new String();

        if (number == 0) {
            value = "D";
        }
        if (number == 1) {
            value = "U";
        }

        return value;
    }

    public static int convertStringIntoInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ERROR_PREFIX.get() + ERROR_INPUT_VALUE_IS_NOT_NUMBER.get());
        }
    }
}
