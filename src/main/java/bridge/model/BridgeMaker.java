package bridge.model;

import bridge.BridgeNumberGenerator;
import bridge.enums.BridgeTile;

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
            String randomTile = BridgeTile.from(randomNumber).getValue();
            bridge.add(randomTile);
        }

        return bridge;
    }
}
