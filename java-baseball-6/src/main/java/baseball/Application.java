package baseball;

import baseball.controller.GameController;
import baseball.model.ComputerNumber;
import baseball.model.GameState;
import baseball.model.ReStartNumber;
import baseball.model.UserNumber;
import baseball.service.GameService;
import baseball.utlis.RandomNumber;
import baseball.view.InputViewImpl;
import baseball.view.OutputViewImpl;

public class Application {
    public static void main(String[] args) {
        GameService gameService = new GameService(new RandomNumber(), new GameState(), new UserNumber(), new ReStartNumber(), new ComputerNumber());

        GameController game = new GameController(new InputViewImpl(), new OutputViewImpl(), gameService);
        game.gameStart();
    }
}
