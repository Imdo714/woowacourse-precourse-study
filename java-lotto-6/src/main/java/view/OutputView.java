package view;

import model.Lotto;

import java.util.List;

public interface OutputView {
    void printStartPrice();

    void printWinningNumber();

    void printPayment(int count);

    void printLottoNumbers(List<Lotto> lottoList);

    void isExceptionMessage(String message);

    void nextLinBlank();

    void printBonusNumber();
}
