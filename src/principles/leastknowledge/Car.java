package principles.leastknowledge;

public class Car {
    // 这是类的一个组件，我们能够调用它的方法
    Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void start(Key key) {
        // 在这里创建了一个新的对象，它的方法可以被调用
        Doors doors = new Doors();

        // 被当作参数传进来的对象，其方法可以被调用
        boolean authorized = key.turns();

        if (authorized) {
            engine.start();  // 可以调用对象组建的方法
            updateDashboardDisplay();  // 可以调用同一个对象内的本地方法
            doors.lock();  // 可以调用你所创建或实例化的对象的方法
        }
    }

    private void updateDashboardDisplay() {
    }
}
