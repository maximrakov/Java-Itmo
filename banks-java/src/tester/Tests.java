package tester;

import ui.CustomManager;
import exceptions.LimitIsExceeded;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Tests {
    static CustomManager customManager = new CustomManager();

    @BeforeAll
    static void preparation() {
        customManager.registerAccount("Ivan", "Ivanov");
        customManager.makeAccount("debit");
        customManager.makeAccount("debit");

        customManager.makeAccount("credit");
        customManager.makeAccount("debit");

        customManager.makeAccount("deposit");
        customManager.makeAccount("debit");
    }

    @Test
    void transferMoneyTestAndCancelTransfer() throws LimitIsExceeded {
        customManager.transfer(1, 2, 30);
        assert((customManager.getUserMoney().get(0) == 70) && (customManager.getUserMoney().get(1) == 130));
    }

    @Test
    void cancelTransfer() {
        customManager.cancelTransfer(1, 2, 30);
        assert((customManager.getUserMoney().get(0) == 100) && (customManager.getUserMoney().get(1) == 100));
    }

    @Test
    void checkPenaltyInCreditAccount(){
        try {
            customManager.transfer(3, 4, 150);
        } catch (LimitIsExceeded limitIsExceeded) {
            System.out.println("Limit is exceed");
        }
        assert ((customManager.getUserMoney().get(2) == -70));
    }

    @Test
    void limitAndImporevAccountTest() {
        boolean hasException = false;
        try {
            customManager.transfer(5, 6, 1000);
        } catch (LimitIsExceeded limitIsExceeded) {
            hasException = true;
        }
        assert hasException;

        customManager.improve("password", "adress");
        hasException = false;
        try {
            customManager.transfer(5, 6, 1000);
        } catch (LimitIsExceeded limitIsExceeded) {
            hasException = true;
        }
        assert (!hasException);
    }
}