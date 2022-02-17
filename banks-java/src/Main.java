import UI.CustomManager;
import exceptions.LimitIsExceeded;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CustomManager customManager = new CustomManager();
        String cmd;
        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            cmd = scanner.nextLine();

            if (cmd.equals("view"))
            {
                customManager.GetState();
            }

            if (cmd.equals("reg1"))
            {
                String name = scanner.nextLine();
                String surname = scanner.nextLine();
                customManager.RegisterAccount(name, surname);
            }

            if (cmd.equals("reg2"))
            {
                String name = scanner.nextLine();
                String surname = scanner.nextLine();
                String password = scanner.nextLine();
                String adress = scanner.nextLine();
                customManager.RegisterAccount(name, surname, password, adress);
            }

            if (cmd.equals("improve"))
            {
                String password = scanner.nextLine();
                String adress = scanner.nextLine();
                customManager.Improve(password, adress);
            }

            if (cmd.equals("transfer"))
            {
                String val = scanner.nextLine();
                int senderId = Integer.parseInt(val);
                val = scanner.nextLine();
                int takerId = Integer.parseInt(val);
                val = scanner.nextLine();
                int amount = Integer.parseInt(val);
                try {
                    customManager.Transfer(senderId, takerId, amount);
                } catch (LimitIsExceeded limitIsExceeded) {
                    System.out.println("Limit is exceded");
                }
            }

            if (cmd.equals("acc"))
            {
                String type = scanner.nextLine();
                customManager.MakeAccount(type);
            }
        }
    }
}
