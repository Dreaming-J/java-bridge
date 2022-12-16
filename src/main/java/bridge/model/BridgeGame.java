package bridge.model;

import bridge.enums.MoveOption;
import bridge.enums.MoveResult;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BridgeGame {

    private final List<String> bridge;
    private Map<MoveOption, List<String>> progressBridges;
    private int runCount;

    public BridgeGame(List<String> bridge) {
        //TODO: 지우기
        System.out.println(bridge);

        this.bridge = bridge;
        this.progressBridges = new EnumMap<>(MoveOption.class);
        this.runCount = 0;
        initProgress();
    }

    public void initProgress() {
        progressBridges.put(MoveOption.UP, new ArrayList<>());
        progressBridges.put(MoveOption.DOWN, new ArrayList<>());
        runCount++;
    }

    public List<String> getProgressBridge(MoveOption moveOption) {
        return Collections.unmodifiableList(progressBridges.get(moveOption));
    }

    public boolean isGameContinue() {
        Stream<String> flatProgressBridge = Stream.of(progressBridges.get(MoveOption.UP), progressBridges.get(MoveOption.DOWN))
                .flatMap(Collection::stream);

        return !(isGameClear() ||
                flatProgressBridge
                .anyMatch(tile -> Objects.equals(tile, MoveResult.UNPASS.get())));
    }

    public boolean isGameClear() {
        Stream<String> flatProgressBridge = Stream.of(progressBridges.get(MoveOption.UP), progressBridges.get(MoveOption.DOWN))
                .flatMap(Collection::stream);

        int numberOfTilePassed = (int) flatProgressBridge
                .filter(tile -> Objects.equals(tile, MoveResult.PASS.get()))
                .count();
        return numberOfTilePassed == bridge.size();
    }

    /**
     * Move
     */
    public boolean move(String command) {
        MoveOption moveOption = MoveOption.fromCommand(command);
        oneStepMoveMainCommandBridge(moveOption);
        oneStepMoveAnotherCommandBridge(moveOption.getAnotherOption());

        return isSuccessToMove(moveOption);
    }

    private void oneStepMoveMainCommandBridge (MoveOption mainOption) {
        List<String> mainProgressBridge = progressBridges.get(mainOption);
        mainProgressBridge.add(calMoveResult(mainOption, mainProgressBridge));
        progressBridges.put(mainOption, mainProgressBridge);
    }

    private void oneStepMoveAnotherCommandBridge (MoveOption anotherOption) {
        List<String> anotherProgressBridge = progressBridges.get(anotherOption);
        anotherProgressBridge.add(MoveResult.UNUSED.get());
        progressBridges.put(anotherOption, anotherProgressBridge);
    }

    private String calMoveResult(MoveOption moveOption, List<String> progressBridge) {
        int index = progressBridge.size();

        if (Objects.equals(bridge.get(index), moveOption.getCommand())) {
            return MoveResult.PASS.get();
        }

        return MoveResult.UNPASS.get();
    }

    private boolean isSuccessToMove(MoveOption mainOption) {
        List<String> mainProgressBridge = progressBridges.get(mainOption);
        int lastIndex = mainProgressBridge.size() - 1;
        String moveResult = mainProgressBridge.get(lastIndex);

        return Objects.equals(moveResult, MoveResult.PASS.get());
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
