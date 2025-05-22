package baseball.service;

import baseball.model.ComputerNumber;
import baseball.model.GameState;
import baseball.model.ReStartNumber;
import baseball.model.UserNumber;
import baseball.utlis.RandomNumber;

public class GameService {
    private final RandomNumber randomNumber;
    GameState gameState = new GameState();
    UserNumber userNumber = new UserNumber();
    ReStartNumber reStartNumber = new ReStartNumber();
    ComputerNumber computerNumber = new ComputerNumber();

    public GameService(RandomNumber randomNumber) {
        this.randomNumber = randomNumber;
    }

    public void saveComputerNumber() {
        randomNumber.generateComputerNumbers(computerNumber);
    }

    public void saveUserNumber(String writeUserNumber) {
        userNumber.initialize(writeUserNumber);
    }

    public boolean compareNumber(){
        GameState state = gameState.playGame(computerNumber, userNumber);
        state.print();
        return state.isNotThreeStrikes();
    }

    public boolean reNUmberCheck(String Number) {
        reStartNumber.initialize(Number);
        return reStartNumber.isReStarts();
    }
}
