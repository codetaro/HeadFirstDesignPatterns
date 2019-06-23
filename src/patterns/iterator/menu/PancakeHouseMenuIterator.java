package patterns.iterator.menu;

import java.util.ArrayList;
import java.util.Iterator;

public class PancakeHouseMenuIterator implements Iterator {
    Iterator iterator;

    public PancakeHouseMenuIterator(ArrayList menuItems) {
        this.iterator = menuItems.iterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Object next() {
        return iterator.next();
    }
}
