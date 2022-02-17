package BanksStuff;

public class CustomerCreator {
    public CommonCustomerBuilder CommonCustomerBuilder;
    public CustomerDirector CustomerDirector;

    public ICustomer Creator(String name, String surname)
    {
        CommonCustomerBuilder = new CommonCustomerBuilder(new Customer());
        CustomerDirector = new CustomerDirector();
        CustomerDirector.CustomerBuilder = CommonCustomerBuilder;
        return CustomerDirector.BuildCustomer(name, surname);
    }

    public ICustomer Creator(String name, String surname, String passwordData, String adress)
    {
        CommonCustomerBuilder = new CommonCustomerBuilder(new Customer());
        CustomerDirector = new CustomerDirector();
        CustomerDirector.CustomerBuilder = CommonCustomerBuilder;
        return CustomerDirector.BuildCustomer(name, surname, passwordData, adress);
    }

    public PremiumCustomer ImproveAccount(ICustomer customer, String passwordData, String adress)
    {
        PremiumCustomer premium = new PremiumCustomer(customer, passwordData, adress);
        return premium;
    }
}
