package model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static view.ErrorMessage.*;

public class Winning {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;

    private List<Integer> winnings;
    private int bonus;

    public void validWinning(String getWinning) {
        this.winnings = validSplit(getWinning);
        validateNumberRange(winnings);      // 1부터 45까지 인지 검사
        validateSize(winnings);             // 로또 번호 6개인지 검사
        validateWinningLength(winnings);    // 중복 검사
    }

    public void validBonus(String writeNumber) {
        this.bonus = parseInt(writeNumber); // 숫자 타입인지
        rangeOneAndFortyFive(bonus); // 1부터 45까지인지
        bonusDuplication(bonus); // 당첨 번호랑 중복있는지
    }

    private List<Integer> validSplit(String getWinning) {
        return Arrays.stream(getWinning.split(","))
                .map(c -> c.trim())
                .map(c -> parseInt(c))
                .collect(Collectors.toList());
    }

    private int parseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(IS_NOT_PARSE_INT.getText());
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            rangeOneAndFortyFive(number);
        }
    }

    private void rangeOneAndFortyFive(int number) {
        if (number < LOTTO_MIN_NUMBER  || number > LOTTO_MAX_NUMBER ) {
            throw new IllegalArgumentException(IS_NOT_WINNING_RANGE.getText());
        }
    }

    private void validateSize(List<Integer> numbers)  {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(IS_LENGTH_ERROR.getText());
        }
    }

    private void validateWinningLength(List<Integer> list) {
        Set<Integer> setList = new HashSet<>();

        for(int num : list){
            setList.add(num);
        }

        isSetListSizeCheck(setList); // 6개 보다 작으면 증복 걸림
    }

    private void isSetListSizeCheck(Set<Integer> setList) {
        if(setList.size() < LOTTO_NUMBER_SIZE){
            throw new IllegalArgumentException(IS_DUPLICATION_LOTTO.getText());
        }
    }

    public void bonusDuplication(int number) {
        if(winningContains(number)){
            throw new IllegalArgumentException(IS_DUPLICATION_BONUS.getText());
        }
    }

    public boolean winningContains(int number) {
        return winnings.contains(number);
    }

    public int getBonus() {
        return bonus;
    }
}
