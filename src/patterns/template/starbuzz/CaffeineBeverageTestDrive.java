package patterns.template.starbuzz;

public class CaffeineBeverageTestDrive {

    public static void main(String[] args) {

        Tea teaHook = new Tea();
        Coffee coffeeHook = new Coffee();

        System.out.println("\nMaking tea...");
        teaHook.prepareRecipe();

        System.out.println("\nMaking coffee...");
        coffeeHook.prepareRecipe();
    }
}
