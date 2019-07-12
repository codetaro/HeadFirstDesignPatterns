package patterns.compound.simduck;

public class QuackableGooseFactory extends AbstractGooseFactory {
    @Override
    public Quackable createQuackableGoose() {
        return new GooseAdapter(new Goose());
    }
}
