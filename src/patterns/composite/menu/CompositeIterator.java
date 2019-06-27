package patterns.composite.menu;

import java.util.Iterator;
import java.util.Stack;

public class CompositeIterator implements Iterator {
    Stack stack = new Stack();

    public CompositeIterator(Iterator iterator) {
        stack.push(iterator);
    }

    @Override
    public Object next() {
        if (hasNext()) {
            Iterator iterator = (Iterator) stack.peek();
            MenuComponent component = (MenuComponent) iterator.next();
            if (component instanceof Menu) {
                // 如果元素是一个菜单，我们有了另一个需要被包含进遍历中的组合，所以我们将它丢进堆栈中
                stack.push(component.createIterator());
            }
            return component;
        } else {
            return null;
        }
    }

    @Override
    public boolean hasNext() {
        if (stack.empty()) {
            // 如果堆栈已经空了，就表示没有下一个元素了
            return false;
        } else {
            // 从堆栈的顶层中取出迭代器，看看是否还有下一个元素
            Iterator iterator = (Iterator) stack.peek();
            if (!iterator.hasNext()) {
                // 如果迭代器没有元素，将它弹出堆栈，然后递归地调用hasNext
                stack.pop();
                return hasNext();
            } else {
                return true;
            }
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
