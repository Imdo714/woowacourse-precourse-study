import controller.lottoController;
import model.Price;
import model.Winning;
import utlis.RandomNumber;
import view.InputViewImpl;
import view.OutputViewImpl;

public class Application {
    public static void main(String[] args){
        lottoController lottoController = new lottoController(new InputViewImpl(), new OutputViewImpl(), new Price(), new RandomNumber(), new Winning());
        lottoController.start();

    }
}
