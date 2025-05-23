package controller;

import Utils.RandomNumber;
import model.ListCar;
import view.InputView;
import view.OutputView;

import java.util.List;

public class PlayGameController {

    private final OutputView outputView;
    private final InputView inputView;
    ListCar listCar = new ListCar();
    RandomNumber randomNumber = new RandomNumber();

    public PlayGameController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void start(){
        ioRacingCarNames(); // 자동차 입력 받아 저장

        playRacingGame(); // 랜덤 번호 돌려 게임 진행

        isPrintWinnerNames(); // 우승자 비교해서 이름 보여주기
    }

    private void ioRacingCarNames() {
        outputView.startRacingCarNames();
        String carNames = inputView.writeRacingCarNames();
        listCar.addCar(carNames);
    }

    private void playRacingGame() {
        outputView.printTryChallengeCount();
        int count = inputView.tryCount();
        listCar.randomStart(count, randomNumber, outputView);
    }

    private void isPrintWinnerNames() {
        List<String> list = listCar.findWinners();
        outputView.printWinnerName(list);
    }
}
