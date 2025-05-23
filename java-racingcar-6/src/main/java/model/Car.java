package model;

public class Car {

     private static final int NAME_LENGTH_MAX = 5;
    private static final int MOVE_MIN_SPEED = 4;

    private String carName;
    private int position;

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public Car(String carName) {
        validate(carName);
        this.carName = carName;
        this.position = 0;
    }

    public void validate(String carName){
        if(carName.length() > NAME_LENGTH_MAX){
            throw new IllegalArgumentException();
        }
    }

    public void move(int number) {
        if(MOVE_MIN_SPEED >= number){
            this.position++;
        }
    }
}
