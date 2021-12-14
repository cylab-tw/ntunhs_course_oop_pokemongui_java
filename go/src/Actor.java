
public class Actor 
{
	public String Name, Account;
    private String Password;
    protected Monster Monster;
    protected MonsterFire MonsterFire;
    protected MonsterWater MonsterWater;

    Actor(String name, String account, String password) {
        Name = name;
        Account = account;
        Password = password;
        Monster = new Monster();// 預設一個怪獸
    }

    int login(String account, String password) {
        if (Account.equals(account)) {
            if (Password.equals(password)) {
                return 1;// 登入成功
            }
            return 2;// 密碼錯誤
        }
        return 3;// 帳戶不存在
    }
}
