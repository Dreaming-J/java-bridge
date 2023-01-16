package bridge.model;

import bridge.BridgeNumberGenerator;
import bridge.enums.MoveOption;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            int randomNumber = bridgeNumberGenerator.generate();
            String randomTile = MoveOption.fromNumber(randomNumber).getCommand();
            bridge.add(randomTile);
        }

        return bridge;
    }
}
