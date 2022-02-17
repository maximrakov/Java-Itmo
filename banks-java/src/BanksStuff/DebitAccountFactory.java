package BanksStuff;

public class DebitAccountFactory implements IAccountFactory{
    public Account CreateAccount()
    {
        return new DebitAccount();
    }
}
