/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brickbreaker.game;

import java.util.Random;

import brickbreaker.game.items.Brick;

/**
 *
 * @author Cole
 */
public class GameLevel {
    
    public static Brick [] brickList;
    
    public static int [] xPos = {48, 136, 224, 312, 400, 488, 576, 664, 752, 840};
    public static int [] yPos = {70, 120, 170, 220};
    
    public static void changeLevel(int level) {
        
        // Which level are we at?
        if (level == 1)
        {
            
            int row = 0;
            int column = 0;
            
            // TODO: Code Levels
            Brick[] bricks = new Brick[40];
            for (int i = 0; i < bricks.length; i++)
            {
                
                double rand = 1 + (int)(Math.random() * ((3 - 1) + 1));
                
                bricks[i] = new Brick(xPos[row], yPos[column]);
                bricks[i].setHealth((int)rand);
                row++;
                
                if (row == 10) { row = 0; column++; }
                
            }
            
            brickList = bricks;
        } else if (level == 2) { //generates the second level
            int row = 0;
            int column = 0;
            
            Brick[] bricks = new Brick[40];
            for (int i = 0; i < bricks.length; i++)
            {
                double rand = 1 + (int)(Math.random() * ((6 - 1) + 1));
                
                bricks[i] = new Brick(xPos[row], yPos[column]);
                bricks[i].setHealth((int)rand);
                row++;
                
                if (row == 10) { row = 0; column++; }
                
            }
            
            brickList = bricks;
        } else throw new NullPointerException(); //throws an exception if you pass the max level count
    }
}
