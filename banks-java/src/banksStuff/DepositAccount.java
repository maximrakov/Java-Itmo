package banksStuff;

import banks.Bank;
import util.BankUtils;

import static banksStuff.AccountTypes.deposit;

public class DepositAccount extends Account{
    public DepositAccount() {
        lowProcent = 10;
        mediumProcent = 30;
        hightProcent = 50;
        lowBorder = 1000;
        mediumBorder = 5000;
        highBorder = 10000;
        accountId = globalId + 1;
        money = 100;
        globalId++;
        Earn = 0;
        penalty = 0;
        type = deposit;
    }

    public void fixProfit() {
        money += Earn;
        Earn = 0;
    }

    public void makeTransfer(int recipientAccountId, int amount) {
        Bank bank = BankUtils.findByAccount(recipientAccountId);
        bank.moneyTransfer(accountId, recipientAccountId, amount);
    }

    public void addDought() {
        if (money <= lowBorder) {
            Earn += (money / 100) * lowProcent;
        }
        else {
            if (money <= mediumBorder) {
                Earn += (money / 100) * mediumProcent;
            }
            else {
                if (money <= highBorder) {
                    Earn += (money / 100) * hightProcent;
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
