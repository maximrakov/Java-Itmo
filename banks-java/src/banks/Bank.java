package banks;

import banksStuff.*;
import objectStuff.MoneyTransfer;

import java.util.ArrayList;
import java.util.List;

import static banksStuff.AccountTypes.*;

public class Bank {
    private final List<Account> accounts;
    private final List<ICustomer> customers;
    private final List<MoneyTransfer> moneyTransfers;

    public int limit;
    public Bank()
    {
        accounts = new ArrayList<Account>();
        customers = new ArrayList<ICustomer>();
        moneyTransfers = new ArrayList<MoneyTransfer>();
        limit = 1000;
    }

    public Account createAccount(String typeOfAcc)
    {
        Account newAcc = accountFactory(typeOfAcc).createAccount();
        accounts.add(newAcc);
        return newAcc;
    }

    public void changeCreditPenalty(int penalty)
    {
        for(Account account : accounts)
        {
            if (account.getType() == credit)
            {
                account.setPenalty(penalty);
//                account.Penalty = penalty;
            }
        }

        for(ICustomer customer : customers)
        {
            if (customer.hasThisType("credit"))
            {
                customer.setNotice(true);
//                customer.Notice = true;
                customer.getMessages().add("Penalty of your credit card has been changed");
//                customer.Messages.Add("Penalty of your credit card has been changed");
            }
        }
    }

    public void changeDebitProcent(int procent)
    {
        for (Account account : accounts)
        {
            if (account.getType() == debit)
            {
                account.setProcent(procent);
            }
        }

        for(ICustomer customer : customers)
        {
            if (customer.hasThisType("debit"))
            {
                customer.setNotice(true);
                customer.getMessages().add("Procent of your debit card has been changed");
            }
        }
    }

    public void changeDepositProcent(int lowProcent, int mediumProcent, int highProcent)
    {
        for(Account account : accounts)
        {
            if (account.getType() == deposit)
            {
                account.setLowProcent(lowProcent);
                account.setMediumProcent(mediumProcent);
                account.setHightProcent(highProcent);
                account.setProcent(highProcent);
            }
        }

        for (ICustomer customer : customers)
        {
            if (customer.hasThisType("deposit"))
            {
                customer.setNotice(true);
                customer.getMessages().add("Procent of your deposit card has been changed");
//                customer.Messages.Add("Procent of your deposit card has been changed");
            }
        }
    }

    public void moneyTransfer(int submitterAccountId, int recipientAccountId, int amount)
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

    public void getComission()
    {
        for (Account account : accounts)
        {
            account.fixProfit();
        }
    }

    public void fixDailySpend()
    {
        for (Account account : accounts)
        {
            account.addDought();
        }
    }

    public void addCustomer(ICustomer customer)
    {
        customers.add(customer);
    }

    public boolean hasAccount(int accountId)
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

    public void cancelTransfer(int submitterAccountId, int recipientAccountId, int amount)
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

    public void addMoneyToAcc(int accountId, int money)
    {
        for (Account account : accounts)
        {
            if (account.getAccountId() == accountId)
            {
                account.setMoney(account.getMoney() + money);
            }
        }
    }

    private IAccountFactory accountFactory(String typeOfAcc)
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
