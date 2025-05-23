package baseball.view;

public interface OutputView {
    void startMessage();

    void writeUserNumberMessage();

    void endGameMessage();

    void reStartMessage();

    void printNothing();

    void printVerdict(int ball, int strike);
}
