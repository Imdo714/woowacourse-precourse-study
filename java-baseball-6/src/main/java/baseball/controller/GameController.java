package baseball.controller;

import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final GameService gameService;


    public GameController(InputView inputView, OutputView outputView, GameService gameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameService = gameService;
    }

    public void gameStart(){
        boolean reStartGame = true;

        while (reStartGame){
            saveComputerNumber(); // 게임 시작을 알리고 컴퓨터가 숫자 3개를 computerNumber에 저장한다.

            playGame(); // 컴퓨터 번호랑 사용자 번호를 비교
            reStartGame = reStartGame();
        }
    }

    private void playGame() {
        boolean compare = true;

        while (compare){
            saveUserNumber();  // 사용자 입력을 받아 userNumber에 저장
            compare = gameService.compareNumber(); // 숫자 비교 해서 삼진인지 확인
        }
    }

    private boolean reStartGame() {
        outputView.reStartMessage(); // 게임 새로 시작할건지 묻는 메세지
        String reNumber = inputView.getWriteUserNumber();// 1이면 재시작 2면 종료

        return gameService.reNUmberCheck(reNumber);
    }

    private void saveComputerNumber() {
        outputView.startMessage();
        gameService.saveComputerNumber(); // 게임 시작을 알리고 컴퓨터가 숫자 3개를 computerNumber에 저장한다.
    }

    private void saveUserNumber() {
        outputView.writeUserNumberMessage();
        gameService.saveUserNumber(inputView.getWriteUserNumber());
    }

}
