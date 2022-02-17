package BanksStuff;

public class CreditAccountFactory implements IAccountFactory {
    public Account CreateAccount()
    {
        return new CreditAccount();
    }
}
