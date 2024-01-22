package DataClasses;

public class Bill {
    //fields:
    public static final String tableName="rachunki";
    public static final String idField="id";
    public static final String gasField="gaz";
    public static final String waterField="woda";
    public static final String electricityField="prad";
    public static final String paidField="oplacono";
    public static final String flatIdField="idMieszkania";
    public static final String flatNumberField="numerMieszkania";

    public double gas;
    public double water;
    public double electricity;
    public int id;
    public int flatId;
    public int flatNumber;
    public boolean paid;

    public Bill(double gas, double water, double electricity, int id, int flatId, int flatNumber, boolean paid) {
        this.gas = gas;
        this.water = water;
        this.electricity = electricity;
        this.id = id;
        this.flatId = flatId;
        this.flatNumber = flatNumber;
        this.paid = paid;
    }

    public double getGas() {
        return gas;
    }

    public void setGas(double gas) {
        this.gas = gas;
    }

    public double getWater() {
        return water;
    }

    public void setWater(double water) {
        this.water = water;
    }

    public double getElectricity() {
        return electricity;
    }

    public void setElectricity(double electricity) {
        this.electricity = electricity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public int getFlatId() {
        return flatId;
    }

    public void setFlatId(int flatId) {
        this.flatId = flatId;
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(int flatNumber) {
        this.flatNumber = flatNumber;
    }
}
