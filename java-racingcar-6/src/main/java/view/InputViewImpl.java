package view;

import java.util.Scanner;

public class InputViewImpl implements InputView {

    Scanner sc = new Scanner(System.in);

    @Override
    public String writeRacingCarNames() {
        return sc.nextLine();
    }

    @Override
    public int tryCount() {
        return sc.nextInt();
    }
}
