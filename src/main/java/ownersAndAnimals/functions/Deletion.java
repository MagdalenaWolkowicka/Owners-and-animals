package ownersAndAnimals.functions;

import ownersAndAnimals.Connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Deletion {

    private Connector connector = new Connector();
    private Scanner scanner = new Scanner(System.in);

    public void deleteOwner() {
        try (Connection connection = DriverManager.getConnection(connector.getUrl(), connector.getUser(), connector.getPassword())) {
            Statement statement = connection.createStatement();
            System.out.println("Numer usuwanego wiersza: ");
            int id = scanner.nextInt();
            String delete = "Delete from owners2 where id = " + id;
            int row2 = statement.executeUpdate(delete);
            if (row2 > 0) {
                System.out.println("Wiersz " + id + " usunięty\n");
            } else {
                System.out.println("Najpierw usuń zwierzęta tego właściciela\n");
            }
        } catch (SQLException e) {
            e.getMessage();
            System.out.println("Błąd bazy danych\n");
        }
    }

    public void deleteAnimal() {
        try (Connection connection = DriverManager.getConnection(connector.getUrl(), connector.getUser(), connector.getPassword())) {
            Statement statement = connection.createStatement();
            System.out.println("Numer usuwanego wiersza: ");
            int id = scanner.nextInt();
            String delete = "Delete from animals where id = " + id;
            int row2 = statement.executeUpdate(delete);
            if (row2 > 0) {
                System.out.println("Wiersz " + id + " usunięty\n");
            } else {
                System.out.println("Błąd usuwania wiersza\n");
            }
        } catch (SQLException e) {
            e.getMessage();
            System.out.println("Błąd bazy danych\n");
        }
    }
}