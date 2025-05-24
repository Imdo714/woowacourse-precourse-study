import controller.lottoController;
import view.InputViewImpl;
import view.OutputViewImpl;

public class Application {
    public static void main(String[] args){
        lottoController lottoController = new lottoController(new InputViewImpl(), new OutputViewImpl());
        lottoController.start();

    }
}
