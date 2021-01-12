package LogIn;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class UserData {
    String userAccountData = "DataBase\\UserAccountData.txt"; // 数据库路径

    private boolean foundUser = false;
    public static ArrayList<UserAccount> userList = new ArrayList<>();
    private int i = 0;
    public static int userNumber;
    UserAccount user;

    // 判断是否找到该用户，找到为true，反之false
    public boolean isFoundUser() {
        return foundUser;
    }

    // 将数据库中信息读到ArrayList中
    // 通过用户输入的id和密码，在数据库中查找该用户信息
    // 如果传入的id和密码正确，则返回UserAccount类型的用户信息数据
    public UserAccount getUserAccountById(String id, String passport) throws IOException {
        FileReader fis = new FileReader(userAccountData);
        BufferedReader ois = new BufferedReader(fis);

        String line = "";
        String[] arrays = null;

        while((line = ois.readLine()) != null){

            user = new UserAccount();

            arrays = line.split(",");

            user.setUserName(arrays[0]);
            user.setId(Integer.parseInt(arrays[1]));
            user.setPassport(arrays[2]);
            user.setAccountBalance(Integer.parseInt(arrays[3]));
            user.setAddress(arrays[4]);
            user.setDepositType(Boolean.parseBoolean(arrays[5]));

            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime depositDate = LocalDateTime.parse(arrays[6], fmt);
            user.setMakeDepositDate(depositDate);

            user.setInterestRate(Float.parseFloat(arrays[7]));
            user.setFreezeAccount(Boolean.parseBoolean(arrays[8]));

            if(arrays[1].equals(id) && passport.equals(arrays[2])){
                foundUser = true;
                userNumber = i;
            }

            userList.add(user);
            i++;

        }

        fis.close();
        ois.close();

        user = userList.get(userNumber);
        return user;
    }

    // 修改userList中userNumber位置的值为user
    // 将userList中数据覆盖在数据库中
    public void changeUserAccount(UserAccount user) throws IOException {

        userList.set(userNumber, user);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");

        FileOutputStream fos = new FileOutputStream(userAccountData);

        for (int j = 0; j < userList.size(); j++) {
            fos.write((userList.get(j).getUserName() + ","
                    + userList.get(j).getId() + ","
                    + userList.get(j).getPassport() + ","
                    + userList.get(j).getAccountBalance() + ","
                    + userList.get(j).getAddress() + ","
                    + userList.get(j).isDepositType() + ","
                    + userList.get(j).getMakeDepositDate().format(formatter) + ","
                    + userList.get(j).getInterestRate() + ","
                    + userList.get(j).isFreezeAccount()
                    + "\r\n").getBytes());
        }

        fos.close();
    }

    // 用户填好注册信息后，数据整理成UserAccount类型数据传入此函数
    // 此函数运行时userList为空，文件未读
    // 此函数将user信息补充写入数据库
    public void setUserAccount(UserAccount user) throws IOException {

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");

        FileOutputStream fos = new FileOutputStream(userAccountData, true);

        fos.write((user.getUserName() + ","
                + user.getId() + ","
                + user.getPassport() + ","
                + user.getAccountBalance() + ","
                + user.getAddress() + ","
                + user.isDepositType() + ","
                + date.format(formatter)
                + "," + user.getInterestRate()
                + "," + user.isFreezeAccount()
                + "\r\n").getBytes());

        fos.close();
    }
}
