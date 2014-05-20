/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brickbreaker;

/**
 * The paddle used to hit the ball
 * @author Cole
 */
public class Paddle {
    
    /**
     * The X coordinate of the paddle
     */
    private int x;
    
    /**
     * The width of the paddle
     */
    private int width;
    
    /**
     * The height of the paddle
     */
    private int height;
    
    /**
     * Holds whether or not the paddle is sticky
     */
    private boolean sticky = false;
    
    /**
     * Speed that the paddle moves at
     */
    private int speed;
    
    /**
     * Creates a Paddle with the supplied width & height
     * @param width 
     * @param height 
     */
    public Paddle(int width, int height) {
        
        this.width = width;
        this.height = height;
        
    }
    
    public int getX() {
        
        return this.x;
        
    }
    
    public void setX(int x) {
        
        this.x = x;
        
    }
    
    public int getWidth() {
        
        return this.width;
        
    }
    
    public void setWidth(int width) {
        
        this.width = width;
        
    }
    
    public int getHeight() {
        
        return this.height;
        
    }
    
    public void setHeight(int height) {
        
        this.height = height;
        
    }
    
    public int getLeft() {
        
        return this.x - (this.width / 2);
        
    }
    
    public int getRight() {
        
        return this.x + (this.width / 2);
        
    }
    
}
