package DataClasses;

public class Person {
    //firlds:
    public final static String tableName="mieszkancy";
    public final static String idField="id";
    public final static String nameField="imie";
    public final static String surnameField="nazwisko";
    public final static String sexField="plec";
    public final static String ageField="wiek";
    public final static String flatIdField="idMieszkania";
    public final static String flatNumberField="numerMieszkania";

    public int id;
    public int age;
    public String name;
    public String surname;
    public String sex;
    public int flatId;
    public int flatNumber;

    public Person(int id, int age, String name, String surname, String sex, int flatId, int flatNumber) {
        this.id=id;
        this.age = age;
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.flatId = flatId;
        this.flatNumber = flatNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
