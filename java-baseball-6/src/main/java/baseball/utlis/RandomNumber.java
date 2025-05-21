package baseball.utlis;

import baseball.model.ComputerNumber;

import java.util.*;

public class RandomNumber {

    Random random = new Random();

    public void generateComputerNumbers(ComputerNumber computerNumber){
        List<Integer> numbers = generateRndomNumber(); // 컴퓨터 번호 생성
        System.out.println("정답 : " + numbers);
        computerNumber.initialize(numbers); // 랜덤 번호 저장
    }

    private List<Integer> generateRndomNumber() { // 증복 되지 않게 Set 인터페이스 사용해서 랜덤 번호 3개 추출
        Set<Integer> list = new HashSet<>(3);

        while (list.size() < 3) {
            list.add(random.nextInt(1, 10));
        }

        return new ArrayList<>(list);
    }


}
