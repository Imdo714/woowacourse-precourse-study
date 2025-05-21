package baseball;

import baseball.controller.GameController;
import baseball.utlis.RandomNumber;
import baseball.view.InputViewImpl;
import baseball.view.OutputViewImpl;

public class Application {
    public static void main(String[] args) {
        GameController game = new GameController(new InputViewImpl(), new OutputViewImpl(), new RandomNumber());
        game.gameStart();
    }
}
