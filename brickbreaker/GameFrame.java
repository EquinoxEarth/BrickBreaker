/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brickbreaker;

import java.awt.*;
import javax.swing.*;

import static brickbreaker.BrickBreaker.*;

/**
 * The frame that the game is rendered in
 * @author Cole
 */
public class GameFrame extends JFrame {
    
    /**
     * The minimum an X value can be
     */
    private final static int xMin = 20;
    
    /**
     * The maximum an X value can be
     */
    private final static int xMax = 620;
    
    /**
     * The minimum a Y value can be
     */
    private final static int yMin = 40;
    
    /**
     * The maximum a Y value can be
     */
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
        
        Sleep(50);
        
        g.setColor(Color.white);
        g.drawOval(ball.x, ball.y, ball.radius, ball.radius);
        g.fillOval(ball.x, ball.y, ball.radius, ball.radius);
        
    }
    
    /**
     * Get the minimum X value
     * @return xMin
     */
    public int getXmin() {
        
        return xMin;
        
    }
    
    /**
     * Get the maximum X value
     * @return xMax
     */
    public int getXmax() {
        
        return xMax;
        
    }
    
    /**
     * Get the minimum Y value
     * @return yMin
     */
    public int getYmin() {
        
        return yMin;
        
    }
    
    /**
     * Get the maximum Y value
     * @return yMax
     */
    public int getYmax() {
        
        return yMax;
        
    }
    
}
