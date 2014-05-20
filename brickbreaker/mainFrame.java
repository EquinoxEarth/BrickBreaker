package brickbreaker;

import static brickbreaker.BrickBreaker.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class mainFrame extends JFrame implements ActionListener {
    
    public boolean startPressed = false;
    
    JButton start;
    JButton rules;
    JButton options;
    JButton exit;
    
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 40);
    Font other = new Font("Times New Roman", Font.PLAIN, 20);
    
    public mainFrame() {
        
	setSize(300,500);
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	setTitle("Brick Breaker");
	setResizable(false);
	
	JPanel title= new JPanel();
	JPanel panel = new JPanel();
	
	start = new JButton("Start");
	rules = new JButton("Rules");
	options = new JButton("Options");
	exit = new JButton("Exit");
	
	JLabel titlelabel = new JLabel("Brick Breaker");
	
	panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
	panel.setBackground(Color.black);
	title.setBackground(Color.black);
	
	start.setForeground(Color.black);
	start.setBackground(Color.red);
	start.setPreferredSize(new Dimension(250,100));
	start.setFont(other);
	start.addActionListener(this);
	
	rules.setForeground(Color.black);
	rules.setBackground(Color.green);
	rules.setPreferredSize(new Dimension(250,100));
	rules.setFont(other);
	rules.addActionListener(this);
	
	options.setForeground(Color.black);
	options.setBackground(Color.yellow);
	options.setPreferredSize(new Dimension(250,100));
	options.setFont(other);
	options.addActionListener(this);
	
	exit.setForeground(Color.black);
	exit.setBackground(Color.cyan);
	exit.setSize(new Dimension(250,100));
	exit.setFont(other);
	exit.addActionListener(this);
	titlelabel.setFont(titleFont); 
	titlelabel.setForeground(Color.red);
	add(title,BorderLayout.PAGE_START);
	add(panel);

	panel.add(Box.createRigidArea(new Dimension(100,10)));
	panel.add(start);
	
	panel.add(Box.createRigidArea(new Dimension(100,50)));
	panel.add(rules);
	
	panel.add(Box.createRigidArea(new Dimension(100,50)));
	panel.add(options);
	
	panel.add(Box.createRigidArea(new Dimension(100,50)));
	panel.add(exit);	
		
	panel.add(Box.createRigidArea(new Dimension(100,50)));
	title.add(titlelabel);		
	
	panel.add(Box.createRigidArea(new Dimension(100,100)));
	
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
	if (e.getSource() == start)
        {
            
            gameFrame = new GameFrame("Brick Breaker");
            gameFrame.run();
            
            this.setVisible(false);
            this.dispose();
            
	} else if (e.getSource() == rules) {
	
            setVisible(false);
            rulesFrame rules = new rulesFrame();
            
	} else if(e.getSource() == options) {
            
            // TODO: Add options screen
            
	} else if (e.getSource() == exit) {
            
            System.exit(0);
            
	}
	
    }

}
