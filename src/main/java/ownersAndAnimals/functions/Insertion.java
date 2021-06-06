package ownersAndAnimals.functions;

import ownersAndAnimals.Connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Insertion {

    private Connector connector = new Connector();

    public void insertOwner() {
        try (Connection connection = DriverManager.getConnection(connector.getUrl(), connector.getUser(), connector.getPassword())){
            System.out.println("Imię: ");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.next();
            System.out.println("Nazwisko: ");
            String surname = scanner.next();
            System.out.println("Miasto: ");
            String city = scanner.next();
            System.out.println("Wiek: ");
            int age = scanner.nextInt();
            String insert = "Insert into owners2 (name, surname, city, age)" + "values ('" + name + "','" + surname +"','" + city + "'," + age + ")";
            Statement statement = connection.createStatement();
            int row =  statement.executeUpdate(insert);
            if (row > 0) {
                System.out.println("Dodano pomyślnie\n");
            } else {
                System.out.println("Błąd dodawania właściciela\n");
            }
        } catch (SQLException e) {
            e.getMessage();
            System.out.println("Błąd bazy danych\n");
        }
    }

    public void insertAnimal() {
        try (Connection connection = DriverManager.getConnection(connector.getUrl(), connector.getUser(), connector.getPassword())){
            System.out.println("Numer właściciela: ");
            Scanner scanner = new Scanner(System.in);
            int ownerNumber = scanner.nextInt();
            System.out.println("Gatunek: ");
            String type = scanner.next();
            System.out.println("Imię: ");
            String name = scanner.next();
            System.out.println("Wiek: ");
            int age = scanner.nextInt();
            String insert = "Insert into animals (owner_id, type, name, age)" + "values (" + ownerNumber + ",'" + type + "','" + name + "'," + age + ")";
            Statement statement = connection.createStatement();
            int row =  statement.executeUpdate(insert);
            if (row > 0) {
                System.out.println("Dodano pomyslnie\n");
            } else {
                System.out.println("Błąd dodawania zwierzęcia\n");
            }
        } catch (SQLException e) {
            e.getMessage();
            System.out.println("Błąd bazy danych\n");
        }
    }


}
