package view;

import model.Lotto;
import model.LottoList;
import model.Rank;

import java.util.Map;


public interface OutputView {
    void printStartPrice();

    void printWinningNumber();

    void printPayment(int count);

    void printLottoNumbers(Lotto lotto);

    void isExceptionMessage(String message);

    void nextLinBlank();

    void printBonusNumber();

    void printProfitRate(double rate);

    void printStatistics(String message, int reward, int count);

    void printStatisticsMessage();

}
