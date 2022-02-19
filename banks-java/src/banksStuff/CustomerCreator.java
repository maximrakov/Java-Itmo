package banksStuff;

public class CustomerCreator {
    public CommonCustomerBuilder CommonCustomerBuilder;
    public CustomerDirector CustomerDirector;

    public ICustomer creator(String name, String surname) {
        CommonCustomerBuilder = new CommonCustomerBuilder(new Customer());
        CustomerDirector = new CustomerDirector();
        CustomerDirector.CustomerBuilder = CommonCustomerBuilder;
        return CustomerDirector.buildCustomer(name, surname);
    }

    public ICustomer creator(String name, String surname, String passwordData, String adress) {
        CommonCustomerBuilder = new CommonCustomerBuilder(new Customer());
        CustomerDirector = new CustomerDirector();
        CustomerDirector.CustomerBuilder = CommonCustomerBuilder;
        return CustomerDirector.buildCustomer(name, surname, passwordData, adress);
    }

    public PremiumCustomer improveAccount(ICustomer customer, String passwordData, String adress) {
        PremiumCustomer premium = new PremiumCustomer(customer, passwordData, adress);
        return premium;
    }
}
