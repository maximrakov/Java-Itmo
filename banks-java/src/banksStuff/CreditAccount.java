package banksStuff;

import banks.Bank;
import util.BankUtils;

import static banksStuff.AccountTypes.credit;

public class CreditAccount extends Account{
    public CreditAccount() {
        penalty = 20;
        accountId = globalId + 1;
        globalId++;
        money = 100;
        type = credit;
    }

    public void makeTransfer(int recipientAccountId, int amount) {
        if (money < amount) {
            money -= penalty;
        }

        Bank bank = BankUtils.findByAccount(recipientAccountId);
        bank.moneyTransfer(accountId, recipientAccountId, amount);
    }

    public void fixProfit() {
    }

    public void addDought() {
    }
}
