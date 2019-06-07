package patterns.adapter.turkey;

import patterns.adapter.IteratorEnumeration;

import java.util.ArrayList;
import java.util.List;

public class IteratorEnumerationTestDrive {

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 1; i < 10; i += 2) {
            integerList.add(i);
        }

        IteratorEnumeration iteratorEnumeration = new IteratorEnumeration(integerList.iterator());
        while (iteratorEnumeration.hasMoreElements()) {
            System.out.println((Integer) iteratorEnumeration.nextElement());
        }
    }
}
