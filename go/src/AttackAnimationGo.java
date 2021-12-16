import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JLabel;

public class AttackAnimationGo extends TimerTask
{
	Timer timer = new Timer();
	JLabel Attacker = new JLabel();
	JLabel TakeAttacker = new JLabel();
	JButton jButton = new JButton();
	Arena arena;
	ArrayList<JButton> myJButtons = new ArrayList<JButton>();
	
	int orgAttackerX;
	int orgAttackerY;
	
	int orgTakeAttackerX;
	int orgTakeAttackerY;
	
	boolean isBack = false;
	boolean isTakeAttackerBack = false;
	int offset = 5;
	
	boolean isFromDefenseButtonActionEvent = false;
	
	public AttackAnimationGo(Timer timer, JLabel Attacker, JLabel TakeAttacker, Arena arena, ArrayList<JButton> myJButtons)
	{
		this.timer = timer;
		this.Attacker = Attacker;
		this.TakeAttacker = TakeAttacker;
		this.arena = arena;
		this.myJButtons = myJButtons;
		
		this.orgAttackerX = Attacker.getX();
		this.orgAttackerY = Attacker.getY();
		
		this.orgTakeAttackerX = TakeAttacker.getX();
		this.orgTakeAttackerY = TakeAttacker.getY();
		
		this.isFromDefenseButtonActionEvent = false;
	}
	
	public AttackAnimationGo(Timer timer, JLabel Attacker, JLabel TakeAttacker, Arena arena, ArrayList<JButton> myJButtons, String fromDefenseButtonActionEvent)
	{
		this.timer = timer;
		this.Attacker = Attacker;
		this.TakeAttacker = TakeAttacker;
		this.arena = arena;
		this.myJButtons = myJButtons;
		
		this.orgAttackerX = Attacker.getX();
		this.orgAttackerY = Attacker.getY();
		
		this.orgTakeAttackerX = TakeAttacker.getX();
		this.orgTakeAttackerY = TakeAttacker.getY();
		
		this.isFromDefenseButtonActionEvent = true;
	}
	
	
	private void attackerHitTakeAttacker()
	{
		int X = this.Attacker.getX();
		int Y = this.Attacker.getY();
		int width = this.Attacker.getWidth();
		
		
		if (isBack == false)
		{
			if (X + (width / 2) <= TakeAttacker.getX())	
			{
				this.Attacker.setLocation(X + offset, Y);
			}
			else 
			{
				isBack = true;
			}
		}
		else if (isBack == true) 
		{
			if (orgAttackerX < X) 
			{
				this.Attacker.setLocation(X - offset, Y);
			}
			else if(this.arena.monster2Action.equals(Arena.attackString))
			{
				this.TakeAttackerHitAttacker();	
			}
			else 
			{
				this.UnlockAllButton();
				timer.cancel();
				arena.fight();
				timer.purge();
			}
		}
	}
	
	private void TakeAttackerHitAttacker()
	{
		int X = this.TakeAttacker.getX();
		int Y = this.TakeAttacker.getY();
		int width = this.TakeAttacker.getWidth();
		
		
		if (isTakeAttackerBack == false)
		{
			if (X - (width / 2) >= this.Attacker.getX())	
			{
				this.TakeAttacker.setLocation(X - offset, Y);
			}
			else
			{
				isTakeAttackerBack = true;
			}
		}
		else if (isTakeAttackerBack == true) 
		{
			if (orgTakeAttackerX > X) 
			{
				this.TakeAttacker.setLocation(X + offset, Y);
			}
			else 
			{
				this.UnlockAllButton();
				timer.cancel();
				arena.fight();
				timer.purge();
			}
		}
	}
	
	private void LockAllButton()
	{
		this.myJButtons.forEach((jButton) -> jButton.setEnabled(false));
	}
	
	private void UnlockAllButton() 
	{
		this.myJButtons.forEach((jButton) -> jButton.setEnabled(true));
	}
	
	public void run()
	{
		this.LockAllButton();
		
		if (this.isFromDefenseButtonActionEvent == false) 
		{
			this.attackerHitTakeAttacker();
		}
		else 
		{
			this.TakeAttackerHitAttacker();
		}
	}
}