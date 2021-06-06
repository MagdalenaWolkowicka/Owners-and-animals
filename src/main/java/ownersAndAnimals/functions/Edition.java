package ownersAndAnimals.functions;

import ownersAndAnimals.Connector;

import java.sql.*;
import java.util.Scanner;

public class Edition {

    private Connector connector = new Connector();
    private Scanner scanner = new Scanner(System.in);
    private int id;

    public void updateOwner() {
        try (Connection connection = DriverManager.getConnection(connector.getUrl(), connector.getUser(), connector.getPassword())) {
            System.out.println("Edycja: ");
            Statement statement = connection.createStatement();
            System.out.println("Id: ");
            id = scanner.nextInt();
            System.out.println("Imie: ");
            String name = scanner.next();
            System.out.println("Nazwisko: ");
            String surname = scanner.next();
            System.out.println("Miasto: ");
            String city = scanner.next();
            System.out.println("Wiek: ");
            int age = scanner.nextInt();
            String update = "Update owners2 SET name = '" + name + "', surname = '" + surname + "', city = '" + city + "', age = " + age + " where id = " + id;
            int row = statement.executeUpdate(update);
            if (row > 0) {
                System.out.println("Edytowano pozycję " + id);
                selectUpdatedRowOwner();
            }
        } catch (SQLException e) {
            e.getMessage();
            System.out.println("Błąd bazy danych\n");
        } catch (NullPointerException e) {
            e.getMessage();
        }
    }

    public void updateAnimal() {
        try (Connection connection = DriverManager.getConnection(connector.getUrl(), connector.getUser(), connector.getPassword())){
            System.out.println("Edycja: ");
            Statement statement = connection.createStatement();
            System.out.println("Id: ");
            id = scanner.nextInt();
            System.out.println("Imie: ");
            String name = scanner.next();
            System.out.println("Wiek: ");
            int age = scanner.nextInt();
            String update = "UPDATE animals SET name = '" + name + "', age = " + age + " where id = " + id;
            int row = statement.executeUpdate(update);
            if (row > 0) {
                System.out.println("Edytowano pozycję " + id);
                selectUpdatedRowAnimal();
            }
        } catch (SQLException e) {
            e.getMessage();
            System.out.println("Błąd bazy danych\n");
        }
    }

    private void selectUpdatedRowOwner() {
        try (java.sql.Connection connection = DriverManager.getConnection(connector.getUrl(), connector.getUser(), connector.getPassword())) {
            String select = "Select * from owners2 where id = " + id;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + ". Imię --> " +
                        resultSet.getString(2) + " , Nazwisko --> " +
                        resultSet.getString(3) + " , Miasto --> " +
                        resultSet.getString(4) + " , Wiek --> " +
                        resultSet.getInt(5) + "\n");
            }
        } catch (SQLFeatureNotSupportedException e) {
            e.getMessage();
            System.out.println("Błąd bazy danych\n");
        } catch (SQLException e) {
            e.getMessage();
            System.out.println("Błąd bazy danych\n");
        }
    }

    private void selectUpdatedRowAnimal() {
        try (java.sql.Connection connection = DriverManager.getConnection(connector.getUrl(), connector.getUser(), connector.getPassword())) {
            String select = "Select * from animals where id = " + id;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + ". Imię --> " +
                        resultSet.getString(4) + " , Wiek --> " +
                        resultSet.getInt(5));
            }
        } catch (SQLFeatureNotSupportedException e) {
            e.getMessage();
            System.out.println("Błąd bazy danych\n");
        } catch (SQLException e) {
            e.getMessage();
            System.out.println("Błąd bazy danych\n");
        }
        System.out.println("");
    }
}
