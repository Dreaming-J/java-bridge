package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.model.BridgeMaker;
import bridge.module.RepeatModule;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController extends RepeatModule {

    private final BridgeGame bridgeGame;
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public GameController() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        outputView.printStart();
        int bridgeSize = repeat(inputView::readBridgeSize);
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(bridgeSize));
    }

    public void start() {
        bridgeGame.print();

        do {
            String moveCommand = repeat(inputView::readMoving);
            bridgeGame.move(moveCommand);
            //TODO: 진행상황 출력
        } while (bridgeGame.isGameContinue());

        bridgeGame.print();
    }
}
