package banksStuff;

public class PremiumCustomer extends CustomerDecorator{
    public PremiumCustomer(ICustomer customer, String passwordData, String adress) {
        Customer = customer;
        customer.setAddress(adress);
        customer.setPassportData(passwordData);
    }

    @Override
    public void makeTransfer(int accountId, int accountToId, int amount) {
        for(Account account : Customer.getAccounts()) {
            if (account.accountId == accountId) {
                account.makeTransfer(accountToId, amount);
            }
        }
    }
}