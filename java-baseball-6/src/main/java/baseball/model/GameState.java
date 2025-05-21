package baseball.model;

public class GameState {

    private int strike;
    private int ball;

    public GameState(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public GameState() {
        this.strike = strike;
        this.ball = ball;
    }

    public boolean isThreeStrikes() {
        return strike == 3;
    }

    public void print() {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    public GameState playGame(ComputerNumber computerNumber, UserNumber userNumber){
        boolean[] currentStrike = new boolean[3];
        boolean[] currentBall = new boolean[3];

        // 스트라이크 판별
        int totalStrike = isCheckedStrike(computerNumber, userNumber, currentStrike);

        // 볼 판별
        int totalBall = isCheckedBall(computerNumber, userNumber, currentStrike, currentBall);

        return new GameState(totalStrike, totalBall);
    }

    private static Integer isCheckedStrike(ComputerNumber computerNumber, UserNumber userNumber, boolean[] currentStrike) {
        Integer res = 0;
        for(int i = 0; i < 3; i++){
            if(userNumber.getUserNumber().get(i).equals(computerNumber.getComputerNumber().get(i))){
                currentStrike[i] = true;
                res++;
            }
        }
        return res;
    }

    private static Integer isCheckedBall(ComputerNumber computerNumber, UserNumber userNumber, boolean[] currentStrike, boolean[] currentBall) {
        Integer res = 0;

        for(int i = 0; i < 3; i++){
            if(currentStrike[i]) continue;

            if(isBallBoolean(computerNumber, userNumber, i, currentStrike, currentBall)){
                currentBall[i] = true;
                res++;
            }
        }
        return res;
    }

    private static boolean isBallBoolean(ComputerNumber computerNumber, UserNumber userNumber, int userIndex, boolean[] currentStrike, boolean[] currentBall) {
        for (int compIndex = 0; compIndex < 3; compIndex++) {
            if (userIndex == compIndex) continue; // 같은 자리면 스트라이크이므로 제외
            if (currentStrike[compIndex]) continue; // 상대 자리가 이미 스트라이크면 제외

            if (userNumber.getUserNumber().get(userIndex).equals(computerNumber.getComputerNumber().get(compIndex))) {
                return true; // 자리 다르고 값 같은 경우 볼
            }
        }
        return false;
    }

}
