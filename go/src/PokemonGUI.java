import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

//Java GUI Swing 入門：https://iter01.com/560263.html
//Layout：https：//blog.xuite.net/jane17512001/PenguinDesign/243299537
//Button Event：https://www.gushiciku.cn/pl/aljW/zh-tw

public class PokemonGUI {

	JFrame jFrame = new JFrame("PokemonGUI");
	JButton attackButton = new JButton("攻擊");
    JButton defenseButton = new JButton("防禦");
    JButton baseDetailButton = new JButton("基本資料");
    JTextArea jTextArea = new JTextArea("ConsoleBagConstraints");
	JPanel jPanel = new JPanel();
	JLabel player1JLabel = new JLabel();
	JLabel player2JLabel = new JLabel();
	AttackButtonKeyBoardListener myKeyListener = new AttackButtonKeyBoardListener();
	
    
	public static void main(String[] args) throws IOException {
        new PokemonGUI().init();
        
        Actor actor1 = new Actor("小高", "092214221", "221");
        MonsterFire botMonster = new MonsterFire();
        MonsterWater playerMonster = new MonsterWater();
        actor1.MonsterWater = playerMonster;
        
    } 
	
	
	private void JFrameInit()
	{
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(1000, 1000);
		jFrame.setLayout(new GridBagLayout());
		
		this.KeyBoardListenerInit();
	}
	
	private void GridBagConstraintsInit() 
	{
		GridBagConstraints imageBagConstraints = new GridBagConstraints();
		imageBagConstraints.gridx = 0;
		imageBagConstraints.gridy = 0;
		imageBagConstraints.gridwidth = 3;
		imageBagConstraints.gridheight = 2;
		imageBagConstraints.weightx = 1;
		imageBagConstraints.weighty = 1;
		imageBagConstraints.fill = GridBagConstraints.BOTH;
		imageBagConstraints.anchor = GridBagConstraints.WEST;
		jFrame.add(jPanel, imageBagConstraints);
		
		
		GridBagConstraints attackbuttonBagConstraints = new GridBagConstraints();
		attackbuttonBagConstraints.gridx = 0;
		attackbuttonBagConstraints.gridy = 2;
		attackbuttonBagConstraints.gridwidth = 1;
		attackbuttonBagConstraints.gridheight = 1;
		attackbuttonBagConstraints.weightx = 1;
		attackbuttonBagConstraints.weighty = 1;
		attackbuttonBagConstraints.fill = GridBagConstraints.BOTH;
		attackbuttonBagConstraints.anchor = GridBagConstraints.WEST;
		jFrame.add(attackButton, attackbuttonBagConstraints);
		
		
		GridBagConstraints defensebuttonBagConstraints = new GridBagConstraints();
		defensebuttonBagConstraints.gridx = 1;
		defensebuttonBagConstraints.gridy = 2;
		defensebuttonBagConstraints.gridwidth = 1;
		defensebuttonBagConstraints.gridheight = 1;
		defensebuttonBagConstraints.weightx = 1;
		defensebuttonBagConstraints.weighty = 1;
		defensebuttonBagConstraints.fill = GridBagConstraints.BOTH;
		defensebuttonBagConstraints.anchor = GridBagConstraints.WEST;
		jFrame.add(defenseButton, defensebuttonBagConstraints);
		
		
		GridBagConstraints baseDetailbuttonBagConstraints = new GridBagConstraints();
		baseDetailbuttonBagConstraints.gridx = 2;
		baseDetailbuttonBagConstraints.gridy = 2;
		baseDetailbuttonBagConstraints.gridwidth = 1;
		baseDetailbuttonBagConstraints.gridheight = 1;
		baseDetailbuttonBagConstraints.weightx = 1;
		baseDetailbuttonBagConstraints.weighty = 1;
		baseDetailbuttonBagConstraints.fill = GridBagConstraints.BOTH;
		baseDetailbuttonBagConstraints.anchor = GridBagConstraints.WEST;
		jFrame.add(baseDetailButton, baseDetailbuttonBagConstraints);
		
		
		GridBagConstraints ConsoleBagConstraints = new GridBagConstraints();
		ConsoleBagConstraints.gridx = 0;
		ConsoleBagConstraints.gridy = 3;
		ConsoleBagConstraints.gridwidth = 3;
		ConsoleBagConstraints.gridheight = 1;
		ConsoleBagConstraints.weightx = 1;
		ConsoleBagConstraints.weighty = 1;
		ConsoleBagConstraints.fill = GridBagConstraints.BOTH;
		ConsoleBagConstraints.anchor = GridBagConstraints.WEST;
		jFrame.add(jTextArea, ConsoleBagConstraints);
	}
	
