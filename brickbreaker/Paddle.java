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
    public int x;
    
    /**
     * The width of the paddle
     */
    public int width;
    
    /**
     * The height of the paddle
     */
    public int height;
    
    /**
     * Holds whether or not the paddle is sticky
     */
    public boolean sticky = false;
    
    /**
     * Speed that the paddle moves at
     */
    public int speed;
    
    /**
     * Creates a Paddle with the supplied width & height
     * @param width 
     * @param height 
     */
    public Paddle(int width, int height) {
        
        this.width = width;
        this.height = height;
        
    }
    
}
