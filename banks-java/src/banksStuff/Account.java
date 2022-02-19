package banksStuff;

import banks.Bank;
import util.BankUtils;

public abstract class Account {
    protected static int globalId;
    protected int money;
    protected int accountId;
    protected AccountTypes type;
    protected int penalty = 20;
    protected int procent;

    public int getLimit() {
        Bank bank = BankUtils.findByAccount(accountId);
        return bank.limit;
    }

    public void addMoney(int amount) {
        money += amount;
    }

    public void takeMoney(int amount) {
        money -= amount;
    }

    public abstract void makeTransfer(int recipientAccountId, int amount);

    public void cancelTransfer(int recipientAccountId, int amount) {
        Bank bank = BankUtils.findByAccount(recipientAccountId);
        bank.cancelTransfer(accountId, recipientAccountId, amount);
    }

    public abstract void fixProfit();
    public abstract void addDought();

    protected int lowProcent;
    protected int mediumProcent;
    protected int hightProcent;
    protected int lowBorder;
    protected int mediumBorder;
    protected int highBorder;

    public static int getGlobalId() {
        return globalId;
    }

    public static void setGlobalId(int globalId_) {
        globalId = globalId_;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money_) {
        this.money = money_;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId_) {
        this.accountId = accountId_;
    }

    public AccountTypes getType() {
        return type;
    }

    public void setType(AccountTypes type_) {
        this.type = type_;
    }

    public int getPenalty() {
        return penalty;
    }

    public void setPenalty(int penalty_) {
        this.penalty = penalty_;
    }

    public int getProcent() {
        return procent;
    }

    public void setProcent(int procent_) {
        this.procent = procent_;
    }

    public int getLowProcent() {
        return lowProcent;
    }

    public void setLowProcent(int lowProcent_) {
        this.lowProcent = lowProcent_;
    }

    public int getMediumProcent() {
        return mediumProcent;
    }

    public void setMediumProcent(int mediumProcent_) {
        this.mediumProcent = mediumProcent_;
    }

    public int getHightProcent() {
        return hightProcent;
    }

    public void setHightProcent(int hightProcent_) {
        this.hightProcent = hightProcent_;
    }

    public int getLowBorder() {
        return lowBorder;
    }

    public void setLowBorder(int lowBorder_) {
        this.lowBorder = lowBorder_;
    }

    public int getMediumBorder() {
        return mediumBorder;
    }

    public void setMediumBorder(int mediumBorder_) {
        this.mediumBorder = mediumBorder_;
    }

    public int getHighBorder() {
        return highBorder;
    }

    public void setHighBorder(int highBorder_) {
        this.highBorder = highBorder_;
    }
}
