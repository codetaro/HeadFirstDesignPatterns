package patterns.compound.simduck;

public class GooseAdapter implements Quackable {  // 适配器会实现目标接口
    Goose goose;

    public GooseAdapter(Goose goose) {  // 构造器需要传入要适配的对象
        this.goose = goose;
    }

    @Override
    public void quack() {
        goose.honk();  // 委托到被适配对象的方法
    }
}
