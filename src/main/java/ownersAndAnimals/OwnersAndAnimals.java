package ownersAndAnimals;

import ownersAndAnimals.functions.Deletion;
import ownersAndAnimals.functions.Edition;
import ownersAndAnimals.functions.Insertion;
import ownersAndAnimals.functions.Selection;

import java.util.Scanner;

public class OwnersAndAnimals {

    boolean exit = false;
    private Menu menu = new Menu();
    private Insertion insertion = new Insertion();
    private Selection selection = new Selection();
    private Edition edition = new Edition();
    private Deletion deletion = new Deletion();

    public void start() {

        System.out.println("----------------------------------");
        System.out.println("| Rejestr godzin podawania leków |");
        System.out.println("----------------------------------");
        while (!exit) {
            System.out.println(menu.getMenuOptionsToPrint());
            actionMenu();
        }
    }

    private void actionMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWybierz opcję:");
        String option = scanner.next();
        switch (option) {
            case "1":
                insertion.insertOwner();
                break;
            case "2":
                insertion.insertAnimal();
                break;
            case "3":
                selection.selectAllOwners();
                break;
            case "4":
                selection.selectAllAnimals();
                break;
            case "5":
                edition.updateOwner();
                break;
            case "6":
                edition.updateAnimal();
                break;
            case "7":
                deletion.deleteOwner();
                break;
            case "8":
                deletion.deleteAnimal();
                break;
            case "9":
                selection.selectOwnersAnimalsType();
                break;
            case "10":
                selection.selectOwnersAnimalsCity();
                break;
            case "11":
                selection.selectOwnersAnimalsAgeAvg();
                break;
            case "0":
                exit = true;
                break;
            default:
                System.out.println("Błędny wybór\n");
        }
    }
}
