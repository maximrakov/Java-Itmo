package Banks;

import BanksStuff.*;
import ObjectStuff.MoneyTransfer;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts;
    private List<ICustomer> customers;
    private List<MoneyTransfer> moneyTransfers;
    public int Limit;
    public Bank()
    {
        accounts = new ArrayList<Account>();
        customers = new ArrayList<ICustomer>();
        moneyTransfers = new ArrayList<MoneyTransfer>();
        Limit = 1000;
    }

    public Account CreateAccount(String typeOfAcc)
    {
        Account newAcc = AccountFactory(typeOfAcc).CreateAccount();
        accounts.add(newAcc);
        return newAcc;
    }

    public void ChangeCreditPenalty(int penalty)
    {
        for(Account account : accounts)
        {
            if (account.getType() == "credit")
            {
                account.setPenalty(penalty);
//                account.Penalty = penalty;
            }
        }

        for(ICustomer customer : customers)
        {
            if (customer.HasThisType("credit"))
            {
                customer.setNotice(true);
//                customer.Notice = true;
                customer.getMessages().add("Penalty of your credit card has been changed");
//                customer.Messages.Add("Penalty of your credit card has been changed");
            }
        }
    }

    public void ChangeDebitProcent(int procent)
    {
        for (Account account : accounts)
        {
            if (account.getType() == "debit")
            {
                account.setProcent(procent);
            }
        }

        for(ICustomer customer : customers)
        {
            if (customer.HasThisType("debit"))
            {
                customer.setNotice(true);
                customer.getMessages().add("Procent of your debit card has been changed");
            }
        }
    }

    public void ChangeDepositProcent(int lowProcent, int mediumProcent, int highProcent)
    {
        for(Account account : accounts)
        {
            if (account.getType() == "deposit")
            {
                account.setLowProcent(lowProcent);
                account.setMediumProcent(mediumProcent);
                account.setHightProcent(highProcent);
                account.setProcent(highProcent);
            }
        }

        for (ICustomer customer : customers)
        {
            if (customer.HasThisType("deposit"))
            {
                customer.setNotice(true);
                customer.getMessages().add("Procent of your deposit card has been changed");
//                customer.Messages.Add("Procent of your deposit card has been changed");
            }
        }
    }

    public void MoneyTransfer(int submitterAccountId, int recipientAccountId, int amount)
    {
        Account submitterAccount = null;
        Account recipientAccount = null;
        for (Account account : accounts)
        {
            if (account.getAccountId() == submitterAccountId)
            {
                submitterAccount = account;
            }
        }

        for (Account account : accounts)
        {
            if (account.getAccountId() == recipientAccountId)
            {
                recipientAccount = account;
            }
        }

        submitterAccount.setMoney(submitterAccount.getMoney() - amount);
//        submitterAccount.Money -= amount;
        recipientAccount.setMoney(recipientAccount.getMoney() + amount);
//        recipientAccount.Money += amount;
        moneyTransfers.add(new MoneyTransfer(submitterAccount, recipientAccount, amount));
    }

    public void GetComission()
    {
        for (Account account : accounts)
        {
            account.FixProfit();
        }
    }

    public void FixDailySpend()
    {
        for (Account account : accounts)
        {
            account.AddDought();
        }
    }

    public void AddCustomer(ICustomer customer)
    {
        customers.add(customer);
    }

    public boolean HasAccount(int accountId)
    {
        for (Account account : accounts)
        {
            if (account.getAccountId() == accountId)
            {
                return true;
            }
        }

        return false;
    }

    public void CancelTransfer(int submitterAccountId, int recipientAccountId, int amount)
    {
        for (MoneyTransfer moneyTransfer : moneyTransfers)
        {
            if (moneyTransfer.getSubmitterAccount().getAccountId() == submitterAccountId && moneyTransfer.getRecipientAccount().getAccountId() == recipientAccountId && moneyTransfer.getAmount() == amount)
            {
                moneyTransfer.getSubmitterAccount().setMoney(moneyTransfer.getSubmitterAccount().getMoney() + amount);
                moneyTransfer.getRecipientAccount().setMoney(moneyTransfer.getRecipientAccount().getMoney() - amount);
            }
        }
    }

    public void AddMoneyToAcc(int accountId, int money)
    {
        for (Account account : accounts)
        {
            if (account.getAccountId() == accountId)
            {
                account.setMoney(account.getMoney() + money);
            }
        }
    }

    private IAccountFactory AccountFactory(String typeOfAcc)
    {
        if (typeOfAcc.equals("debit"))
        {
            return new DebitAccountFactory();
        }

        if (typeOfAcc.equals("deposit"))
        {
            return new DepositAccountFactory();
        }

        if (typeOfAcc.equals("credit"))
        {
            return new CreditAccountFactory();
        }

        return null;
    }
}
