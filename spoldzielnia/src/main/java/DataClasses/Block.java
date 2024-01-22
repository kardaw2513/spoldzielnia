package DataClasses;

import java.util.List;

public class Block {
    //fields:
    public final static String tableName="bloki";
    public final static String numberField="numer";
    public final static String occupantsNumberField="liczbaMieszkancow";
    public final static String averageAgeField="sredniWiek";

    public List<Flat> flatList;
    public int number;
    public int occupantsNumber;
    public double averageAge;

    public Block(List<Flat> flatList, int number, int occupantsNumber, double averageAge) {
        this.flatList = flatList;
        this.number = number;
        this.occupantsNumber = occupantsNumber;
        this.averageAge = averageAge;
    }

    public List<Flat> getFlatList() {
        return flatList;
    }

    public void setFlatList(List<Flat> flatList) {
        this.flatList = flatList;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getOccupantsNumber() {
        return occupantsNumber;
    }

    public void setOccupantsNumber(int occupantsNumber) {
        this.occupantsNumber = occupantsNumber;
    }

    public double getAverageAge() {
        return averageAge;
    }

    public void setAverageAge(double averageAge) {
        this.averageAge = averageAge;
    }
}
