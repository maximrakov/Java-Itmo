package banksStuff;

import exceptions.LimitIsExceeded;

import java.util.List;

public class CustomerDecorator implements ICustomer {
    public ICustomer Customer;

    public CustomerDecorator(ICustomer customer) {
        Customer = customer;
    }

    public CustomerDecorator() {
    }

    public void makeTransfer(int accountId, int accountToId, int amount) throws LimitIsExceeded {
        Customer.makeTransfer(accountId, accountToId, amount);
    }

    public List<Integer> getUserAccounts() {
        return Customer.getUserAccounts();
    }

    public List<Integer> getUserMoney() {
        return Customer.getUserMoney();
    }

    public void addMoreInformation(String address, String passport) {
        Customer.addMoreInformation(address, passport);
    }

    public void addAccount(Account account) {
        Customer.addAccount(account);
    }

    public void cancelTransfer(int accountId, int accountToId, int amount) {
        Customer.cancelTransfer(accountId, accountToId, amount);
    }

    public void addMoney(int accountId, int amount) {
        Customer.addMoney(accountId, amount);
    }

    public void takeMoney(int accountId, int amount) {
        Customer.takeMoney(accountId, amount);
    }

    public boolean hasThisType(String type) {
        return Customer.hasThisType(type);
    }

    public List<Account> getAccounts() {
        return Customer.getAccounts();
    }

    public String getName() {
        return Customer.getName();
    }

    public boolean getNotice() {
        return getNotice();
    }

    public List<String> getMessages() {
        return getMessages();
    }

    public void setPassword(String password) {
        setPassword(password);
    }

    public void setAdress(String adress) {
        setAdress(adress);
    }

    @Override
    public void setNotice(boolean notice) {
        setNotice(notice);
    }

    @Override
    public void setName(String name) {
        setName(name);
    }

    @Override
    public String getSurname() {
        return getSurname();
    }

    @Override
    public void setSurname(String surname) {
        setSurname(surname);
    }

    @Override
    public String getAddress() {
        return getAddress();
    }

    @Override
    public void setAddress(String address) {
        setAdress(address);
    }

    @Override
    public String getPassportData() {
        return getPassportData();
    }

    @Override
    public void setPassportData(String passportData) {
        setPassportData(passportData);
    }

    @Override
    public boolean isNotice() {
        return isNotice();
    }

    @Override
    public void setAccounts(List<Account> accounts) {
        setAccounts(accounts);
    }

    @Override
    public void setMessages(List<String> messages) {
        setMessages(messages);
    }
}