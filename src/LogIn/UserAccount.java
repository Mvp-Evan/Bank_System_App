package LogIn;

import java.time.LocalDateTime;

public class UserAccount {
    private String userName;   // 用户姓名
    private int id;            // 用户卡号
    private String passport;   // 用户密码
    private int accountBalance = 0;   // 账户余额
    private String address;      // 用户住址
    private boolean depositType = false; // 定期存款true， 活期存款false
    private LocalDateTime makeDepositDate;  // 取款日期
    private float interestRate = (float) 1.23;    // 利率
    private boolean freezeAccount = false; // 冻结账户true，未冻结false

    public float getInterestRate() {
        return interestRate;
    }

    public boolean isFreezeAccount() {
        return freezeAccount;
    }

    public void setFreezeAccount(boolean freezeAccount) {
        this.freezeAccount = freezeAccount;
    }

    public LocalDateTime getMakeDepositDate() {
        return makeDepositDate;
    }

    public boolean isDepositType() {
        return depositType;
    }

    public String getAddress() {
        return address;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setInterestRate(float interestRate) {
        if(depositType){ this.interestRate = (float) 2.56; }
        else { this.interestRate = interestRate; }
    }

    public void setMakeDepositDate(LocalDateTime makeDepositDate) {
        this.makeDepositDate = makeDepositDate;
    }

    public void setDepositType(boolean depositType) {
        this.depositType = depositType;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getPassport() {
        return passport;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
