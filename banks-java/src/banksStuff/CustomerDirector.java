package banksStuff;

public class CustomerDirector {
    public CustomerBuilder CustomerBuilder;

    public ICustomer buildCustomer(String name, String surname) {
        CustomerBuilder.buildName(name);
        CustomerBuilder.buildSurname(surname);
        return CustomerBuilder.getCustomer();
    }

    public ICustomer buildCustomer(String name, String surname, String address, String passwordData) {
        CustomerBuilder.buildName(name);
        CustomerBuilder.buildSurname(surname);
        CustomerBuilder.buildAddress(address);
        CustomerBuilder.buildPassportData(passwordData);
        return CustomerBuilder.getCustomer();
    }

    public banksStuff.CustomerBuilder getCustomerBuilder() {
        return CustomerBuilder;
    }

    public void setCustomerBuilder(banksStuff.CustomerBuilder customerBuilder) {
        CustomerBuilder = customerBuilder;
    }
}
