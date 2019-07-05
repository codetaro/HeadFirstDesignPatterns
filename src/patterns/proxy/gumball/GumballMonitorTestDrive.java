package patterns.proxy.gumball;

import java.rmi.RemoteException;

public class GumballMonitorTestDrive {

    public static void main(String[] args) {
        int count = 0;

        if (args.length < 2) {
            System.out.println("GumballMachine <name> <inventory>");
            System.exit(1);
        }

        GumballMachine gumballMachine = null;
        try {
            count = Integer.parseInt(args[1]);
            gumballMachine = new GumballMachine(args[0], count);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        GumballMonitor monitor = new GumballMonitor(gumballMachine);

        // 其他的测试代码

        monitor.report();
    }
}
