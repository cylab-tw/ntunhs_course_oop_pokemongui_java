import java.util.Random;

public class Monster extends MonsterBase implements Cloneable{
    public String ID, Name;
    public int MonsterType;
    protected int HP, Attack, Defense;    
    
    
    int Attack(Monster enemy) 
    {
        //int Arandom = (int) (Math.random() * (10 - 1 + 1) + 1);
        int Arandom = new Random(System.currentTimeMillis()).nextInt(9) + 0;
        int lostHP = 0;
        int result = 0;
        if (Arandom == 10) 
        {// 10% x2
            if (Attack * 2 - enemy.Defense > 0) 
            {
                Attack *= 2;
                lostHP += Attack - enemy.Defense;
                enemy.HP -= lostHP;
                if (enemy.HP <= 0) 
                {
                    enemy.HP = 0;
                    result = 3;
                } 
                else 
                {
                    result = 1;
                }
                System.out.println(Name + " 失血量：0" + " 剩餘血量：" + HP + " 攻擊力：" + Attack + " 防守力：" + Defense);
                System.out.println(enemy.Name + " 失血量：" + lostHP + " 剩餘血量：" + enemy.HP + " 攻擊力：" + enemy.Attack + " 防守力："
                        + enemy.Defense + "\n");
            } 
            else 
            {
                result = 2;
            }
        } 
        else if (Arandom >= 8 && Arandom <= 9) 
        {// 20% x1.5
            if (Attack * 1.5 - enemy.Defense > 0) 
            {
                Attack *= 1.5;
                lostHP += Attack - enemy.Defense;
                enemy.HP -= lostHP;
                if (enemy.HP <= 0) 
                {
                    enemy.HP = 0;
                    result = 3;
                } 
                else 
                {
                    result = 1;
                }
                System.out.println(Name + " 失血量：0" + " 剩餘血量：" + HP + " 攻擊力：" + Attack + " 防守力：" + Defense);
                System.out.println(enemy.Name + " 失血量：" + lostHP + " 剩餘血量：" + enemy.HP + " 攻擊力：" + enemy.Attack + " 防守力："
                        + enemy.Defense + "\n");
            } 
            else 
            {
                result = 2;
            }
        } 
        else if (Arandom >= 5 && Arandom <= 7) 
        {// 30% x1
            if (Attack - enemy.Defense > 0)
            {
                lostHP += Attack - enemy.Defense;
                enemy.HP -= lostHP;
                if (enemy.HP <= 0) 
                {
                    enemy.HP = 0;
                    result = 3;
                } 
                else 
                {
                    result = 1;
                }
                System.out.println(Name + " 失血量：0" + " 剩餘血量：" + HP + " 攻擊力：" + Attack + " 防守力：" + Defense);
                System.out.println(enemy.Name + " 失血量：" + lostHP + " 剩餘血量：" + enemy.HP + " 攻擊力：" + enemy.Attack + " 防守力："
                        + enemy.Defense + "\n");
            } 
            else 
            {
                result = 2;
            }
        } 
        else if (Arandom >= 3 && Arandom <= 4) 
        {// 20% x0.5
            if (Attack * 0.5 - enemy.Defense > 0) 
            {
                Attack *= 0.5;
                lostHP += Attack - enemy.Defense;
                enemy.HP -= lostHP;
                if (enemy.HP <= 0) 
                {
                    enemy.HP = 0;
                    result = 3;
                } 
                else 
                {
                    result = 1;
                }
                System.out.println(Name + " 失血量：0" + " 剩餘血量：" + HP + " 攻擊力：" + Attack + " 防守力：" + Defense);
                System.out.println(enemy.Name + " 失血量：" + lostHP + " 剩餘血量：" + enemy.HP + " 攻擊力：" + enemy.Attack + " 防守力："
                        + enemy.Defense + "\n");
            } 
            else 
            {
                result = 2;
            }
        } 
        else if (Arandom >= 1 && Arandom <= 2) 
        {// 20% fail;
            result = 2;
        }
        return result;
    }

    int Defend(Monster object) {
        //int Brandom = (int) (Math.random() * (10 - 1 + 1) + 1);
    	int Brandom = new Random(System.currentTimeMillis()).nextInt(10) + 1;
        int result = 0;
        if (Brandom == 10) {// 10% x4
            object.Defense *= 4;
            result = 1;
        } else if (Brandom >= 8 && Brandom <= 9) {// 20% x2
            object.Defense *= 2;
            result = 1;
        } else if (Brandom >= 4 && Brandom <= 7) {// 40% x1.5
            object.Defense *= 1.5;
            result = 1;
        } else if (Brandom >= 1 && Brandom <= 3) {// 30% fail;
            result = 2;
        }
        return result;
    }
    
    int getDefenseValue()
    {
    	return this.Defense;
    }
}