package Managers;

import Banks.Bank;

import java.util.ArrayList;
import java.util.List;

public class CentralBank {
    private List<Bank> banks = new ArrayList<Bank>();

    public Bank FindBankByAcccountId(int accountId)
    {
        for(Bank bank : banks)
        {
            if (bank.HasAccount(accountId))
            {
                return bank;
            }
        }

        return null;
    }

    public Bank NewBank()
    {
        var bank = new Bank();
        banks.add(bank);
        return bank;
    }

    public void AddMoney()
    {
        for (Bank bank : banks)
        {
            bank.FixDailySpend();
        }
    }

    public void Charge()
    {
        for(Bank bank : banks)
        {
            bank.GetComission();
        }
    }
}