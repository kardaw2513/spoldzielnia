package DataClasses;

public class Employee {
    //todo
    //fields names:
    public final static String tableName="pracownicy";
    public final static String nameField="imie";
    public final static String surnameField="nazwisko";
    public final static String ageField="wiek";
    public final static String titleField="stanowisko";
    public final static String idField="id";

    public int id;
    public String name;
    public String surname;
    public int age;
    public String title;


    public Employee(int id, String name, String surname, int age, String title) {
        this.id=id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.title = title;
    }

    public String getNameField() {
        return nameField;
    }

    public String getSurnameField() {
        return surnameField;
    }

    public String getAgeField() {
        return ageField;
    }

    public String getTitleField() {
        return titleField;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIdField() {
        return idField;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
