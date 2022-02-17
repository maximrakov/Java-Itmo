package Tester;

import UI.CustomManager;
import exceptions.LimitIsExceeded;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class Tests {
    static CustomManager customManager = new CustomManager();

    @BeforeAll
    static void Preparation() {
        customManager.RegisterAccount("Ivan", "Ivanov");
        customManager.MakeAccount("debit");
        customManager.MakeAccount("debit");

        customManager.MakeAccount("credit");
        customManager.MakeAccount("debit");

        customManager.MakeAccount("deposit");
        customManager.MakeAccount("debit");
    }

    @Test
    void TransferMoneyTestAndCancelTransfer() throws LimitIsExceeded {
        customManager.Transfer(1, 2, 30);
        assert((customManager.GetUserMoney().get(0) == 70) && (customManager.GetUserMoney().get(1) == 130));
    }

    @Test
    void CancelTransfer() {
        customManager.CancelTransfer(1, 2, 30);
        assert((customManager.GetUserMoney().get(0) == 100) && (customManager.GetUserMoney().get(1) == 100));
    }

    @Test
    void checkPenaltyInCreditAccount(){
        try {
            customManager.Transfer(3, 4, 150);
        } catch (LimitIsExceeded limitIsExceeded) {
            System.out.println("Limit is exceed");
        }
        assert ((customManager.GetUserMoney().get(2) == -70));
    }

    @Test
    void LimitAndImporevAccountTest() {
        boolean hasException = false;
        try {
            customManager.Transfer(5, 6, 1000);
        } catch (LimitIsExceeded limitIsExceeded) {
            hasException = true;
        }
        assert hasException;

        customManager.Improve("password", "adress");
        hasException = false;
        try {
            customManager.Transfer(5, 6, 1000);
        } catch (LimitIsExceeded limitIsExceeded) {
            hasException = true;
        }
        assert (!hasException);
    }
}