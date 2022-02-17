package BanksStuff;

import Banks.Bank;
import Util.BankUtils;

public class DebitAccount extends Account{
    public DebitAccount()
    {
        Procent = 10;
        AccountId = GlobalId + 1;
        GlobalId++;
        Money = 100;
        Consumption = 0;
        Penalty = 0;
        Type = "debit";
    }

    public int CurrentSuppl;
    public int Consumption;

    public void MakeTransfer(int recipientAccountId, int amount)
    {
        Bank bank = BankUtils.FindByAccount(recipientAccountId);
        bank.MoneyTransfer(AccountId, recipientAccountId, amount);
    }

    public void FixProfit()
    {
        Money += Consumption;
        Consumption = 0;
    }

    public void AddDought()
    {
        Consumption += (Money / 100) * Procent;
    }

    public int getCurrentSuppl() {
        return CurrentSuppl;
    }

    public void setCurrentSuppl(int currentSuppl) {
        CurrentSuppl = currentSuppl;
    }

    public int getConsumption() {
        return Consumption;
    }

    public void setConsumption(int consumption) {
        Consumption = consumption;
    }
}
