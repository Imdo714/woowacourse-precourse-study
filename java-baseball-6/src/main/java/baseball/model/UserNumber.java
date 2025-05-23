package baseball.model;

import java.util.List;

public class UserNumber {

    private List<Integer> userNumber;

    public List<Integer> getUserNumber() {
        return userNumber;
    }

    public void initialize(String userNumber){
        validate(userNumber);

        this.userNumber = typeUpdate(userNumber);
    }

    public void validate(String userNumber){
        isEmptyUserNumberValid(userNumber);
        isUserNumberLengthValid(userNumber);
        isUserNumberRangeValid(userNumber);
        isDuplicationVaile(userNumber);
    }

    public void isEmptyUserNumberValid(String userNumber) {
        if (userNumber == null || userNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어 있거나 공백입니다.");
        }
    }

    private static void isUserNumberLengthValid(String userNumber) {
        if(userNumber.length() != 3){
            throw new IllegalArgumentException("숫자는 3개 작성하여야 합니다.");
        }
    }

    private static void isUserNumberRangeValid(String userNumber) {
        if(!userNumber.matches("[1-9]+")){ // matches : 문자열이 정규식과 일치하는지 검사, [1-9] : 1에서 9까지의 숫자, + : 하나 이상 (즉, 최소 한 자리 이상 숫자가 있어야 함 공백 X )
            throw new IllegalArgumentException("숫자는 1~9까지만 작성하여야 합니다.");
        }
    }

    private void isDuplicationVaile(String userNumber) {
        if(hasDuplication(userNumber)){
            throw new IllegalArgumentException("숫자는 중복이면 안돼");
        }
    }

    private boolean hasDuplication(String userNumber) {
        // Stream API를 사용한 GPT방식
        // chars : 아스키코드로 변경
        // distinct : 증복 제거
        // count : 수량세기
        return userNumber.chars().distinct().count() != userNumber.length();
    }

    private List<Integer> typeUpdate(String userNumber) {

        return userNumber.chars()
                .map(c -> c - '0')
                .boxed() // 기본형을 객체로 감싸줄떄 사용 (int -> Integer)
                .toList();
    }


}
