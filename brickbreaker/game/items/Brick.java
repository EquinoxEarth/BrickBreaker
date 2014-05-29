/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brickbreaker.game.items;

import java.awt.*;

/**
 * The brick object
 * @author Cole
 */
public class Brick {
    
    /**
     * Hit points left on the brick
     */
    private int health;
    
    /**
     * Color of the brick
     */
    private Color color;
    
    /**
     * The X coordinate of the brick
     */
    private int x;
    
    /**
     * The Y coordinate of the brick
     */
    private int y;
    
    /**
     * Width of the brick
     */
    public static int width = 100;
    
    /**
     * Height of the brick
     */
    public static int height = 10;
    
    /**
     * True if the brick has been destroyed
     */
    private boolean destroyed;
    
    /**
     * Creates a brick at the specified coordinates
     * @param x
     * @param y 
     */
    public Brick(int x, int y) {
        
        //TODO: Code constructor
        this.x = x;
        this.y = y;
        
        this.destroyed = false;
        
    }
    
    /**
     * Returns the health of the brick
     * @return 
     */
    public int getHealth() {
        
        return this.health;
        
    }
    
    public void setHealth(int health) {
        
        this.health = health;
        
    }
    
    /**
     * Sets the health of the brick
     */
    public void decHealth() {
        
        this.health -= 1;
        
    }
    
    /**
     * Returns the X coordinate of the brick
     * @return 
     */
    public int getX() {
        
        return this.x;
        
    }
    
    /**
     * Sets the X coordinate of the brick
     * @param x 
     */
    public void setX(int x) {
        
        this.x = x;
        
    }
    
    /**
     * Returns the Y coordinate of the brick
     * @return 
     */
    public int getY() {
        
        return this.y;
        
    }
    
    /**
     * Sets the Y coordinate of the brick
     * @param y 
     */
    public void setY(int y) {
        
        this.y = y;
        
    }
    
    public void setDimensions(int srcWidth, int srcHeight) {
        
        width = srcWidth;
        height = srcHeight;
        
    }
    
    public int getLeft() {
        
        return (this.x - (width / 2));
        
    }
    
    public int getRight() {
        
        return (this.x + (width / 2));
        
    }
    
    public int getTop() {
        
        return (this.y - (height / 2));
        
    }
    
    public int getBottom() {
        
        return (this.y + (height / 2));
        
    }
    
    /**
     * Returns the Color of the brick
     * @return 
     */
    public Color getColor() {
        
        // We need to check what the health of the brick is
        if (this.health == 1)
        {
            
            return Color.red;
            
        } else if (this.health == 2) {
            
            return Color.orange;
            
        } else if (this.health == 3) {
            
            return Color.yellow;
            
        } else {
            
            return Color.gray;
            
        }
        
    }
    
    public void Destroy() {
        
        this.destroyed = true;
        
    }
    
    public boolean isDestroyed() {
        
        return this.destroyed;
        
    }
    
    public void checkCollision(Ball ball) {
        
        if (!this.isDestroyed())
        {
            
            if (ball.getRight() == this.getLeft() || ball.getLeft() == this.getRight())
            {
                
                if (ball.getY() <= this.getBottom() && ball.getY() >= this.getTop())
                {
                    
                    ball.setXSpeed(-ball.getXSpeed());
                    
                    this.health -= 1;
                    
                    if (this.health == 0)
                    {
                        
                        this.Destroy();
                        
                    }
                    
                }
                
            } else if (ball.getTop() == this.getBottom() || ball.getBottom() == this.getTop()) {
                
                if (ball.getX() >= this.getLeft() && ball.getX() <= this.getRight())
                {
                    
                    ball.setYSpeed(-ball.getYSpeed());
                    
                    this.health -= 1;
                    
                    if (this.health == 0)
                    {
                        
                        this.Destroy();
                        
                    }
                    
                }
                
            }
                
        }
        
    }
    
}