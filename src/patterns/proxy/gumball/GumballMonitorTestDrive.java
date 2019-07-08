package patterns.proxy.gumball;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class GumballMonitorTestDrive {

    public static void main(String[] args) {
        // 192.168.2.137
        String[] location = {
                "rmi://localhost/santafe",
                "rmi://localhost/boulder",
                "rmi://localhost/seattle"};

        GumballMonitor[] monitor = new GumballMonitor[location.length];

        for (int i = 0; i < location.length; i++) {
            try {
                // 返回一个远程糖果机的代理
                GumballMachineRemote machine = (GumballMachineRemote) Naming.lookup(location[i]);
                monitor[i] = new GumballMonitor(machine);
                System.out.println(monitor[i]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < monitor.length; i++) {
            if (monitor[i] != null) monitor[i].report();
        }
    }
}
