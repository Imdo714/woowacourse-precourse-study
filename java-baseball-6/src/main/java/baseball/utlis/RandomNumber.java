package baseball.utlis;

import baseball.model.ComputerNumber;

import java.util.*;

public class RandomNumber {

    private static final int MAX_LENGTH = 3;
    private static final int START_LENGTH = 3;
    private static final int LAST_LENGTH = 3;

    Random random = new Random();

    public void generateComputerNumbers(ComputerNumber computerNumber){
        List<Integer> numbers = generateRndomNumber(); // 컴퓨터 번호 생성
        System.out.println("정답 : " + numbers);
        computerNumber.initialize(numbers); // 랜덤 번호 저장
    }

    private List<Integer> generateRndomNumber() { // 증복 되지 않게 Set 인터페이스 사용해서 랜덤 번호 3개 추출
        Set<Integer> list = new HashSet<>(MAX_LENGTH);

        while (list.size() < MAX_LENGTH) {
            list.add(random.nextInt(START_LENGTH, LAST_LENGTH));
        }

        return new ArrayList<>(list);
    }


}
