package view;

public enum ErrorMessage {
    IS_LENGTH_ERROR("[ERROR] 로또 번호는 6개여야 합니다."),
    IS_NOT_UNIT("[ERROR] 1,000원으로 나누어 떨어지지 않습니다."),
    IS_NOT_PARSE_INT("[ERROR] 로또 번호는 숫자이여야 합니다."),
    IS_NOT_WINNING_RANGE("[ERROR] 로또 번호는 1부터 45까지만 입력합니다."),
    IS_DUPLICATION_LOTTO("[ERROR] 로또 번호는 중복되면 안됩니다."),
    IS_DUPLICATION_BONUS("[ERROR] 뽀너스 번호는 당첨 번호와 중복되면 안됩니다.");


    private final String text;

    ErrorMessage(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
