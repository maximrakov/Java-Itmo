package Util;

import Banks.Bank;
import Managers.CentralBank;

public class BankUtils {
    public static Managers.CentralBank CentralBank;

    public static Bank FindByAccount(int accountId)
    {
        return CentralBank.FindBankByAcccountId(accountId);
    }

    public static Managers.CentralBank getCentralBank() {
        return CentralBank;
    }

    public static void setCentralBank(Managers.CentralBank centralBank) {
        CentralBank = centralBank;
    }
}
