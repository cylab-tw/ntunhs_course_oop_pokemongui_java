import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Arena {
	Monster monster1 = new Monster();
	Monster monster2 = new Monster();
	
	JTextArea jTextArea = new JTextArea();
	
	String monster1Action = new String();
	String monster2Action = new String();
	
	int roundCount = 0;
	int firstAttacker = 1;
	boolean isFightDone = false;
	boolean isBothMonsterChoosedAction = false;
	
	static final String attackString = "attack";
	static final String defenseString = "defense";
	static final String errorActionString = "出事了阿伯";
	
	public Arena(Monster monster1, Monster monster2, JTextArea jTextArea) 
	{
		this.monster1 = monster1;
		this.monster2 = monster2;
		this.jTextArea = jTextArea;
	}
	
	public void setMonster1Action(String actionString)
	{
		if (actionString.equalsIgnoreCase(attackString)) 
		{
			this.monster1Action = this.attackString;
		}
		else if (actionString.equalsIgnoreCase(defenseString))
		{
			this.monster1Action = this.defenseString;
		}
		else 
		{
			this.monster1Action = this.errorActionString;
		}
	}
	
	public void setMonster2Action(String actionString)
	{
		if (actionString.equalsIgnoreCase(attackString)) 
		{
			this.monster2Action = this.attackString;
		}
		else if (actionString.equalsIgnoreCase(defenseString))
		{
			this.monster2Action = this.defenseString;
		}
		else 
		{
			this.monster2Action = this.errorActionString;
		}
	}
	
	private void updateIsBothMonsterChoosedAction()
	{
		boolean isMonster1Actioned = false;
		boolean isMonster2Actioned = false;
		
		if (this.monster1Action.equals(this.attackString) || this.monster1Action.equals(this.defenseString))
		{
			isMonster1Actioned = true;
		}
		
		if (this.monster2Action.equals(this.attackString) || this.monster2Action.equals(this.defenseString))
		{
			isMonster2Actioned = true;
		}
		
		if (isMonster1Actioned && isMonster2Actioned)
		{
			this.isBothMonsterChoosedAction = true;
		}
	}
	
	public boolean getIsBothMonsterChoosedAction()
	{
		this.updateIsBothMonsterChoosedAction();
		return this.isBothMonsterChoosedAction;
	}
	
	public void fight()
	{	
		if (this.isFightDone) JOptionPane.showMessageDialog(null, "戰鬥已結束!");
		else this.jTextArea.setText("");
		
		
		this.updateIsBothMonsterChoosedAction();
		
		if (isBothMonsterChoosedAction)
		{
			roundCount++;
			
			if(this.monster1Action.equals(this.attackString) && this.monster2Action.equals(this.attackString))
			{
				this.isFightDone = this.attackEachOtherMonster();
			}
			else if (this.monster1Action.equals(this.attackString) && this.monster2Action.equals(this.defenseString))
			{
				this.isFightDone = this.oneAttackOneDefenseMonster(monster1, monster2);
			}
			else if (this.monster1Action.equals(this.defenseString) && this.monster2Action.equals(this.attackString))
			{
				this.isFightDone = this.oneAttackOneDefenseMonster(monster2, monster1);	
			}
			else if (this.monster1Action.equals(this.defenseString) && this.monster2Action.equals(this.defenseString))
			{
				this.isFightDone = this.bothDefenseMonster(monster1, monster2);
			}
		}
		
		if (this.isFightDone) JOptionPane.showMessageDialog(null, "戰鬥已結束!");
	}
	
	public void fight(String monster1Action, String monster2Action)
	{
		setMonster1Action(monster1Action);
		setMonster2Action(monster2Action);
		this.fight();
	}
	
	private int attackMonster(Monster attacker, Monster takeAttacker)
	{
		int result = 0;
		
		result = attacker.Attack(takeAttacker);
		
		switch (result) 
		{
			case 1: 
				this.jTextArea.setText(jTextArea.getText() + attacker.ID + "攻擊成功\n");
				break; 
			case 2: 
				this.jTextArea.setText(jTextArea.getText() + attacker.ID + "攻擊失敗\n");
				break;
			case 3: 
				this.jTextArea.setText(jTextArea.getText() + attacker.ID + "擊敗" + takeAttacker.ID + "\n");
				break;
		}
		
		this.jTextArea.setText(jTextArea.getText() + attacker.getStatusString(takeAttacker, false));
		
		return result;
	}
	
	private boolean attackEachOtherMonster()
	{
		boolean result = false;
		int firstAttackedResult = 0;
		int secondAttackedResult = 0;

		//第一次攻擊
		if (firstAttacker == 1 && this.isFightDone == false)
		{
			firstAttackedResult = this.attackMonster(monster1, monster2);
			if (firstAttackedResult == 3) result = true;
		}
		else 
		{
			firstAttackedResult = this.attackMonster(monster2, monster1);
			if (firstAttackedResult == 3) result = true;
		}
		
		//第二次攻擊
		if (firstAttacker == 1 && this.isFightDone == false)
		{
			secondAttackedResult = this.attackMonster(monster2, monster1);
			if (secondAttackedResult == 3) result = true;
		}
		else 
		{
			secondAttackedResult = this.attackMonster(monster1, monster2);
			if (secondAttackedResult == 3) result = true;
		}
		
		return result;
	}
	
	private boolean oneAttackOneDefenseMonster(Monster attacker, Monster defender)
	{
		boolean result = false;
		int defenseResult = 0;
		int attackResult = 0;
		
		//紀錄防守前的原始數值
		int orgDefenseValue = defender.getDefenseValue();
		//this.jTextArea.setText(jTextArea.getText() + "orgDefenseValue:"+ orgDefenseValue + "\n");
		defenseResult = defender.Defend(defender);
		int afterDefenseValue = defender.getDefenseValue();
		//this.jTextArea.setText(jTextArea.getText() + "afterDefenseValue:"+ afterDefenseValue + "\n");
		
		switch (defenseResult) 
		{
			case 1:
				this.jTextArea.setText(jTextArea.getText() + defender.ID + "防守成功 防禦力加成\n");
				break;
			case 2:
				this.jTextArea.setText(jTextArea.getText() + defender.ID + "防守失敗\n");
				break;
		}
		
		//開始攻擊
		attackResult = this.attackMonster(attacker, defender);
		if (attackResult == 3) result = true;
		
		//血量回寫回去
		defender.Defense = orgDefenseValue;
		
		return result;
	}
	
	private boolean bothDefenseMonster(Monster monster1, Monster monster2)
	{
		boolean result = false;
		
		this.jTextArea.setText(jTextArea.getText() + "雙方防守" + "\n\n");
		this.jTextArea.setText(jTextArea.getText() + monster1.getStatusString(monster2, true));
		
		return result;
	}
	
	public String getRandomAction()
	{
		String result = new String();
		//int BotSelect = (int) (Math.random() * (2 - 1 + 1) + 1);
		int BotSelect = new Random(System.currentTimeMillis()).nextInt(3) + 1;
		result = BotSelect == 1 ? this.attackString : this.defenseString;
		return result;
	}
	
	
		

}
