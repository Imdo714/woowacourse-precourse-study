package view;

import java.util.Scanner;

public class InputViewImpl implements InputView {

    Scanner sc = new Scanner(System.in);

    @Override
    public String getWriteNumber() {
        return sc.nextLine();
    }

}
