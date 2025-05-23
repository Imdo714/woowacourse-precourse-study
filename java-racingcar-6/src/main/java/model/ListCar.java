package model;

import Utils.RandomNumber;
import view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListCar {

    private List<Car> carList;

    public void addCar(String carNames) {
        this.carList = Arrays.stream(carNames.split(","))
                .map(s -> s.trim())
                .filter(s -> !s.isEmpty())
                .map(c -> new Car(c))
                .toList();
    }

    public void randomStart(int count, RandomNumber randomNumber, OutputView outputView) {
        for(int i = 0; i < count; i++){
            moveRandom(randomNumber); // 랜덤 값 4이상이면 전진
            isRacingAction(outputView);  // 상황 보여주는 메서드

            outputView.getPrintGap(); // 공백
        }
    }

    private void moveRandom(RandomNumber randomNumber) {
        for(Car car : carList){
            int number = randomNumber.generationNumber();
            car.move(number);
        }
    }

    private void isRacingAction(OutputView outputView) {
        for (Car car : carList) {
            outputView.getPrintCarName(car.getCarName()); // 이름 출력
            moveForward(outputView, car); // 속도 출력

            outputView.getPrintGap(); // 공백
        }
    }

    private static void moveForward(OutputView outputView, Car car) {
        for (int j = 0; j < car.getPosition(); j++) {
            outputView.getPrintHyphen();
        }
    }

    public List<String> findWinners() {
        int max = getMax();

        return carList.stream()
                .filter(c -> c.getPosition() == max)
                .map(c -> c.getCarName())
                .collect(Collectors.toList());
    }

    public int getMax() {
        return carList.stream()
                .mapToInt(c -> c.getPosition())
                .max()
                .orElse(0);
    }
}
