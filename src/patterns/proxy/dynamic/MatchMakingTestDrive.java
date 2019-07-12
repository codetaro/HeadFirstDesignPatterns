package patterns.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;

public class MatchMakingTestDrive {
    HashMap<String, PersonBean> datingDB = new HashMap<>();

    public MatchMakingTestDrive() {
        initializeDatabase();
    }

    private void initializeDatabase() {
        PersonBean joe = new PersonBeanImpl();
        joe.setName("Joe Javabean");
        joe.setInterests("cars, computers, music");
        joe.setHotOrNotRating(7);
        datingDB.put(joe.getName(), joe);

        PersonBean kelly = new PersonBeanImpl();
        kelly.setName("Kelly Klosure");
        kelly.setInterests("ebay, movies, music");
        kelly.setHotOrNotRating(6);
        datingDB.put(kelly.getName(), kelly);
    }

    public static void main(String[] args) {
        MatchMakingTestDrive test = new MatchMakingTestDrive();
        test.drive();
    }

    private void drive() {
        PersonBean joe = getPersonFromDatabase("Joe Javabean");
        PersonBean proxy = getProxy(new OwnerInvocationHandler(), joe);
        System.out.println("\nName is " + proxy.getName());
        proxy.setInterests("bowling, Go");
        System.out.println("Interests set from owner proxy");
        try {
            proxy.setHotOrNotRating(10);
        } catch (Exception e) {
            System.out.println("Can't set rating from owner proxy");
        }
        System.out.println("Rating is " + proxy.getHotOrNotRating());

        proxy = getProxy(new NonOwnerInvocationHandler(), joe);
        System.out.println("\nName is " + proxy.getName());
        try {
            proxy.setInterests("bowling, Go");
        } catch (Exception e) {
            System.out.println("Can't set interests from non owner proxy");
        }
        proxy.setHotOrNotRating(3);
        System.out.println("Rating set from non owner proxy");
        System.out.println("Rating is " + proxy.getHotOrNotRating());
    }

    private PersonBean getPersonFromDatabase(String name) {
        return datingDB.get(name);
    }

    // 为PersonBean对象创建拥有者代理
    PersonBean getOwnerProxy(PersonBean person) {
        return (PersonBean) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new OwnerInvocationHandler(person));
    }

    // 为PersonBean对象创建非拥有者代理
    PersonBean getNonOwnerProxy(PersonBean person) {
        return (PersonBean) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new NonOwnerInvocationHandler(person));
    }

    PersonBean getProxy(InvocationHandler handler, PersonBean personBean) {
        if (handler instanceof OwnerInvocationHandler) {
            return getOwnerProxy(personBean);
        } else {
            return getNonOwnerProxy(personBean);
        }
    }
}
