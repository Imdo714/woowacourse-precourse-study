package view;

import model.Lotto;

import java.util.List;

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
    public void printLottoNumbers(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
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

}
