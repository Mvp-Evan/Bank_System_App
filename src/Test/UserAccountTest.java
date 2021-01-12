package Test;

import LogIn.UserAccount;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserAccountTest {
    UserAccount user;

    @BeforeEach
    void setup(){
        user = new UserAccount();
    }

    @Test
    void setUserName(){
        user.setUserName("zhengmocun");
        assertEquals(user.getUserName(), "zhengmocun");
    }

    @Test
    void setUserId(){
        user.setId(1);
        assertEquals(user.getId(), 1);
    }

    @AfterEach
    void free(){
        user = null;
    }
}
