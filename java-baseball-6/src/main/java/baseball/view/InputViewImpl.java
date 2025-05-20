package baseball.view;

import java.util.Scanner;

public class InputViewImpl implements InputView {

    Scanner sc = new Scanner(System.in);

    @Override
    public String getWriteUserNumber() {
        return sc.nextLine();
    }

}
