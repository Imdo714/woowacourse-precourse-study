package baseball.model;

public class ReStartNumber {

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
        return !"1".equals(resNumber) && !"2".equals(resNumber);
    }

    public boolean isReStarts() {
        return this.reStartNumber == 1;
    }
}
