package view;

import java.util.List;

public interface OutputView {
    void startRacingCarNames();

    void printTryChallengeCount();

    void printWinnerName(List<String> list);

    void getPrintCarName(String carName);

    void getPrintHyphen();

    void getPrintGap();
}
