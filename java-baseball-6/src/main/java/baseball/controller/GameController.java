package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.GameState;
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
    GameState gameState = new GameState();

    public GameController(InputView inputView, OutputView outputView, RandomNumber randomNumber) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.randomNumber = randomNumber;
    }

    public void gameStart(){
        saveComputerNumber(); // 게임 시작을 알리고 컴퓨터가 숫자 3개를 computerNumber에 저장한다.
//        saveUserNumber(); // 사용자 입력을 받아 userNumber에 저장

        playGame(); // 컴퓨터 번호랑 사용자 번호를 비교
    }

    private void playGame() {
        while (true){
            saveUserNumber();  // 사용자 입력을 받아 userNumber에 저장

            GameState state = gameState.playGame(computerNumber, userNumber);
            state.print();

            if(state.isThreeStrikes()){
                break;
            }
        }
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
