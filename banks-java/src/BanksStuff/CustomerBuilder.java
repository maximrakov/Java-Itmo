package BanksStuff;

public abstract class CustomerBuilder {
    protected Customer Customer;

    public CustomerBuilder(Customer customer)
    {
        Customer = customer;
    }

    public CustomerBuilder()
    {
    }

    public abstract void BuildName(String name);
    public abstract void BuildSurname(String surname);
    public abstract void BuildAddress(String adress);
    public abstract void BuildPassportData(String passportData);
    public abstract void BuildNotice(boolean notice);
    public Customer GetCustomer()
    {
        return Customer;
    }
}
