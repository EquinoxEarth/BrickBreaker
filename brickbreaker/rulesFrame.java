package brickbreaker;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class rulesFrame extends JFrame implements ActionListener {

	Font titleFont = new Font("Times New Roman", Font.PLAIN, 30);	
	Font other = new Font("Times New Roman", Font.PLAIN, 20);	
	JButton mainMenu;
	
	public rulesFrame(){
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("How to Play");
		setResizable(false);
		
		JPanel panel = new JPanel();
		JLabel rules = new JLabel();
		JLabel title = new JLabel("How To Play Brick Breaker");
		mainMenu = new JButton("Main Menu");
		
		panel.setBackground(Color.black);
		panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
		
		mainMenu.setFont(other);
		mainMenu.addActionListener(this);
		
		/*
		 * find a way to make text wrap in a jlabel
		 */
		
		rules.setForeground(Color.green);
		rules.setText("The objective of brick breaker is to get rid of all the bricks on the screen without losing all your lives.");
		rules.setFont(other);
		
		title.setFont(titleFont);
		title.setForeground(Color.red);
		
		panel.add(title);
		panel.add(rules);
		panel.add(Box.createRigidArea(new Dimension(400,350)));
		panel.add(mainMenu);
		add(panel);
		
		
	}


	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==mainMenu){
			setVisible(false);
			JFrame mainmenu = new mainFrame();
		}
	}
	
	
}
