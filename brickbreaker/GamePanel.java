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
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.event.MouseInputListener;


/**
 * The frame that the game is rendered in
 * @author Cole
 */
public class GamePanel extends JPanel implements KeyListener, MouseInputListener {
    
    /**
     * The minimum an X value can be
     */
    private final int xMin = 0;
    
    /**
     * The maximum an X value can be
     */
    private final int xMax = 580;
    
    /**
     * The minimum a Y value can be
     */
    private final int yMin = 40;
    
    /**
     * The maximum a Y value can be
     */
    private final int yMax = 660;
    
    public GamePanel() {
		
        //setSize(450,660);
        //setBounds(0, 0, 450, 660);
        setBackground(Color.black);
        addKeyListener(this);
        addMouseMotionListener(this);
        setFocusable(true);
        
    }
    
    @Override
    public void paint(Graphics g) {
        
        // Set the color to the background color
        g.setColor(Color.black);
        
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        
        // Clear the area around the paddle
        //g.fillRect(xMin + 1, yMin + 1, (xMax - 1) - xMin, (yMax - 1) - yMin);
        
        // Clear the area around the ball
        //g.fillOval(ball.getX()-ball.getRadius()/2, ball.getY()-ball.getRadius()/2, ball.getRadius() * 2, ball.getRadius() * 2);
        
        // TODO: Draw the bricks
        
        // Set the color to white
        g.setColor(Color.white);
        
        // Horizontal Lines
        g.drawLine(xMin, yMin, xMax, yMin);
        
        // Draw the ball
        g.setColor(Color.red);
        g.fillOval(ball.getX(), ball.getY(), ball.getRadius(), ball.getRadius());
        
        // Outline the ball in white
        g.setColor(Color.white);
        //g.drawOval(ball.getX(), ball.getY(), ball.getRadius(), ball.getRadius());
        
        // Draw the paddle
        g.fillRect(paddle.x, yMax - 60, paddle.width, paddle.height);
        
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
    public void keyPressed(KeyEvent e) {
        
        // Left Arrow
        if (e.getKeyCode() == 37)
        {
            if ((paddle.x + paddle.width / 2) > 0)
            {
                
                paddle.x -= 5;
                
            } else {
                
                return;
                
            }
            
        } else if (e.getKeyCode() == 39) {  // Right Arrow
            
            if ((paddle.x - paddle.width / 2) < xMax)
            {
                
                paddle.x += 5;
                
            } else {
                
                return;
                
            }
            
        }
        
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        // TODO: Launch ball
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
        paddle.x = e.getX() - (paddle.width / 2);
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }
    
}