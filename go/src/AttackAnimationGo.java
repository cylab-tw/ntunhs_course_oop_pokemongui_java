import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

public class AttackAnimationGo extends TimerTask
{
	Timer timer = new Timer();
	JLabel Attacker = new JLabel();
	JLabel TakeAttacker = new JLabel();
	int orgAttackerX;
	int orgAttackerY;
	boolean isBack = false;
	
	public AttackAnimationGo(Timer timer, JLabel Attacker, JLabel TakeAttacker)
	{
		this.timer = timer;
		this.Attacker = Attacker;
		this.TakeAttacker = TakeAttacker;
		this.orgAttackerX = Attacker.getX();
		this.orgAttackerY = Attacker.getY();
	}
	
	public void run()
	{
		int X = this.Attacker.getX();
		int Y = this.Attacker.getY();
		int width = this.Attacker.getWidth();
		
		
		if (isBack == false)
		{
			if (X + (width / 2) <= TakeAttacker.getX())	
			{
				this.Attacker.setLocation(X+1, Y);
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
				this.Attacker.setLocation(X-1, Y);
			}
			else 
			{
				timer.cancel();
				timer.purge();
			}
		}
	}
}