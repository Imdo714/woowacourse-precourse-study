package baseball.view;

public class OutputViewImpl implements OutputView {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String WRITE_USER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String END_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RE_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    @Override
    public void startMessage() {
        System.out.println(START_MESSAGE);
    }

    @Override
    public void writeUserNumberMessage() {
        System.out.print(WRITE_USER_MESSAGE);
    }

    @Override
    public void endGameMessage() {
        System.out.println(END_GAME_MESSAGE);
    }

    @Override
    public void reStartMessage() {
        System.out.println(RE_GAME_MESSAGE);
    }
}
