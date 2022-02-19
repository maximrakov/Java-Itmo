package banksStuff;

public class DepositAccountFactory implements IAccountFactory {
    public Account createAccount() {
        return new DepositAccount();
    }
}
