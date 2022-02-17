package UI;

import Banks.Bank;
import BanksStuff.CustomerCreator;
import BanksStuff.ICustomer;
import BanksStuff.PremiumCustomer;
import Managers.CentralBank;
import Util.BankUtils;
import exceptions.LimitIsExceeded;

import java.util.List;

public class CustomManager {
    private CentralBank centralBank;
    private Bank bank;
    private ICustomer customer;
    public CustomManager()
    {
        centralBank = new CentralBank();
        bank = centralBank.NewBank();
        BankUtils.CentralBank = centralBank;
    }

    public void RegisterAccount(String name, String surname)
    {
        var customerCreator = new CustomerCreator();
        customer = customerCreator.Creator(name, surname);
        bank.AddCustomer(customer);
    }

    public void MakeAccount(String tp)
    {
        customer.AddAccount(bank.CreateAccount(tp));
    }

    public void RegisterAccount(String name, String surname, String passwordData, String adress)
    {
        var customerCreator = new CustomerCreator();
        customer = customerCreator.Creator(name, surname, passwordData, adress);
        bank.AddCustomer(customer);
    }

    public void GetState()
    {
        List<Integer> names = customer.GetUserAccounts();
        List<Integer> money = customer.GetUserMoney();
        for (int i = 0; i < names.size(); i++)
        {
            System.out.println(names.get(i) + " " + money.get(i));
//            Console.WriteLine(names[i] + " " + money[i]);
        }
    }

    public List<Integer> GetUserMoney() {
        return customer.GetUserMoney();
    }

    public void Improve(String password, String adress)
    {
        var customerCreator = new CustomerCreator();
        PremiumCustomer premium = customerCreator.ImproveAccount(customer, password, adress);
        customer = premium;
    }

    public void Put(int amount, int accountId)
    {
        customer.AddMoney(accountId, amount);
    }

    public void Take(int amount, int accountId)
    {
        customer.TakeMoney(amount, accountId);
    }

    public void Transfer(int sender, int taker, int amount) throws LimitIsExceeded {
        customer.MakeTransfer(sender, taker, amount);
    }

    public void CancelTransfer(int senderId, int takerId, int amount)
    {
        customer.CancelTransfer(senderId, takerId, amount);
    }
}
