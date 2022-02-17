package BanksStuff;

import Banks.Bank;
import Util.BankUtils;

public abstract class Account {
    protected static int GlobalId;
    protected int Money;
    protected int AccountId;
    protected String Type;
    protected int Penalty;
    protected int Procent;

    public int GetLimit()
    {
        Bank bank = BankUtils.FindByAccount(AccountId);
        return bank.Limit;
    }

    public void AddMoney(int amount)
    {
        Money += amount;
    }

    public void TakeMoney(int amount)
    {
        Money -= amount;
    }

    public abstract void MakeTransfer(int recipientAccountId, int amount);

    public void CancelTransfer(int recipientAccountId, int amount)
    {
        Bank bank = BankUtils.FindByAccount(recipientAccountId);
        bank.CancelTransfer(AccountId, recipientAccountId, amount);
    }

    public abstract void FixProfit();
    public abstract void AddDought();

    protected int LowProcent;
    protected int MediumProcent;
    protected int HightProcent;
    protected int LowBorder;
    protected int MediumBorder;
    protected int HighBorder;

    public static int getGlobalId() {
        return GlobalId;
    }

    public static void setGlobalId(int globalId) {
        GlobalId = globalId;
    }

    public int getMoney() {
        return Money;
    }

    public void setMoney(int money) {
        Money = money;
    }

    public int getAccountId() {
        return AccountId;
    }

    public void setAccountId(int accountId) {
        AccountId = accountId;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getPenalty() {
        return Penalty;
    }

    public void setPenalty(int penalty) {
        Penalty = penalty;
    }

    public int getProcent() {
        return Procent;
    }

    public void setProcent(int procent) {
        Procent = procent;
    }

    public int getLowProcent() {
        return LowProcent;
    }

    public void setLowProcent(int lowProcent) {
        LowProcent = lowProcent;
    }

    public int getMediumProcent() {
        return MediumProcent;
    }

    public void setMediumProcent(int mediumProcent) {
        MediumProcent = mediumProcent;
    }

    public int getHightProcent() {
        return HightProcent;
    }

    public void setHightProcent(int hightProcent) {
        HightProcent = hightProcent;
    }

    public int getLowBorder() {
        return LowBorder;
    }

    public void setLowBorder(int lowBorder) {
        LowBorder = lowBorder;
    }

    public int getMediumBorder() {
        return MediumBorder;
    }

    public void setMediumBorder(int mediumBorder) {
        MediumBorder = mediumBorder;
    }

    public int getHighBorder() {
        return HighBorder;
    }

    public void setHighBorder(int highBorder) {
        HighBorder = highBorder;
    }
}
