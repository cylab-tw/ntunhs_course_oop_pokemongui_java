
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
        Monster = new Monster();// �w�]�@�ө��~
    }

    int login(String account, String password) {
        if (Account.equals(account)) {
            if (Password.equals(password)) {
                return 1;// �n�J���\
            }
            return 2;// �K�X���~
        }
        return 3;// �b�ᤣ�s�b
    }
}
