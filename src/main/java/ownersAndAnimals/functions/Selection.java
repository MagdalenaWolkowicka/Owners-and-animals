package ownersAndAnimals.functions;

import ownersAndAnimals.Connector;

import java.sql.*;
import java.util.Scanner;

public class Selection {

    private int id;
    private Connector connector = new Connector();
    private Statement statement = null;

    public void selectAllOwners() {
        try (Connection connection = DriverManager.getConnection(connector.getUrl(), connector.getUser(), connector.getPassword())) {
            statement = connection.createStatement();
            String select = "Select * from owners2 order by id asc";
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String surname = resultSet.getString(3);
                String city = resultSet.getString(4);
                int age = resultSet.getInt(5);
                System.out.println(id + ". " + name + ", " + surname + ", " + city + ", " + age);
            }
            if (!resultSet.isAfterLast()) {
                System.out.println("Brak danych do wyświetlenia\n");
            }
            System.out.println("");
        } catch (SQLException e) {
            e.getMessage();
            System.out.println("Błąd bazy danych\n");
        }
        System.out.println("");
    }

    public void selectAllAnimals() {
        try (Connection connection = DriverManager.getConnection(connector.getUrl(), connector.getUser(), connector.getPassword())) {
            statement = connection.createStatement();
            String select = "Select * from animals order by id asc";
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                id = resultSet.getInt(1);
                int ownerId = resultSet.getInt(2);
                String type = resultSet.getString(3);
                String name = resultSet.getString(4);
                int age = resultSet.getInt(5);
                System.out.println(id + ". " + ownerId + ", " + type + ", " + name + ", " + age);
            }
            if (!resultSet.isAfterLast()) {
                System.out.println("Brak danych do wyświetlenia\n");
            }
            System.out.println("");
        } catch (SQLException e) {
            e.getMessage();
            System.out.println("Błąd bazy danych\n");
        }
        System.out.println("");
    }

    public void selectOwnersAnimalsType() {
        try (java.sql.Connection connection = DriverManager.getConnection(connector.getUrl(), connector.getUser(), connector.getPassword())) {
            System.out.println("Gatunek zwierzęcia: ");
            Scanner scanner = new Scanner(System.in);
            String type = scanner.next();
            String select = "Select o.id, o.name, a.type, a.name from  animals a, owners2 o where o.id = a.owner_id and a.type = '" + type + "'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + ". Imie właściciela --> " +
                        resultSet.getString(2) + ", Gatunek --> " +
                        resultSet.getString(3) + ", Imię zwierzaka --> " +
                        resultSet.getString(4));
            }
            if (!resultSet.isAfterLast()) {
                System.out.println("Brak danych do wyswietnienia\n");
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

    public void selectOwnersAnimalsCity() {
        try (java.sql.Connection connection = DriverManager.getConnection(connector.getUrl(), connector.getUser(), connector.getPassword())) {
            System.out.println("Miasto: ");
            Scanner scanner = new Scanner(System.in);
            String city = scanner.next();
            String select = "select o.id, o.name, o.surname, o.city, a.type, a.name from owners2 o, animals a where o.id = a.owner_id and o.city = '" + city + "'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + ". Imie --> " +
                        resultSet.getString(2) + ", Nazwisko --> " +
                        resultSet.getString(3) + ", Miasto --> " +
                        resultSet.getString(4) + ", Gatunek --> " +
                        resultSet.getString(5) + ", Imię zwierzaka --> " +
                        resultSet.getString(6));
            }
            if (!resultSet.isAfterLast()) {
                System.out.println("Brak danych do wyświetlenia\n");
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

    public void selectOwnersAnimalsAgeAvg() {
        try (java.sql.Connection connection = DriverManager.getConnection(connector.getUrl(), connector.getUser(), connector.getPassword())) {
            String select = "select o.name, avg(a.age) from owners2 o, animals a where o.id = a.owner_id group by o.name";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                System.out.println("Imię właściciela --> " + resultSet.getString(1) +
                        ", Średnia wieku zwierząt --> " + resultSet.getString(2));
            }
            if (!resultSet.isAfterLast()) {
                System.out.println("Brak danych do wyświetlenia\n");
            }
            System.out.println("");
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