package ui;

import banks.Bank;
import banksStuff.CustomerCreator;
import banksStuff.ICustomer;
import banksStuff.PremiumCustomer;
import managers.CentralBank;
import util.BankUtils;
import exceptions.LimitIsExceeded;

import java.util.List;

public class CustomManager {
    private CentralBank centralBank;
    private Bank bank;
    private ICustomer customer;
    public CustomManager() {
        centralBank = new CentralBank();
        bank = centralBank.newBank();
        BankUtils.CentralBank = centralBank;
    }

    public void registerAccount(String name, String surname) {
        var customerCreator = new CustomerCreator();
        customer = customerCreator.creator(name, surname);
        bank.addCustomer(customer);
    }

    public void makeAccount(String tp) {
        customer.addAccount(bank.createAccount(tp));
    }

    public void registerAccount(String name, String surname, String passwordData, String adress) {
        var customerCreator = new CustomerCreator();
        customer = customerCreator.creator(name, surname, passwordData, adress);
        bank.addCustomer(customer);
    }

    public void getState() {
        List<Integer> names = customer.getUserAccounts();
        List<Integer> money = customer.getUserMoney();
        for (int i = 0; i < names.size(); i++)
        {
            System.out.println(names.get(i) + " " + money.get(i));
        }
    }

    public List<Integer> getUserMoney() {
        return customer.getUserMoney();
    }

    public void improve(String password, String adress) {
        var customerCreator = new CustomerCreator();
        PremiumCustomer premium = customerCreator.improveAccount(customer, password, adress);
        customer = premium;
    }

    public void put(int amount, int accountId) {
        customer.addMoney(accountId, amount);
    }

    public void take(int amount, int accountId) {
        customer.takeMoney(amount, accountId);
    }

    public void transfer(int sender, int taker, int amount) throws LimitIsExceeded {
        customer.makeTransfer(sender, taker, amount);
    }

    public void cancelTransfer(int senderId, int takerId, int amount) {
        customer.cancelTransfer(senderId, takerId, amount);
    }
}
