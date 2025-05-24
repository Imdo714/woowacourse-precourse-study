package view;

import model.Lotto;
import model.LottoList;
import model.Rank;

import java.util.List;
import java.util.Map;

public class OutputViewImpl implements OutputView {

    private static final String START_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String COUNT_PAYMENT_MESSAGE = "개를 구매했습니다.";
    private static final String PRINT_BONUS_MESSAGE = "보너스 번호를 입력해 주세요.";

    @Override
    public void printStartPrice() {
        System.out.println(START_PRICE_MESSAGE);
    }

    @Override
    public void printWinningNumber() {
        System.out.println(WINNING_NUMBER_MESSAGE);
    }

    @Override
    public void printPayment(int count) {
        System.out.println(count + COUNT_PAYMENT_MESSAGE);
    }

    @Override
    public void printLottoNumbers(Lotto lotto) {
        System.out.println(lotto);
        nextLinBlank();
    }

    @Override
    public void isExceptionMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void nextLinBlank() {
        System.out.println();
    }

    @Override
    public void printBonusNumber() {
        System.out.println(PRINT_BONUS_MESSAGE);
    }

    @Override
    public void printProfitRate(double rate) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", rate);
    }

    @Override
    public void printStatistics(String message, int reward, int count) {
        System.out.printf("%s (%,d원) - %d개\n", message, reward, count);
    }

    @Override
    public void printStatisticsMessage() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

}
