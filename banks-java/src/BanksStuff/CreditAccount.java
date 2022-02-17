package BanksStuff;

import Banks.Bank;
import Util.BankUtils;

public class CreditAccount extends Account{
    public CreditAccount()
    {
        Penalty = 20;
        AccountId = GlobalId + 1;
        GlobalId++;
        Money = 100;
        Type = "credit";
    }

    public void MakeTransfer(int recipientAccountId, int amount)
    {
        if (Money < amount)
        {
            Money -= Penalty;
        }

        Bank bank = BankUtils.FindByAccount(recipientAccountId);
        bank.MoneyTransfer(AccountId, recipientAccountId, amount);
    }

    public void FixProfit()
    {
    }

    public void AddDought()
    {
    }
}
