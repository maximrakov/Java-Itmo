package banksStuff;

import banks.Bank;
import util.BankUtils;

import static banksStuff.AccountTypes.debit;

public class DebitAccount extends Account{
    public DebitAccount() {
        procent = 10;
        accountId = globalId + 1;
        globalId++;
        money = 100;
        Consumption = 0;
        penalty = 0;
        type = debit;
    }

    public int CurrentSuppl;
    public int Consumption;

    public void makeTransfer(int recipientAccountId, int amount) {
        Bank bank = BankUtils.findByAccount(recipientAccountId);
        bank.moneyTransfer(accountId, recipientAccountId, amount);
    }

    public void fixProfit() {
        money += Consumption;
        Consumption = 0;
    }

    public void addDought() {
        Consumption += (money / 100) * procent;
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
