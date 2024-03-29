package core;

import DataClasses.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler {

    public static Connection getDbConnection(){
        String jdbcUrl = "jdbc:oracle:thin:@//"+DbSettings.Host+":"+DbSettings.Port+"/"+DbSettings.dbName;
        String username = DbSettings.username;
        String password = DbSettings.password;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("Błąd ładowania sterownika JDBC Oracle");
            e.printStackTrace();
            return null;
        }

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            return connection;
        } catch (SQLException e) {
            System.err.println("Błąd nawiązywania połączenia z bazą danych");
            e.printStackTrace();
        }
        return null;
    }

    //todo
    // priorytetowo:
    // dodawanie usuwanie modyfikowanie i wyswietlanie pracownikow i mieszkancow - osobno nie ze po kliknieciu w mieszkanie
    // bloki - dodawanie usuwanie modyfikowanie i wyswietlanie
    // mieszkania - dodawanie usuwanie modyfikowanie i wyswietlanie
    // mieszkoncy - tez mozna zrobic dodawanie usuwanie modyfikowanie i wyswietlanie do tego wlasnie mieszkania
    // rachunki - dodawanie usuwanie modyfikowanie i wyswietlanie

    //todo add Person, add Flat, add Block, addRent - moze byc za pomoca procedur bo jest w wymaganiach jakas procedura
    //todo delete ...
    //todo modify ...
    //todo pobieranie wiadomosci o lacznej liczbie ludzi z bloku i sredniej liczbbie wieku ludzi w danym bloku
    // moze tam byc uzyta procedura i joiny zeby znalezc mieszkania z tego bloku i ludzi z tych mieszkan nwm jak to zrobic wsm ale
    // moze to nie takie trudne, GROUP BY pewnie tez sie do tego uzyje

    /*todo
    *  czyli trzeba zrobic cos takiego ze
    *  wysiwtlanie pracownikow - getAllEmployees
    *  wyswietlanie mieszkancow - getAllPerson
    *  wyswietlanie blokow - getAllBlocks - polaczone z tymi funkcjami getAveragePersonAgeFromBlockId i ...personAmount...
    *  wyswietlanie liczby mieszkancow z bloku - getPersonAmountFromBlock - procedura w sql developerze
    *  wyswietlanie sredniej liczby wieku mieszkancow z bloku - getAveragePersonAgeFromBlockId - procedra w sql developerze
    *  po kliknieciu w jakis blok pokazuja sie wszystkie mieszkania z tego bloku - getFlatsByBlockId
    *  po kliknieciu w jakies mieszkanie pokazuja sie wszyscy ludzie ktorzy mieszkaja w danym mieszkaniu - getPersonByFlatId
    *  i pokazuja sie tez wszystkie rachunki ktore sa juz zaplacone albo jeszcze nie - getBillsByFlatId
    *  dodawanie bloku
    *  dodawanie osob
    *  dodawanie mieszkan
    *  dodawanie pracownikow
    *  dodawanie rachunkow
    *  modyfikacja wszystkich rekordow tych tabel - moze byc w tym samym oknie i po prostu jest przycisk stworz lub zmień
    *  usuwanie rekordow tych tabel
    *
    *
    * */

    public  static void addEmployee(String name, String surname, Integer age, String title)
    {
        String query = "insert into "+Employee.tableName+" ("+Employee.nameField+", "+Employee.surnameField+", "+Employee.ageField+", "+Employee.titleField+") values (?, ?, ?, ?)";

        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(query)){
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,surname);
            preparedStatement.setInt(3,age);
            preparedStatement.setString(4,title);

            preparedStatement.executeUpdate();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

    public static void modifyEmployee(Integer id, String name, String surname, Integer age, String title)
    {
        String query = "Update "+ Employee.tableName+" set "+Employee.nameField+" = ?, "+Employee.surnameField+" = ?, "+Employee.ageField+" = ?, "+Employee.titleField+" = ? where id = ?";

        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(query)){
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,surname);
            preparedStatement.setInt(3,age);
            preparedStatement.setString(4,title);
            preparedStatement.setInt(5,id);

            preparedStatement.executeUpdate();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void deleteEmployee(Integer id)
    {
        String query = "delete from "+ Employee.tableName+" where id = ?";

        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(query)){
            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public  static void addPerson( String name, String surname, String sex, Integer age,Integer flatNumber, Integer flatId)
    {
        String query = "insert into "+Person.tableName+" ("+Person.nameField+", "+Person.surnameField+", "+Person.sexField+", "+Person.ageField+", "+Person.flatNumberField+", "+Person.flatIdField+") values (?, ?, ?, ?, ?, ?)";

        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(query)){
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,surname);
            preparedStatement.setString(3,sex);
            preparedStatement.setInt(4,age);
            preparedStatement.setInt(5,flatNumber);
            preparedStatement.setInt(6,flatId);

            preparedStatement.executeUpdate();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void modifyPerson(Integer id, String name, String surname,String sex, Integer age, Integer flatNumber, Integer flatId)
    {
        String query = "Update "+ Person.tableName+" set "+Person.nameField+" = ?, "+Person.surnameField+" = ?, "+Person.sexField+" = ?, "+Person.ageField+" = ?, "+Person.flatNumberField+" = ?, "+Person.flatIdField+" = ?  where id = ?";

        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(query)){
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,surname);
            preparedStatement.setString(3,sex);
            preparedStatement.setInt(4,age);
            preparedStatement.setInt(5,flatNumber);
            preparedStatement.setInt(6,flatId);
            preparedStatement.setInt(7,id);

            preparedStatement.executeUpdate();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void deletePerson(Integer id)
    {
        String query = "delete from "+ Person.tableName+" where id = ?";

        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(query)){
            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public  static void addBlock(Integer flatNumber)
    {
        String query = "insert into "+Block.tableName+" ("+Block.numberField+") values (?)";

        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(query)){
            preparedStatement.setInt(1,flatNumber);

            preparedStatement.executeUpdate();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void modifyBlock(Integer id, Integer flatNumber)
    {
        String query = "Update "+ Block.tableName+" set "+Block.numberField+" = ?  where id = ?";

        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(query)){
            preparedStatement.setInt(1,flatNumber);
            preparedStatement.setInt(2,id);

            preparedStatement.executeUpdate();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void deleteBlock(Integer id)
    {
        String query = "delete from "+ Block.tableName+" where id = ?";

        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(query)){
            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static List<Block> getAllBlocksData()
    {
        String select = "SELECT * FROM "+Block.tableName;
        try {
            PreparedStatement prST = getDbConnection().prepareStatement(select);
            ResultSet resultSet = prST.executeQuery();
            List<Block> list = new ArrayList<>();

            while (resultSet.next()) {
                int blockId = ((ResultSet) resultSet).getInt(Block.idField);
                int number = resultSet.getInt(Block.numberField);
                int occupantsNumber=resultSet.getInt(Block.occupantsNumberField);
                double averageAge=resultSet.getDouble(Block.averageAgeField);

                List<Flat> flatsList=DatabaseHandler.getFlatsByBlockId(blockId);

                Block blc = new Block(blockId,flatsList,number,occupantsNumber,averageAge);
                list.add(blc);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void callBlockStatisticsProcedure()
    {
        try (CallableStatement callableStatement = getDbConnection().prepareCall("{call ObliczStatystykiBloku}")) {
            callableStatement.execute();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }


    public  static void addBill(Integer flatId, Integer flatNumber, Boolean paid, Double water, Double gas, Double electricity)
    {
        String query = "insert into "+Bill.tableName+" ("+Bill.flatIdField+", "+Bill.flatNumberField+", "+Bill.paidField+", "+Bill.waterField+", "+Bill.gasField+", "+Bill.electricityField+") values (?, ?, ?, ?, ?, ?)";

        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(query)){
            preparedStatement.setInt(1,flatId);
            preparedStatement.setInt(2,flatNumber);
            preparedStatement.setBoolean(3,paid);
            preparedStatement.setDouble(4,water);
            preparedStatement.setDouble(5,gas);
            preparedStatement.setDouble(6,electricity);

            preparedStatement.executeUpdate();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void modifyBill(Integer id, Integer flatId, Integer flatNumber, Boolean paid, Double water, Double gas, Double electricity)
    {
        String query = "Update "+ Bill.tableName+" set "+Bill.flatIdField+" = ?, "+Bill.flatNumberField+" = ?, "+Bill.paidField+" = ?, "+Bill.waterField+" = ?, "+Bill.gasField+" = ?, "+Bill.electricityField+" = ?  where id = ?";

        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(query)){
            preparedStatement.setInt(1,flatId);
            preparedStatement.setInt(2,flatNumber);
            preparedStatement.setBoolean(3,paid);
            preparedStatement.setDouble(4,water);
            preparedStatement.setDouble(5,gas);
            preparedStatement.setDouble(6,electricity);
            preparedStatement.setInt(7,id);

            preparedStatement.executeUpdate();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void deleteBill(Integer id)
    {
        String query = "delete from "+ Bill.tableName+" where id = ?";

        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(query)){
            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }


    public static List<Bill> getAllBillData()
    {
        String select = "SELECT * FROM "+Bill.tableName;
        try {
            PreparedStatement prST = getDbConnection().prepareStatement(select);
            ResultSet resultSet = prST.executeQuery();
            List<Bill> list = new ArrayList<>();

            while (resultSet.next()) {
                int billId = ((ResultSet) resultSet).getInt(Bill.idField);
                int flatId = resultSet.getInt(Bill.flatIdField);
                int flatNumber = resultSet.getInt(Bill.flatNumberField);
                boolean paid = resultSet.getBoolean(Bill.paidField);
                Double water = resultSet.getDouble(Bill.waterField);
                Double gas = resultSet.getDouble(Bill.gasField);
                Double electricity = resultSet.getDouble(Bill.electricityField);

                Bill newBill=new Bill(gas,water,electricity,billId,flatId,flatNumber,paid);
                list.add(newBill);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public  static void addFlat(Integer flatNumber, Integer blockId)
    {
        String query = "insert into "+Flat.tableName+" ("+Flat.numberField+", "+Flat.blockIdField+") values (?,?)";

        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(query)){
            preparedStatement.setInt(1,flatNumber);
            preparedStatement.setInt(2,blockId);

            preparedStatement.executeUpdate();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void modifyFlat(Integer id, Integer flatNumber, Integer blockId)
    {
        String query = "Update "+ Flat.tableName+" set "+Flat.numberField+" = ?, "+Flat.blockIdField+" = ? where id = ?";

        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(query)){
            preparedStatement.setInt(1,flatNumber);
            preparedStatement.setInt(2,blockId);
            preparedStatement.setInt(3,id);

            preparedStatement.executeUpdate();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void deleteFlat(Integer id)
    {
        String query = "delete from "+ Flat.tableName+" where id = ?";

        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(query)){
            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }


    public static List<Flat> getAllFlatsData()
    {
        String select = "SELECT * FROM "+Flat.tableName;
        try {
            PreparedStatement prST = getDbConnection().prepareStatement(select);
            ResultSet resultSet = prST.executeQuery();
            List<Flat> list = new ArrayList<>();

            while (resultSet.next()) {
                int flatId = ((ResultSet) resultSet).getInt(Flat.idField);
                int flatNumber = resultSet.getInt(Flat.numberField);
                int blockId = resultSet.getInt(Flat.blockIdField);

                List<Person> persons = new ArrayList<>();
                List<Bill> bills = new ArrayList<>();

                Flat newFlat=new Flat(persons, bills,flatNumber,flatId,blockId);
                list.add(newFlat);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static List<Employee> getAllEmployeesData()
    {
        String select = "SELECT * FROM "+Employee.tableName;
        try {
            PreparedStatement prST = getDbConnection().prepareStatement(select);
            ResultSet resultSet = prST.executeQuery();
            List<Employee> list = new ArrayList<>();

            while (resultSet.next()) {
                int employeeId = ((ResultSet) resultSet).getInt(Employee.idField);
                String name = resultSet.getString(Employee.nameField);
                int age = resultSet.getInt(Employee.ageField);
                String surname = resultSet.getString(Employee.surnameField);
                String title = resultSet.getString(Employee.titleField);

                Employee emp = new Employee(employeeId,name,surname,age,title);
                list.add(emp);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Employee getEmployeeByName(String firstName, String lastName) {
        String select = "SELECT * FROM "+Employee.tableName+" WHERE "+Employee.nameField+" = ? AND "+Employee.surnameField+" = ?";
        try (Connection connection = getDbConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(select)) {

            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int employeeId = resultSet.getInt(Employee.idField);
                    int age = resultSet.getInt(Employee.ageField);
                    String title = resultSet.getString(Employee.titleField);

                    return new Employee(employeeId, firstName, lastName, age, title);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Employee getEmployeeById(int employeeId) {
        String select = "SELECT * FROM "+Employee.tableName+" WHERE "+Employee.idField+" = ?";
        try (Connection connection = getDbConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(select)) {

            preparedStatement.setInt(1, employeeId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String firstName = resultSet.getString(Employee.nameField);
                    String lastName = resultSet.getString(Employee.surnameField);
                    int age = resultSet.getInt(Employee.ageField);
                    String title = resultSet.getString(Employee.titleField);

                    return new Employee(employeeId, firstName, lastName, age, title);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Person> getAllPersonData()
    {
        String select = "SELECT * FROM "+Person.tableName;
        try {
            PreparedStatement prST = getDbConnection().prepareStatement(select);
            ResultSet resultSet = prST.executeQuery();
            List<Person> list = new ArrayList<>();

            while (resultSet.next()) {
                int personId = ((ResultSet) resultSet).getInt(Person.idField);
                String name = resultSet.getString(Person.nameField);
                int age = resultSet.getInt(Person.ageField);
                int flatId=resultSet.getInt(Person.flatIdField);
                int flatNumber=resultSet.getInt(Person.flatNumberField);
                String surname = resultSet.getString(Person.surnameField);
                String sex = resultSet.getString(Person.sexField);

                Person newPerson=new Person(personId, age,name,surname,sex,flatId,flatNumber);
                list.add(newPerson);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Person> getAllPersonFromFlatId(int flatId)
    {
        String select = "SELECT * FROM "+Person.tableName+" WHERE "+Person.flatIdField+" = ?";
        try {
            PreparedStatement prST = getDbConnection().prepareStatement(select);
            prST.setInt(1,flatId);

            ResultSet resultSet = prST.executeQuery();
            List<Person> list = new ArrayList<>();

            while (resultSet.next()) {
                int personId = ((ResultSet) resultSet).getInt(Person.idField);
                String name = resultSet.getString(Person.nameField);
                int age = resultSet.getInt(Person.ageField);
                int flatNumber=resultSet.getInt(Person.flatNumberField);
                String surname = resultSet.getString(Person.surnameField);
                String sex = resultSet.getString(Person.sexField);

                Person newPerson=new Person(personId, age,name,surname,sex,flatId,flatNumber);
                list.add(newPerson);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Flat> getFlatsByBlockId(int blockId)
    {
        String select = "SELECT * FROM "+Flat.tableName+" WHERE "+Flat.blockIdField+" = ?";
        try {
            PreparedStatement prST = getDbConnection().prepareStatement(select);
            prST.setInt(1,blockId);

            ResultSet resultSet = prST.executeQuery();
            List<Flat> list = new ArrayList<>();

            while (resultSet.next()) {
                int flatId = ((ResultSet) resultSet).getInt(Flat.idField);
                int number = resultSet.getInt(Flat.numberField);

                // mieszkancy i rachunki beda wyswietlani dopiero po kliknieciu dlatego sa puste listy bo sa to niepotrzebne pola po prostu
                List <Person> emptyPList=new ArrayList<>();
                List <Bill> emptyBillList=new ArrayList<>();

                Flat newFlat = new Flat(emptyPList,emptyBillList,number,flatId,blockId);
                list.add(newFlat);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
