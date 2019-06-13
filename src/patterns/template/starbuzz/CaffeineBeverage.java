package patterns.template.starbuzz;

public abstract class CaffeineBeverage {

    // 模板方法
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    // 需要由子类提供的方法，必须在超类中声明为抽象
    abstract void brew();

    abstract void addCondiments();

    void boilWater() {
        System.out.println("Boiling water");
    }

    void pourInCup() {
        System.out.println("Pouring into cup");
    }

    // 钩子
    boolean customerWantsCondiments() {
        return true;
    }
}
