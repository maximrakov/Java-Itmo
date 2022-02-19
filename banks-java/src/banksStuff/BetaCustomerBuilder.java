package banksStuff;

public class BetaCustomerBuilder extends CustomerBuilder
{
    public  void buildAddress(String adress) {
        Customer.setAddress(adress);
    }

    public  void buildName(String name) {
        Customer.setName(name);
    }

    public void buildNotice(boolean notice) {
        Customer.setNotice(notice);
    }

    public void buildPassportData(String passportData) {
        Customer.setPassportData(passportData);
    }

    public void buildSurname(String surname) {
        Customer.setSurname(surname);
    }
}