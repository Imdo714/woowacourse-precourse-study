package utlis;

import model.Lotto;

import java.util.*;

public class RandomNumber {

    Random random = new Random();

    public List<Lotto> generation(int count){
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> numbers = getRandomNumbers();
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    public List<Integer> getRandomNumbers() {
        Set<Integer> numberSet = new HashSet<>();

        while (numberSet.size() < 6) {
            int num = random.nextInt(45) + 1;
            numberSet.add(num);
        }

        List<Integer> numbers = new ArrayList<>(numberSet);
        Collections.sort(numbers); // 보기 좋게 정렬
        return numbers;
    }

}
