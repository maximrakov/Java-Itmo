package BanksStuff;

import exceptions.LimitIsExceeded;

import java.util.ArrayList;
import java.util.List;

public class Customer implements ICustomer {
    private String Name;
    private String Surname;
    private String Address;
    private String PassportData;
    private boolean Notice;
    private List<Account> Accounts;
    private List<String> Messages;
    private int Limit;
    public Customer()
    {
        Accounts = new ArrayList<Account>();
        Messages = new ArrayList<String>();
        Limit = 500;
    }

    public Customer(String name, String surname, String address, String passwordData)
    {
        Name = name;
        Surname = surname;
        Address = address;
        PassportData = passwordData;
        Accounts = new ArrayList<>();
        Messages = new ArrayList<String>();
        Notice = false;
        Limit = 500;
    }

    public void MakeTransfer(int accountId, int accountToId, int amount) throws LimitIsExceeded {
        if(amount > Limit){
            throw new LimitIsExceeded("Limit is exceeded");
        }
        for (Account account : Accounts)
        {
            if (account.AccountId == accountId)
            {
                account.MakeTransfer(accountToId, amount);
            }
        }
    }

    public List<Integer> GetUserAccounts()
    {
        var vs = new ArrayList<Integer>();
        for (Account account : Accounts)
        {
            vs.add(account.AccountId);
        }

        return vs;
    }

    public List<Integer> GetUserMoney()
    {
        var vs = new ArrayList<Integer>();
        for (Account account : Accounts)
        {
            vs.add(account.Money);
        }

        return vs;
    }

    public void AddMoreInformation(String address, String passport)
    {
        Address = address;
        PassportData = passport;
    }

    public void AddAccount(Account account)
    {
        Accounts.add(account);
    }

    public void CancelTransfer(int accountId, int accountToId, int amount)
    {
        for(Account account : Accounts)
        {
            if (account.AccountId == accountId)
            {
                account.CancelTransfer(accountToId, amount);
            }
        }
    }

    public void AddMoney(int accountId, int amount)
    {
        for(Account account : Accounts)
        {
            if (account.AccountId == accountId)
            {
                account.AddMoney(amount);
            }
        }
    }

    public void TakeMoney(int accountId, int amount)
    {
        for (Account account : Accounts)
        {
            if (account.AccountId == accountId)
            {
                account.TakeMoney(amount);
            }
        }
    }

    public List<Account> getAccounts()
    {
        return Accounts;
    }

    public boolean HasThisType(String type)
    {
        for(Account account : Accounts)
        {
            if (account.Type == type)
            {
                return true;
            }
        }

        return false;
    }

    public String getName()
    {
        return Name;
    }

    public boolean getNotice()
    {
        return Notice;
    }

    public List<String> getMessages()
    {
        return Messages;
    }

    public void setPassword(String password)
    {
        PassportData = password;
    }

    public void setAdress(String adress)
    {
        Address = adress;
    }

    public boolean setNotice() {
        return Notice;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPassportData() {
        return PassportData;
    }

    public void setPassportData(String passportData) {
        PassportData = passportData;
    }

    public boolean isNotice() {
        return Notice;
    }

    public void setNotice(boolean notice) {
        Notice = notice;
    }

    public void setAccounts(List<Account> accounts) {
        Accounts = accounts;
    }

    public void setMessages(List<String> messages) {
        Messages = messages;
    }

    public int getLimit() {
        return Limit;
    }

    public void setLimit(int limit) {
        Limit = limit;
    }
}
