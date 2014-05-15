/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brickbreaker;

import static brickbreaker.BrickBreaker.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;


/**
 * The frame that the game is rendered in
 * @author Cole
 */
public class GameFrame extends JFrame implements KeyListener {
    
    /**
     * The minimum an X value can be
     */
    private final static int xMin = 20;
    
    /**
     * The maximum an X value can be
     */
    private final static int xMax = 430;
    
    /**
     * The minimum a Y value can be
     */
    private final static int yMin = 40;
    
    /**
     * The maximum a Y value can be
     */
    private final static int yMax = 640;
    
    public GameFrame() {
		
        setSize(450,660);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.black);
        setLocationRelativeTo(null);
        addKeyListener(this);
		
    }
    
    @Override
    public void paint(Graphics g) {
        
        // Clear the playing field
        g.setColor(Color.black);
        g.fillRect(xMin + 1, yMin + 1, (xMax - 1) - xMin, (yMax - 1) - yMin);
        
        //g.fillOval(ball.getX()-ball.getRadius()/2, ball.getY()-ball.getRadius()/2, ball.getRadius() * 2, ball.getRadius() * 2);
        
        // TODO: Draw the bricks
        
        // Set the color to white
        g.setColor(Color.white);
        
        // Horizontal Lines
        g.drawLine(xMin, yMin, xMax, yMin);
        g.drawLine(xMin, yMax, xMax, yMax);
        
        // Vertical Lines
        g.drawLine(xMin, yMin, xMin, yMax);
        g.drawLine(xMax, yMin, xMax, yMax);
        
        // Draw the ball
        g.setColor(Color.red);
        g.fillOval(ball.getX(), ball.getY(), ball.getRadius(), ball.getRadius());
        
        // Outline the ball in white
        g.setColor(Color.white);
        g.drawOval(ball.getX(), ball.getY(), ball.getRadius(), ball.getRadius());
        
        // Draw the paddle
        g.fillRect(paddle.x, yMax - 40, paddle.width, paddle.height);
        
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

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        // Left Arrow
        if (e.getKeyCode() == 37)
        {
            if ((paddle.x + paddle.width / 2) < xMax && (paddle.x - paddle.width / 2) > (xMin - 50))
            {
                
                paddle.x -= 5;
                
            } else {
                
                return;
                
            }
            
        } else if (e.getKeyCode() == 39) {  // Right Arrow
            
            if ((paddle.x - paddle.width / 2) > (xMin - 50) && (paddle.x + paddle.width / 2) < xMax)
            {
                
                paddle.x += 5;
                
            } else {
                
                return;
                
            }
            
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}