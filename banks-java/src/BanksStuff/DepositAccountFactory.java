package BanksStuff;

public class DepositAccountFactory implements IAccountFactory {
    public Account CreateAccount()
    {
        return new DepositAccount();
    }
}
