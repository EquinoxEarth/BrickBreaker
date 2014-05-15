/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brickbreaker;

import java.awt.*;

/**
 * The brick object
 * @author Cole
 */
public class Brick extends Rectangle {
    
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
    private double x;
    
    /**
     * The Y coordinate of the brick
     */
    private double y;
    
    /**
     * Width of the brick
     */
    public final static double width = 15;
    
    /**
     * Height of the brick
     */
    public final static double height = 5;
    
    /**
     * Creates a brick at the specified coordinates
     * @param x
     * @param y 
     */
    public Brick(int x, int y) {
        
        //TODO: Code constructor
        
    }
    
    /**
     * Returns the health of the brick
     * @return 
     */
    public int getHealth() {
        
        return this.health;
        
    }
    
    /**
     * Sets the health of the brick
     * @param hp 
     */
    public void setHealth(int hp) {
        
        this.health = hp;
        
    }
    
    /**
     * Returns the X coordinate of the brick
     * @return 
     */
    @Override
    public double getX() {
        
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
    @Override
    public double getY() {
        
        return this.y;
        
    }
    
    /**
     * Sets the Y coordinate of the brick
     * @param y 
     */
    public void setY(int y) {
        
        this.y = y;
        
    }
    
    /**
     * Returns the Color of the brick
     * @return 
     */
    public Color getColor() {
        
        return this.color;
        
    }
    
    /**
     * Sets the Color of the brick
     * @param color 
     */
    public void setColor(Color color) {
        
        this.color = color;
        
    }
    
    public boolean checkCollision(Ball ball) {
        
        // TODO: Code collision for brick
        
        return true;
        
    }
    
}
