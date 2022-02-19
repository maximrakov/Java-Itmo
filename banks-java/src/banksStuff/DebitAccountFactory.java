package banksStuff;

public class DebitAccountFactory implements IAccountFactory{
    public Account createAccount() {
        return new DebitAccount();
    }
}
