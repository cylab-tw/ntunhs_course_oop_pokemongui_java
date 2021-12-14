import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class BaseDetailButtonActionEvent implements ActionListener
{
	JButton jButton = new JButton();
	JTextArea jTextArea = new JTextArea();
	JLabel player1JLabel = new JLabel();
	JLabel player2JLabel = new JLabel();
	
	public BaseDetailButtonActionEvent(JButton jButton, JTextArea jTextArea, JLabel player1JLabel, JLabel player2JLabel) 
	{
		this.jButton = jButton;
		this.jTextArea = jTextArea;
		this.player1JLabel = player1JLabel;
		this.player2JLabel = player2JLabel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{	
		jTextArea.setText(jTextArea.getText() + "基本資料!");
		JOptionPane.showMessageDialog(null, Author.getter());
	}
}
