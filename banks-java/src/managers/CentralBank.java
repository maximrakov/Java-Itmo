package managers;

import banks.Bank;

import java.util.ArrayList;
import java.util.List;

public class CentralBank {
    private List<Bank> banks = new ArrayList<Bank>();

    public Bank findBankByAcccountId(int accountId) {
        for(Bank bank : banks) {
            if (bank.hasAccount(accountId)) {
                return bank;
            }
        }

        return null;
    }

    public Bank newBank() {
        var bank = new Bank();
        banks.add(bank);
        return bank;
    }

    public void addMoney() {
        for (Bank bank : banks) {
            bank.fixDailySpend();
        }
    }

    public void charge() {
        for(Bank bank : banks) {
            bank.getComission();
        }
    }
}