package patterns.iterator.menu;

public class MenuTestDrive {

    public static void main(String[] args) {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinerMenu dinerMenu = new DinerMenu();

        Waitress alice = new Waitress(pancakeHouseMenu, dinerMenu);

        alice.printMenu();
    }
}