	private void ButtonInit()
	{
		this.AttackButtonInit();
		this.DefenseButtonInit();
		this.BaseDetailButtonInit();
	}
	
	private void AttackButtonInit() 
	{
		AttackButtonActionEvent attackButtonActionEvent = new AttackButtonActionEvent(attackButton, jTextArea, player1JLabel, player2JLabel);
		attackButton.addActionListener(attackButtonActionEvent);
	}
	
	private void DefenseButtonInit() 
	{
		DefenseButtonActionEvent defenseButtonActionEvent = new DefenseButtonActionEvent(defenseButton, jTextArea, player1JLabel, player2JLabel);
		defenseButton.addActionListener(defenseButtonActionEvent);
	}
	
	private void BaseDetailButtonInit() 
	{
		BaseDetailButtonActionEvent baseDetailButtonActionEvent = new BaseDetailButtonActionEvent(baseDetailButton, jTextArea, player1JLabel, player2JLabel);
		baseDetailButton.addActionListener(baseDetailButtonActionEvent);
	}
	
	private void JPanelInit() throws IOException
	{		
		ImageIcon player1Image = new ImageIcon("C:\\Users\\k2812\\eclipse-workspace\\go\\pic\\chromeIcon.png");
		ImageIcon player2Image = new ImageIcon("C:\\Users\\k2812\\eclipse-workspace\\go\\pic\\edgeIcon.png");
		
		player1JLabel.setIcon(player1Image);
		player1JLabel.setLocation(333 - player1Image.getIconWidth(), 167 - player1Image.getIconHeight());
		player1JLabel.setSize(player1Image.getIconWidth(), player1Image.getIconHeight());
		
		player2JLabel.setIcon(player2Image);
		player2JLabel.setLocation(666 - player2Image.getIconWidth(), 167 - player2Image.getIconHeight());
		player2JLabel.setSize(player2Image.getIconWidth(), player2Image.getIconHeight());
		
		jPanel.add(player1JLabel);
		jPanel.add(player2JLabel);
		jPanel.setBackground(Color.white);
		jPanel.setLayout(null);
	}
	
	private void KeyBoardListenerInit() 
	{
		AttackButtonKeyBoardListener attackButtonKeyBoardListener = new AttackButtonKeyBoardListener(attackButton, jTextArea);		
		DefenseButtonKeyBoardListener defenseButtonKeyBoardListener = new DefenseButtonKeyBoardListener(defenseButton, jTextArea);		
		BaseDetailButtonKeyBoardListener baseDetailButtonKeyBoardListener = new BaseDetailButtonKeyBoardListener(baseDetailButton, jTextArea);
		
		jFrame.addKeyListener(attackButtonKeyBoardListener);
		jFrame.addKeyListener(defenseButtonKeyBoardListener);
		jFrame.addKeyListener(baseDetailButtonKeyBoardListener);
	}
	
	private void init() throws IOException
	{
		this.JFrameInit();
		this.GridBagConstraintsInit();
		this.ButtonInit();
		this.JPanelInit();
		
		
		jFrame.setVisible(true);
		jFrame.toFront();
		jFrame.requestFocus();
    }
}
