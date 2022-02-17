package BanksStuff;

public class PremiumCustomer extends CustomerDecorator{
    public PremiumCustomer(ICustomer customer, String passwordData, String adress)
    {
        Customer = customer;
        customer.setAddress(adress);
        customer.setPassportData(passwordData);
    }

    @Override
    public void MakeTransfer(int accountId, int accountToId, int amount)
    {
        for(Account account : Customer.getAccounts())
        {
            if (account.AccountId == accountId)
            {
                account.MakeTransfer(accountToId, amount);
            }
        }
    }
}