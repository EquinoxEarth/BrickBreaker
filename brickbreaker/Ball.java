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
    public int x;
	
    /**
     * Y Coordinate of the ball
     */
    public int y;
	
    /**
     * Radius of the ball
     */
    public int radius;
	
    /**
     * X Speed of the ball
     */
    public int xSpeed;
	
    /**
     * Y Speed of the ball
     */
    public int ySpeed;
    
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
	
}
