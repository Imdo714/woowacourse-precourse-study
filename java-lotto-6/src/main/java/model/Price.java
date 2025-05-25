package model;

import static view.ErrorMessage.IS_NOT_UNIT;

public class Price {
    private static final int PRICE_UNIT_DIVIDE = 1000;
    private static final String PRICE_UNIT_SUFFIX = "000";
    private static final int PROFIT_RATE_PERCENT = 100;


    private int price;
    private int count;

    public int getCount() {
        return count;
    }

    public void validator(String getPrice) {
        isUnitChecked(getPrice); // 천원 단위인지 검사
        this.price = Integer.parseInt(getPrice);
        this.count = Integer.parseInt(getPrice) / PRICE_UNIT_DIVIDE; // 구매 가능 객수
    }

    private void isUnitChecked(String getPrice) {
        if(!getPrice.endsWith(PRICE_UNIT_SUFFIX)){
            throw new IllegalArgumentException(IS_NOT_UNIT.getText());
        }
    }

    public double profitRate(int totalReward) {
        return (double) totalReward / price * PROFIT_RATE_PERCENT;
    }
}
