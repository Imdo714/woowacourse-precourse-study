import controller.PlayGameController;
import view.InputViewImpl;
import view.OutputViewImpl;

public class Application {

    public static void main(String[] args) {
        PlayGameController playGameController = new PlayGameController(new OutputViewImpl(), new InputViewImpl());
        playGameController.start();
    }
}