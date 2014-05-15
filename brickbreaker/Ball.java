/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brickbreaker;

public class Ball {
	
    /**
     * X Coordinate of the ball
     */
    private int x;
	
    /**
     * Y Coordinate of the ball
     */
    private int y;
	
    /**
     * Radius of the ball
     */
    private int radius;
	
    /**
     * X Speed of the ball
     */
    private int xSpeed;
	
    /**
     * Y Speed of the ball
     */
    private int ySpeed;
    
    /**
     * Create a ball with the defined field values
     * @param x is the x position
     * @param y is the y position
     * @param radius is the radius of the circle
     * @param speed is the speed at which it moves
     */
    public Ball(int x, int y, int radius, int speed) {
		
        this.x = x;
	this.y = y;
	this.radius = radius;
	this.xSpeed = speed;
	this.ySpeed = speed;
	
    }
    
    /**
     * Returns the balls X coordinate
     * @return 
     */
    public int getX() {
        
        return this.x;
        
    }
    
    /**
     * Sets the balls X coordinate
     * @param x 
     */
    public void setX(int x) {
        
        this.x = x;
        
    }
    
    /**
     * Returns the balls Y coordinate
     * @return 
     */
    public int getY() {
        
        return this.y;
        
    }
    
    /**
     * Sets the balls Y coordinate
     * @param y 
     */
    public void setY(int y) {
        
        this.y = y;
        
    }
    
    /**
     * Returns the balls radius
     * @return 
     */
    public int getRadius() {
        
        return this.radius;
        
    }
    
    /**
     * Sets the balls radius
     * @param radius 
     */
    public void setRadius(int radius) {
        
        this.radius = radius;
        
    }
    
    /**
     * Returns the balls X Speed factor
     * @return 
     */
    public int getXSpeed() {
        
        return this.xSpeed;
        
    }
    
    /**
     * Sets the balls X Speed factor
     * @param speed 
     */
    public void setXSpeed(int speed) {
        
        this.xSpeed = speed;
        
    }
    
    /**
     * Returns the balls Y Speed factor
     * @return 
     */
    public int getYSpeed() {
        
        return this.ySpeed;
        
    }
    
    /**
     * Sets the balls Y Speed factor
     * @param speed 
     */
    public void setYSpeed(int speed) {
        
        this.ySpeed = speed;
        
    }
	
}