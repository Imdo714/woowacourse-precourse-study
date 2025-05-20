package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.UserNumber;
import baseball.utlis.RandomNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RandomNumber randomNumber;
    ComputerNumber computerNumber = new ComputerNumber(); // GameController 필요할때 생성 하게 만듬
    UserNumber userNumber = new UserNumber();

    public GameController(InputView inputView, OutputView outputView, RandomNumber randomNumber) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.randomNumber = randomNumber;
    }

    public void gameStart(){
        saveComputerNumber(); // 게임 시작을 알리고 컴퓨터가 숫자 3개를 computerNumber에 저장한다.
        saveUserNumber(); // 사용자 입력을 받아 userNumber에 저장

        // 컴퓨터 번호랑 사용자 번호를 비교해야 함

    }

    private void saveComputerNumber() {
        outputView.startMessage();
        randomNumber.generateComputerNumbers(computerNumber);
    }

    private void saveUserNumber() {
        outputView.writeUserNumberMessage();
        String writeUserNumber = inputView.getWriteUserNumber();
        userNumber.initialize(writeUserNumber);
    }

}
