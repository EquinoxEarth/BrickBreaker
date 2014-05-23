/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brickbreaker.game;

import brickbreaker.items.*;
import brickbreaker.powerups.*;
import static brickbreaker.game.GameFrame.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.event.MouseInputListener;


/**
 * The frame that the game is rendered in
 * @author Cole
 */
public class GamePanel extends JPanel implements KeyListener, MouseInputListener {
    
    public GamePanel() {
		
        //setSize(450,660);
        //setBounds(0, 0, 450, 660);
        setBackground(Color.black);
        addKeyListener(this);
        addMouseMotionListener(this);
        setFocusable(true);
        setCursor(this.getToolkit().createCustomCursor(
            new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0),
            "null"));
        
    }
    
    @Override
    public void paint(Graphics g) {
        
        // Set the color to the background color
        g.setColor(Color.black);
        
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
                
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
        g.drawOval(ball.getX(), ball.getY(), ball.getRadius(), ball.getRadius());
        
        // Draw the paddle
        g.fillRect(paddle.getLeft(), yMax - 60, paddle.getWidth(), paddle.getHeight());
        
        g.drawString("Lives:" + lives, 10, 20);
        
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
            if (paddle.getLeft() > 0)
            {
                
                paddle.setX(paddle.getX() - 5);
                
            } else {
                
                return;
                
            }
            
        } else if (e.getKeyCode() == 39) {  // Right Arrow
            
            if (paddle.getRight() < xMax)
            {
                
                paddle.setX(paddle.getX() + 5);
                
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
        
        paddle.setX(e.getX());
        
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