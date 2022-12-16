package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.enums.MoveOption;
import bridge.enums.RetryOption;
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
        do {
            String moveCommand = repeat(inputView::readMoving);
            bridgeGame.move(moveCommand);

            outputView.printMap(bridgeGame.getProgressBridge(MoveOption.UP));
            outputView.printMap(bridgeGame.getProgressBridge(MoveOption.DOWN));
        } while (bridgeGame.isGameContinue());

        retryBranch();
    }

    private void retryBranch() {
        if (bridgeGame.isGameClear()) {
            quit();
            return;
        }

        retry();
    }

    private void retry() {
        String retryCommand = repeat(inputView::readGameCommand);

        if (RetryOption.isRetry(retryCommand)) {
            bridgeGame.retry();
            start();
            return;
        }

        quit();
    }

    private void quit() {
        //TODO: 수정
        System.out.println("종료");
    }
}
