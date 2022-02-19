package banksStuff;

public class CreditAccountFactory implements IAccountFactory {
    public Account createAccount() {
        return new CreditAccount();
    }
}
