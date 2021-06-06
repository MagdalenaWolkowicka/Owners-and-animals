package ownersAndAnimals;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private String menuOptionsToPrint;

    public Menu() {
        List<String> menuOptions = new ArrayList<>();
        menuOptions.add("--------Menu---------");
        menuOptions.add("1. Zapisz właściciela");
        menuOptions.add("2. Zapisz zwierzę");
        menuOptions.add("3. Pokaż wszystkich właścicieli");
        menuOptions.add("4. Pokaż wszystkie zwierzęta");
        menuOptions.add("5. Edytuj właściciela");
        menuOptions.add("6. Edytuj zwierzę");
        menuOptions.add("7. Usuń właściciela");
        menuOptions.add("8. Usuń zwierzę");
        menuOptions.add("9. Pokaż właścicieli posiadających konkretny gatunek zwierząt");
        menuOptions.add("10. Pokaż właścicieli i zwierzęta z konkretnego miasta");
        menuOptions.add("11. Pokaż właścicieli i średnią wieku ich zwierząt");
        menuOptions.add("0. Wyjdź z programu");
        menuOptionsToPrint = String.join("\n", menuOptions);
    }

    public String getMenuOptionsToPrint() {
        return menuOptionsToPrint;
    }
}
