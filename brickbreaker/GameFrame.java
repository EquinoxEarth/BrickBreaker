/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brickbreaker;

import java.awt.*;
import javax.swing.*;

import static brickbreaker.BrickBreaker.ball;

public class GameFrame extends JFrame {
    
    private final static int xMin = 20;
    private final static int xMax = 620;
    
    private final static int yMin = 40;
    private final static int yMax = 460;
	
    public GameFrame() {
		
        setSize(640,480);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.white);
        setLocationRelativeTo(null);
        setVisible(true);
		
    }
    
    @Override
    public void paint(Graphics g) {
        
        // Horizontal Lines
        g.drawLine(xMin, yMin, xMax, yMin);
        g.drawLine(xMin, yMax, xMax, yMax);
        
        // Vertical Lines
        g.drawLine(xMin, yMin, xMin, yMax);
        g.drawLine(xMax, yMin, xMax, yMax);
        
        g.setColor(Color.red);
        g.drawOval(ball.x, ball.y, ball.radius, ball.radius);
        g.fillOval(ball.x, ball.y, ball.radius, ball.radius);
        
        try {
            
            Thread.sleep(50);
            
        } catch (InterruptedException e) {
            
            e.printStackTrace();
            
        }
        
        g.setColor(Color.white);
        g.drawOval(ball.x, ball.y, ball.radius, ball.radius);
        g.fillOval(ball.x, ball.y, ball.radius, ball.radius);
        
    }
    
    public int getXmin() {
        
        return xMin;
        
    }
    
    public int getXmax() {
        
        return xMax;
        
    }
    
    public int getYmin() {
        
        return yMin;
        
    }
    
    public int getYmax() {
        
        return yMax;
        
    }
    
}
