package util;

import banks.Bank;

public class BankUtils {
    public static managers.CentralBank CentralBank;

    public static Bank findByAccount(int accountId) {
        return CentralBank.findBankByAcccountId(accountId);
    }

    public static managers.CentralBank getCentralBank() {
        return CentralBank;
    }

    public static void setCentralBank(managers.CentralBank centralBank) {
        CentralBank = centralBank;
    }
}
