package BanksStuff;

import exceptions.LimitIsExceeded;

import java.util.List;

public interface ICustomer {
    public void MakeTransfer(int accountId, int accountToId, int amount) throws LimitIsExceeded;

    public List<Integer> GetUserAccounts();

    public List<Integer> GetUserMoney();

    public void AddMoreInformation(String address, String passport);

    public void AddAccount(Account account);

    public void CancelTransfer(int accountId, int accountToId, int amount);

    public void AddMoney(int accountId, int amount);

    public void TakeMoney(int accountId, int amount);

    public boolean HasThisType(String type);

//    public List<Account> GetAccounts();

//    public String GetName();

//    public boolean GetNotice();

//    public List<String> GetMessages();

//    public void SetPassword(String password);

//    public void SetAdress(String adress);

    public void setNotice(boolean notice);

    public String getName();

    public void setName(String name);

    public String getSurname();

    public void setSurname(String surname);

    public String getAddress();

    public void setAddress(String address);

    public String getPassportData();

    public void setPassportData(String passportData);

    public boolean isNotice();

//    public void SetNotice(boolean notice);

    public List<Account> getAccounts();

    public void setAccounts(List<Account> accounts);

    public List<String> getMessages();

    public void setMessages(List<String> messages);
}
