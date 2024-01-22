package DataClasses;

import java.util.List;

public class Flat {
    //fields:
    public final static String tableName="mieszkania";
    public final static String idField="id";
    public final static String numberField="numer";
    public final static String blockIdField="idBloku";


    public List<Person> personList;
    public List<Bill> billList;
    public int number;
    public int id;
    public int blockId;

    public Flat(List<Person> personList, List<Bill> billList, int number, int id, int blockId) {
        this.personList = personList;
        this.billList = billList;
        this.number = number;
        this.id = id;
        this.blockId = blockId;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public List<Bill> getBillList() {
        return billList;
    }

    public void setBillList(List<Bill> billList) {
        this.billList = billList;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBlockId() {
        return blockId;
    }

    public void setBlockId(int blockId) {
        this.blockId = blockId;
    }
}
