package banksStuff;

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
    public Customer() {
        Accounts = new ArrayList<Account>();
        Messages = new ArrayList<String>();
        Limit = 500;
    }

    public Customer(String name, String surname, String address, String passwordData) {
        Name = name;
        Surname = surname;
        Address = address;
        PassportData = passwordData;
        Accounts = new ArrayList<>();
        Messages = new ArrayList<String>();
        Notice = false;
        Limit = 500;
    }

    public void makeTransfer(int accountId, int accountToId, int amount) throws LimitIsExceeded {
        if(amount > Limit) {
            throw new LimitIsExceeded("Limit is exceeded");
        }
        for (Account account : Accounts) {
            if (account.accountId == accountId) {
                account.makeTransfer(accountToId, amount);
            }
        }
    }

    public List<Integer> getUserAccounts() {
        var vs = new ArrayList<Integer>();
        for (Account account : Accounts) {
            vs.add(account.accountId);
        }

        return vs;
    }

    public List<Integer> getUserMoney() {
        var vs = new ArrayList<Integer>();
        for (Account account : Accounts) {
            vs.add(account.money);
        }

        return vs;
    }

    public void addMoreInformation(String address, String passport) {
        Address = address;
        PassportData = passport;
    }

    public void addAccount(Account account) {
        Accounts.add(account);
    }

    public void cancelTransfer(int accountId, int accountToId, int amount) {
        for(Account account : Accounts) {
            if (account.accountId == accountId) {
                account.cancelTransfer(accountToId, amount);
            }
        }
    }

    public void addMoney(int accountId, int amount) {
        for(Account account : Accounts) {
            if (account.accountId == accountId) {
                account.addMoney(amount);
            }
        }
    }

    public void takeMoney(int accountId, int amount) {
        for (Account account : Accounts) {
            if (account.accountId == accountId) {
                account.takeMoney(amount);
            }
        }
    }

    @Override
    public boolean hasThisType(String type) {
        return false;
    }

    public List<Account> getAccounts() {
        return Accounts;
    }

    public boolean hasThisType(AccountTypes type) {
        for(Account account : Accounts) {
            if (account.type == type) {
                return true;
            }
        }

        return false;
    }

    public String getName() {
        return Name;
    }

    public boolean getNotice() {
        return Notice;
    }

    public List<String> getMessages() {
        return Messages;
    }

    public void setPassword(String password) {
        PassportData = password;
    }

    public void setAdress(String adress) {
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
