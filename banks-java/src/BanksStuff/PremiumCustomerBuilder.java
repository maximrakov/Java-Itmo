package BanksStuff;

public class PremiumCustomerBuilder extends CustomerBuilder{
    public void BuildAddress(String adress)
    {
        Customer.setAddress(adress);
    }

    public void BuildName(String name)
    {
        Customer.setName(name);
    }

    public void BuildNotice(boolean notice)
    {
        Customer.setNotice(notice);
    }

    public void BuildPassportData(String passportData)
    {
        Customer.setPassportData(passportData);
    }

    public void BuildSurname(String surname)
    {
        Customer.setSurname(surname);
    }
}
