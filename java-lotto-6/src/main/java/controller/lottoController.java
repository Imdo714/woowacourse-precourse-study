package controller;

import model.Lotto;
import model.Price;
import model.Winning;
import utlis.RandomNumber;
import view.InputView;
import view.OutputView;

import java.util.List;

public class lottoController {

    private final InputView inputView;
    private final OutputView outputView;
    Price price = new Price();
    RandomNumber randomNumber = new RandomNumber();
    Winning winning = new Winning();

    public lottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start(){
        getPriceAndValid(); // 금액 및 로또 갯수 계산

        getLottoSaved(); // 금액에 맞게 로또 번호 6개 뽑아서 Lotte 도메인에 저장

        getWinningLotto(); // 당첨 번호 입력 받아 검증

        getBonusNumber(); // 보너스 번호 입력 받아 검증
    }

    private void getPriceAndValid() {
        while (true){
            try{
                price.validator(getPriceNumber()); // 천원 단위 검사 및 로또 갯수 계산
                break;
            } catch (IllegalArgumentException e){
                outputView.isExceptionMessage(e.getMessage());
            }
        }
        outputView.printPayment(price.getCount());
    }

    private String getPriceNumber() {
        outputView.printStartPrice(); // 금액 입력하라고 출력
        String getPrice = inputView.getWriteNumber();

        outputView.nextLinBlank(); // 한줄 띄우기
        return getPrice;
    }

    private void getLottoSaved() {
        List<Lotto> lottoList = randomNumber.generation(price.getCount());
        outputView.printLottoNumbers(lottoList);  // 로또 번호 출력
    }

    private void getWinningLotto() {
        while (true){
            try{
                winning.validWinning(getWinningNumber());
                break;
            } catch (IllegalArgumentException e){
                outputView.isExceptionMessage(e.getMessage());
            }
        }
    }

    private String getWinningNumber() {
        outputView.printWinningNumber();
        String getWinning = inputView.getWriteNumber(); // 당첨 번호 입력

        outputView.nextLinBlank(); // 한줄 띄우기
        return getWinning;
    }

    private void getBonusNumber() {
        outputView.printBonusNumber();
        String writeNumber = inputView.getWriteNumber();
        winning.validBonus(writeNumber); // 보너스 볼 범위 숫자만 입력 하게 만듬
    }
}
