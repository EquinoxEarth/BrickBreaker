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
    public static int width = 80;
    
    /**
     * Height of the brick
     */
    public static int height = 25;
    
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
        
        this.x = x;
        this.y = y;
        
        this.destroyed = false;
        
    }
    
    /**
     * Returns the health of the brick
     * @return 
     */
    public int getHealth() { return this.health; }
    
    public void setHealth(int health) { this.health = health; }
    
    /**
     * Sets the health of the brick
     */
    public void decHealth() { this.health -= 1; }
    
    /**
     * Returns the X coordinate of the brick
     * @return 
     */
    public int getX() { return this.x; }
    
    /**
     * Sets the X coordinate of the brick
     * @param x 
     */
    public void setX(int x) { this.x = x; }
    
    /**
     * Returns the Y coordinate of the brick
     * @return 
     */
    public int getY() { return this.y; }
    
    /**
     * Sets the Y coordinate of the brick
     * @param y 
     */
    public void setY(int y) { this.y = y; }
    
    public void setDimensions(int srcWidth, int srcHeight) {
        
        width = srcWidth;
        height = srcHeight;
        
    }
    
    /**
     * Return the left side of the brick
     * @return 
     */
    public int getLeft() { return (this.x - (width / 2)); }
    
    /**
     * Return the Right side of the brick
     * @return 
     */
    public int getRight() { return (this.x + (width / 2)); }
    
    /**
     * Return the Top side of the brick
     * @return 
     */
    public int getTop() { return (this.y - (height / 2)); }
    
    /**
     * Return the Bottom side of the brick
     * @return 
     */
    public int getBottom() { return (this.y + (height / 2)); }
    
    /**
     * Returns the Color of the brick
     * @return 
     */
    public Color getColor() {
        
        // We need to check what the health of the brick is
        if (this.health == 1) return Color.red;
        else if (this.health == 2) return Color.orange;
        else if (this.health == 3) return Color.yellow;
        else if (this.health == 4) return Color.green;
        else if (this.health == 5) return Color.blue;
        else if (this.health == 6) return Color.magenta;
        else return Color.gray;
        
    }
    
    public void Destroy() { this.destroyed = true; }
    
    public boolean isDestroyed() { return this.destroyed; }
    
    public boolean Collide(Ball ball) {
        
        if (!this.isDestroyed())
        {
            /*if (ball.getY() <= this.getBottom() && ball.getY() >= this.getTop())            
            {
                
                if (ball.getRight() == this.getLeft() || ball.getLeft() == this.getRight())
                {
                    
                    ball.setXSpeed(-ball.getXSpeed());
                    this.health -= 1;
                    if (this.health == 0) this.Destroy();
                    
                    return true;
                    
                }
                
            } else if (ball.getTop() == this.getBottom() || ball.getBottom() == this.getTop()) {
                
                if (ball.getX() >= this.getLeft() && ball.getX() <= this.getRight())
                {
                    
                    ball.setYSpeed(-ball.getYSpeed());
                    this.health -= 1;
                    if (this.health == 0) this.Destroy();
                    
                    return true;
                    
                }
                
            }*/
            
            if (ball.getRight() == this.getLeft() || ball.getLeft() == this.getRight())            
            {
                
                for (int i = this.getTop(); i <= this.getBottom(); i++)
                {
                      
                    if (ball.getY() == i)
                    {
                        
                        ball.setXSpeed(-ball.getXSpeed());
                        this.health--;
                        if (this.health == 0) this.Destroy();
                        
                        return true;
                        
                    }
                      
                }
                
            } else if (ball.getTop() == this.getBottom() || ball.getBottom() == this.getTop()) {
                
                for (int i = this.getLeft(); i <= this.getRight(); i++)
                {
                    
                    if (ball.getX() == i)
                    {
                        ball.setYSpeed(-ball.getYSpeed());
                        this.health--;
                        if (this.health == 0) this.Destroy();
                        
                    }
                    
                }
                
            }
                
        }
        
        return false;
        
    }
    
}