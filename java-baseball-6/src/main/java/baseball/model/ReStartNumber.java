package baseball.model;

public class ReStartNumber {

    private static final String RESTART = "1";
    private static final String QUIT = "2";

    private int reStartNumber;

    public void initialize(String reNumber) {
        validate(reNumber);
        this.reStartNumber = Integer.parseInt(reNumber);
    }

    public void validate(String resNumber){
        if (isNotOneAndTwo(resNumber)) {
            throw new IllegalArgumentException("1 또는 2만 입력 가능합니다.");
        }
    }

    public static boolean isNotOneAndTwo(String resNumber) {
        return !RESTART.equals(resNumber) && !QUIT.equals(resNumber);
    }

    public boolean isReStarts() {
        return this.reStartNumber == 1;
    }
}
