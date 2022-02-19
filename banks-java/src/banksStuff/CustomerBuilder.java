package banksStuff;

public abstract class CustomerBuilder {
    protected Customer Customer;

    public CustomerBuilder(Customer customer) {
        Customer = customer;
    }

    public CustomerBuilder() {
    }

    public abstract void buildName(String name);
    public abstract void buildSurname(String surname);
    public abstract void buildAddress(String adress);
    public abstract void buildPassportData(String passportData);
    public abstract void buildNotice(boolean notice);
    public Customer getCustomer() {
        return Customer;
    }
}
