import ui.CustomManager;
import exceptions.LimitIsExceeded;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CustomManager customManager = new CustomManager();
        String cmd;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            cmd = scanner.nextLine();

            if (cmd.toLowerCase(Locale.ROOT).equals("view")) {
                customManager.getState();
            }

            if (cmd.toLowerCase(Locale.ROOT).equals("reg1")) {
                String name = scanner.nextLine();
                String surname = scanner.nextLine();
                customManager.registerAccount(name, surname);
            }

            if (cmd.toLowerCase(Locale.ROOT).equals("reg2")) {
                String name = scanner.nextLine();
                String surname = scanner.nextLine();
                String password = scanner.nextLine();
                String adress = scanner.nextLine();
                customManager.registerAccount(name, surname, password, adress);
            }

            if (cmd.toLowerCase(Locale.ROOT).equals("improve")) {
                String password = scanner.nextLine();
                String adress = scanner.nextLine();
                customManager.improve(password, adress);
            }

            if (cmd.toLowerCase(Locale.ROOT).equals("transfer")) {
                String sender = scanner.nextLine();
                int senderId = Integer.parseInt(sender);
                sender = scanner.nextLine();
                int takerId = Integer.parseInt(sender);
                sender = scanner.nextLine();
                int amount = Integer.parseInt(sender);
                try {
                    customManager.transfer(senderId, takerId, amount);
                } catch (LimitIsExceeded limitIsExceeded) {
                    System.out.println("Limit is exceded");
                }
            }

            if (cmd.toLowerCase(Locale.ROOT).equals("acc")) {
                String type = scanner.nextLine();
                customManager.makeAccount(type);
            }
        }
    }
}