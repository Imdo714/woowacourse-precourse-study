package baseball.service;

import baseball.model.ComputerNumber;
import baseball.model.GameState;
import baseball.model.ReStartNumber;
import baseball.model.UserNumber;
import baseball.utlis.RandomNumber;
import baseball.view.OutputView;

public class GameService {
    private final RandomNumber randomNumber;
    private final GameState gameState;
    private final UserNumber userNumber;
    private final ReStartNumber reStartNumber;
    private final ComputerNumber computerNumber;

    public GameService(RandomNumber randomNumber, GameState gameState, UserNumber userNumber, ReStartNumber reStartNumber, ComputerNumber computerNumber) {
        this.randomNumber = randomNumber;
        this.gameState = gameState;
        this.userNumber = userNumber;
        this.reStartNumber = reStartNumber;
        this.computerNumber = computerNumber;
    }

    public void saveComputerNumber() {
        randomNumber.generateComputerNumbers(computerNumber);
    }

    public void saveUserNumber(String writeUserNumber) {
        userNumber.initialize(writeUserNumber);
    }

    public boolean compareNumber(OutputView outputView){
        GameState state = gameState.playGame(computerNumber, userNumber);
        state.print(outputView);
        return state.isNotThreeStrikes();
    }

    public boolean reNUmberCheck(String Number) {
        reStartNumber.initialize(Number);
        return reStartNumber.isReStarts();
    }
}
