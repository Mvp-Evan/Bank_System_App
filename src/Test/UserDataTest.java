package Test;

import LogIn.UserAccount;
import LogIn.UserData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class UserDataTest {

    UserAccount user;
    UserData userData;

    @BeforeEach
    void setup(){
        user = new UserAccount();
        userData = new UserData();
        user.setUserName("test");
        user.setId(123);
        user.setPassport("123");
        user.setAccountBalance(1000);
        user.setAddress("Tianjin");
        user.setDepositType(true);
        user.setMakeDepositDate(LocalDateTime.of(2020,5,20,21,18,53));
        user.setInterestRate((float) 23.234);
        user.setFreezeAccount(false);
    }

    @Test
    void setUserAccountTest() throws IOException {
        userData.setUserAccount(user);
    }

    @Test
    void getUserAccountTest() throws IOException {
        user = userData.getUserAccountById("123", "123");
        assertEquals(user.getUserName(), "test");
        assertEquals(user.getAccountBalance(), 1000);
        assertEquals(user.getAddress(), "Tianjin");
        assertTrue(user.isDepositType());
        assertEquals(user.getMakeDepositDate(), LocalDateTime.of(2020,5,20,21,18,53));
        assertEquals(user.getInterestRate(), (float) 23.234);
        assertFalse(user.isFreezeAccount());
    }

}
