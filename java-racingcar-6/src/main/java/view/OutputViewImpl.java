package view;

import java.util.List;

public class OutputViewImpl implements OutputView {

    private static final String START_RACING_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_CHALLENGE_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String FINAL_CHAMPION_MESSAGE = "최종 우승자 : ";
    private static final String COLON_MESSAGE = " : ";
    private static final String HYPHEN_MESSAGE = "-";


    @Override
    public void startRacingCarNames() {
        System.out.println(START_RACING_CAR_NAMES);
    }

    @Override
    public void printTryChallengeCount() {
        System.out.println(TRY_CHALLENGE_COUNT_MESSAGE);
    }

    @Override
    public void printWinnerName(List<String> list) {
        System.out.println(FINAL_CHAMPION_MESSAGE + String.join(", ", list));
    }

    @Override
    public void getPrintCarName(String carName) {
        System.out.print(carName + COLON_MESSAGE);
    }

    @Override
    public void getPrintHyphen() {
        System.out.print(HYPHEN_MESSAGE);
    }

    @Override
    public void getPrintGap() {
        System.out.println();
    }
}
