package baseball.view;

public class OutputViewImpl implements OutputView {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String WRITE_USER_MESSAGE = "숫자를 입력해주세요 : ";

    @Override
    public void startMessage() {
        System.out.println(START_MESSAGE);
    }

    @Override
    public void writeUserNumberMessage() {
        System.out.print(WRITE_USER_MESSAGE);
    }
}
