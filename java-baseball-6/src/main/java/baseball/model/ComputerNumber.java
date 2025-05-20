package baseball.model;

import java.util.List;

public class ComputerNumber {

    private List<Integer> computerNumber;

    public void initialize(List<Integer> numbers) {
        this.computerNumber = numbers;
    }

    public List<Integer> getComputerNumber() {
        return computerNumber;
    }


}
