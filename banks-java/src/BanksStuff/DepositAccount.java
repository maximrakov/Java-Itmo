package BanksStuff;

import Banks.Bank;
import Util.BankUtils;

public class DepositAccount extends Account{
    public DepositAccount()
    {
        LowProcent = 10;
        MediumProcent = 30;
        HightProcent = 50;
        LowBorder = 1000;
        MediumBorder = 5000;
        HighBorder = 10000;
        AccountId = GlobalId + 1;
        Money = 100;
        GlobalId++;
        Earn = 0;
        Penalty = 0;
        Type = "deposit";
    }

    public void FixProfit()
    {
        Money += Earn;
        Earn = 0;
    }

    public void MakeTransfer(int recipientAccountId, int amount)
    {
        Bank bank = BankUtils.FindByAccount(recipientAccountId);
        bank.MoneyTransfer(AccountId, recipientAccountId, amount);
    }

    public void AddDought()
    {
        if (Money <= LowBorder)
        {
            Earn += (Money / 100) * LowProcent;
        }
        else
        {
            if (Money <= MediumBorder)
            {
                Earn += (Money / 100) * MediumProcent;
            }
            else
            {
                if (Money <= HighBorder)
                {
                    Earn += (Money / 100) * HightProcent;
                }
            }
        }
    }

    public int Earn;

    public int getEarn() {
        return Earn;
    }

    public void setEarn(int earn) {
        Earn = earn;
    }
}
