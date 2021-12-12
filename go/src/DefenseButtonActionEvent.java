import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class DefenseButtonActionEvent implements ActionListener
{
	JButton jButton = new JButton();
	JTextArea jTextArea = new JTextArea();
	JLabel player1JLabel = new JLabel();
	JLabel player2JLabel = new JLabel();
	Arena arena;
	String botActionString = new String();
	
	public DefenseButtonActionEvent(JButton jButton, JTextArea jTextArea, JLabel player1JLabel, JLabel player2JLabel, Arena arena) 
	{
		this.jButton = jButton;
		this.jTextArea = jTextArea;
		this.player1JLabel = player1JLabel;
		this.player2JLabel = player2JLabel;
		this.arena = arena;
		this.botActionString = arena.getRandomAction();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{	
		if (arena.isFightDone == false) 
		{
			jTextArea.setText(jTextArea.getText() + "¨¾¿m!\n");
			this.arenaInit();
			
			if(this.arena.monster2Action.equals(Arena.attackString))
			{
				try {
					this.attackAnimation();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			else 
			{
				arena.fight();
			}
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "¾Ô°«¤wµ²§ô!");
		}
	}
	
	private void attackAnimation() throws InterruptedException 
	{
		long delay = 0L;
		long period = 5L; 
		Timer timer = new Timer();
		AttackAnimationGo attackAnimationGo = new AttackAnimationGo(timer, player1JLabel, player2JLabel, arena, "fromDefenseButtonActionEvent");
		timer.schedule(attackAnimationGo, delay, period);
	}
	
	private void arenaInit()
	{
		this.arena.setMonster1Action(Arena.defenseString);
		this.arena.setMonster2Action(botActionString);
	}
}
