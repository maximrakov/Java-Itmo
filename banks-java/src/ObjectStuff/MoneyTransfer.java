package ObjectStuff;

import BanksStuff.Account;

public class MoneyTransfer
{
    private Account SubmitterAccount;
    private Account RecipientAccount;
    private int Amount;
    public MoneyTransfer(Account submitter, Account recipient, int amount)
    {
        SubmitterAccount = submitter;
        RecipientAccount = recipient;
        Amount = amount;
    }

    public Account getSubmitterAccount() {
        return SubmitterAccount;
    }

    public void setSubmitterAccount(Account submitterAccount) {
        SubmitterAccount = submitterAccount;
    }

    public Account getRecipientAccount() {
        return RecipientAccount;
    }

    public void setRecipientAccount(Account recipientAccount) {
        RecipientAccount = recipientAccount;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

}