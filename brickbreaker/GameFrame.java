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
        
        g.setColor(Color.white);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        
        g.setColor(Color.black);
        
        // Horizontal Lines
        g.drawLine(xMin, yMin, xMax, yMin);
        g.drawLine(xMin, yMax, xMax, yMax);
        
        // Vertical Lines
        g.drawLine(xMin, yMin, xMin, yMax);
        g.drawLine(xMax, yMin, xMax, yMax);
        
        // Draw the ball
        g.setColor(Color.red);
        g.fillOval(ball.getX(), ball.getY(), ball.getRadius(), ball.getRadius());
        
        // Outline the ball in black
        g.setColor(Color.black);
        g.drawOval(ball.getX(), ball.getY(), ball.getRadius(), ball.getRadius());
        
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
