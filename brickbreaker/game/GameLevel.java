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
    
    public static int [] xPos = new int[] {48, 136, 224, 312, 400, 488, 576, 664, 752, 840};
    public static int [] yPos = new int[] {};
    
    public static void changeLevel(int level) {
        
        // Which level are we at?
        if (level == 1)
        {
            
            // TODO: Code Levels
            Brick[] bricks = new Brick[10];
            for (int i = 0; i < bricks.length; i++)
            {
                
                double rand = 1 + (int)(Math.random() * ((3 - 1) + 1));
                
                bricks[i] = new Brick(xPos[i], 100);
                bricks[i].setHealth((int)rand);
                
            }
            
            brickList = bricks;
            
        }
        
    }
    
    public static void setupBricks(Brick [] brickArray) {
        
        int x = 200;
        int y = 200;
        
        for (int i = 1; i < brickArray.length; i++)
        {
            
            brickArray[i].setX(x);
            brickArray[i].setY(y);
            x++;
            y++;
            
        }
        
    }
    
}
