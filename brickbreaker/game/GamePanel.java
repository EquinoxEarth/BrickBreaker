/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brickbreaker.game;

import static brickbreaker.game.GameFrame.*;
import brickbreaker.game.items.Brick;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.event.MouseInputListener;


/**
 * The frame that the game is rendered in
 * @author Cole
 */
public class GamePanel extends JPanel implements MouseInputListener {
    
    public GamePanel() {
		
        //setSize(450,660);
        //setBounds(0, 0, 450, 660);
        setBackground(Color.black);
        addMouseMotionListener(this);
        addMouseListener(this);
        setFocusable(true);
        setCursor(this.getToolkit().createCustomCursor(
            new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0),
            "null"));
        
    }
    
    @Override
    public void paint(Graphics g) {
        
        // Clear the Screen
        g.setColor(Color.black);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        
        for (Brick brickList : GameLevel.brickList) {
            
            if (!brickList.isDestroyed())
            {
                
                g.setColor(brickList.getColor());
                g.fillRect(brickList.getLeft(), brickList.getTop(), Brick.width, Brick.height);
                
            }
            
        }
        
        // Set the color to white
        g.setColor(Color.white);
        
        // Horizontal Line
        g.drawLine(xMin, yMin, xMax, yMin);
        
        // Draw the ball
        g.setColor(Color.red);
        g.fillOval(ball.getX() - ball.getRadius(), ball.getY() - ball.getRadius(), ball.getRadius(), ball.getRadius());
        g.drawOval(ball.getX() - ball.getRadius(), ball.getY() - ball.getRadius(), ball.getRadius(), ball.getRadius());
        
        // Outline the ball in white
        g.setColor(Color.white);
        
        // Draw the paddle
        g.fillRect(paddle.getLeft(), yMax - 60, paddle.getWidth(), paddle.getHeight());
        
        // Draw Lives
        g.drawString("Lives:" + lives, 10, 25);
        
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        // TODO: Launch ball
        if (!ball.isLaunched())
        {
            
            ball.setXSpeed(1);
            ball.setYSpeed(1);
            ball.setLaunched(true);
            
        }
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
        if (!ball.isLaunched())
        {
            
            ball.setX(e.getX());
            ball.setY(yMax - 65);
            
        }
        
        paddle.setX(e.getX());
        
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