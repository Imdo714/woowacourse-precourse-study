package model;

import static view.ErrorMessage.IS_NOT_UNIT;

public class Price {

    private int price;
    private int count;

    public int getCount() {
        return count;
    }

    public void validator(String getPrice) {
        isUnitChecked(getPrice); // 천원 단위인지 검사
        this.price = Integer.parseInt(getPrice);
        this.count = Integer.parseInt(getPrice) / 1000; // 구매 가능 객수
    }

    private void isUnitChecked(String getPrice) {
        if(!getPrice.endsWith("000")){
            throw new IllegalArgumentException(IS_NOT_UNIT.getText());
        }
    }

    public double profitRate(int totalReward) {
        return (double) totalReward / price * 100;
    }
}
