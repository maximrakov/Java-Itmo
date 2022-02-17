package BanksStuff;

public class CustomerDirector {
    public CustomerBuilder CustomerBuilder;

    public ICustomer BuildCustomer(String name, String surname)
    {
        CustomerBuilder.BuildName(name);
        CustomerBuilder.BuildSurname(surname);
        return CustomerBuilder.GetCustomer();
    }

    public ICustomer BuildCustomer(String name, String surname, String address, String passwordData)
    {
        CustomerBuilder.BuildName(name);
        CustomerBuilder.BuildSurname(surname);
        CustomerBuilder.BuildAddress(address);
        CustomerBuilder.BuildPassportData(passwordData);
        return CustomerBuilder.GetCustomer();
    }

    public BanksStuff.CustomerBuilder getCustomerBuilder() {
        return CustomerBuilder;
    }

    public void setCustomerBuilder(BanksStuff.CustomerBuilder customerBuilder) {
        CustomerBuilder = customerBuilder;
    }
}
