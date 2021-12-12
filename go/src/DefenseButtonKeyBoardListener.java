import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class DefenseButtonKeyBoardListener implements KeyListener
{
	JButton jButton = new JButton();
	JTextArea jTextArea = new JTextArea();
	
	public DefenseButtonKeyBoardListener() 
	{
		
	}
	
	public DefenseButtonKeyBoardListener(JButton jButton, JTextArea jTextArea) 
	{
		this.jButton = jButton;
		this.jTextArea = jTextArea;
	}
	
	@Override
	public void keyTyped(KeyEvent e) 
	{
		
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		//this.jTextArea.setText(jTextArea.getText() + "\n" + e.getKeyCode());
		if(e.getKeyCode() == KeyEvent.VK_2)
		{
			jButton.doClick();
		}
	}
	
}
