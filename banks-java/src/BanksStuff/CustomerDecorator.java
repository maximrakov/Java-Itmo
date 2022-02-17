package BanksStuff;

import exceptions.LimitIsExceeded;

import java.io.Console;
import java.util.List;

public class CustomerDecorator implements ICustomer {
    public ICustomer Customer;

    public CustomerDecorator(ICustomer customer)
    {
        Customer = customer;
    }

    public CustomerDecorator()
    {
    }

    public void MakeTransfer(int accountId, int accountToId, int amount) throws LimitIsExceeded {
        Customer.MakeTransfer(accountId, accountToId, amount);
    }

    public List<Integer> getUserAccounts()
    {
        return Customer.GetUserAccounts();
    }

    public List<Integer> getUserMoney()
    {
        return Customer.GetUserMoney();
    }

    public void AddMoreInformation(String address, String passport)
    {
        Customer.AddMoreInformation(address, passport);
    }

    public void AddAccount(Account account)
    {
        Customer.AddAccount(account);
    }

    public void CancelTransfer(int accountId, int accountToId, int amount)
    {
        Customer.CancelTransfer(accountId, accountToId, amount);
    }

    public void AddMoney(int accountId, int amount)
    {
        Customer.AddMoney(accountId, amount);
    }

    public void TakeMoney(int accountId, int amount)
    {
        Customer.TakeMoney(accountId, amount);
    }

    public boolean HasThisType(String type)
    {
        return Customer.HasThisType(type);
    }

    public List<Account> getAccounts()
    {
        return Customer.getAccounts();
    }

    public String getName()
    {
        return Customer.getName();
    }

    public boolean getNotice()
    {
        return getNotice();
    }

    public List<String> getMessages()
    {
        return getMessages();
    }

    public void setPassword(String password)
    {
        setPassword(password);
    }

    public void setAdress(String adress)
    {
        setAdress(adress);
    }

    @Override
    public List<Integer> GetUserAccounts() {
        return getUserAccounts();
    }

    @Override
    public List<Integer> GetUserMoney() {
        return getUserMoney();
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