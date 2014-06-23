/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brickbreaker.game;

import brickbreaker.game.items.Ball;
import brickbreaker.game.items.Brick;
import brickbreaker.game.items.Paddle;
import brickbreaker.menu.menuSummary;
import javax.swing.JOptionPane;

/**
 *
 * @author Cole
 */
public class Game {
    
    /** The Frame for the game */
    public static GameFrame gameFrame;
    
    /** True if the game is paused */
    public static boolean paused = false;
    
    /** Current Score */
    public static long score = 0;
    
    /** Current level of the game */
    public static int level = 1;
    
    /** The players name */
    public static String player = null;
    
    /** Sets the speed of the game */
    public static int difficulty = 3;
    
    /** Time that the level is played */
    public static int time = 0;
    
    /** The ball that is used in the game */
    public static Ball ball = new Ball(320, 240, 10, 0);
    public static Ball[] ballArray = new Ball[1];
    
    /** The amount of lives the player has */
    public static int lives = 3;
    
    /** The Panel for the game */
    public static final GamePanel game = new GamePanel();
    
    /** The paddle that is used in the game*/
    public static Paddle paddle = new Paddle(125, 10);
    
    /** Total Score */
    public static long totalScore = 0;
    
    /** True if the level is done */
    public static boolean levelDone = false;

    /** Runs the game */
    public static void runGame() {
        
        // Poll for the player name
        player = JOptionPane.showInputDialog("Enter your name");
        if (player == null || player.equals("")) {
            player = "Player";
        }
        
        gameFrame = new GameFrame(game);
        ballArray[0] = new Ball(0, 0, 20, 0);
        paddle.setX((gameFrame.getWidth() / 2) - (paddle.getWidth() / 2));
        GameLevel.changeLevel(level);
        
        Thread gameThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    
                    if (!paused)
                    {
                        
                        ball.setX(ball.getX() + ball.getXSpeed());
                        ball.setY(ball.getY() + ball.getYSpeed());
                        checkLines(ball);
                        checkPaddle(ball);
                        checkBricks(ball);
                        
                    }
                    
                    Sleep(difficulty);
                    
                }
            }
        });
        
        Thread drawThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    
                    game.repaint();
                    
                }
            }
        });
        
        Thread timeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    
                    Sleep(1000);
                    
                    if (!paused)
                        time++;
                    
                }
            }
        });
        
        gameThread.start();
        drawThread.start();
        timeThread.start();
    }

    /**
     * Checks if a powerup should spawn or not
     * @param brick the brick that was hit
     */
    public static void spawnPowerup(Brick brick) {
        
        int rand = 1 + (int) (Math.random() * ((10 - 1) + 1));
        
        if (rand == 1) {
            
            rand = 1 + (int) (Math.random() * ((100 - 1) + 1));
            
            if (rand >= 1 && rand <= 20) {
            } else if (rand >= 21 && rand <= 40) {
            } else if (rand >= 41 && rand <= 60) {
            } else if (rand >= 61 && rand <= 80) {
            } else if (rand >= 81 && rand <= 100) {
            }
        }
    }

    /**
     * Check if the ball has hit the paddle
     * @param ball the ball in question
     */
    public static void checkPaddle(Ball ball) {
        
        if (ball.getBottom() == GameFrame.yMax - 60 - paddle.getHeight() / 2) {
            
            if (ball.getRight() >= paddle.getLeft() && ball.getLeft() <= paddle.getRight()) {
                
                if (ball.getX() < paddle.getX() + 8 - 7) {
                    
                    if (ball.getX() < paddle.getX() + 8 - 35) {
                        
                        ball.setXSpeed(-2);
                        
                    } else {
                        
                        ball.setXSpeed(-1);
                        
                    }
                    
                } else if (ball.getX() > paddle.getX() + 8 + 7) {
                    
                    if (ball.getX() > paddle.getX() + 8 + 35) {
                        
                        ball.setXSpeed(2);
                        
                    } else {
                        
                        ball.setXSpeed(1);
                        
                    }
                    
                } else {
                    
                    ball.setXSpeed(0);
                    
                }
                
                ball.setYSpeed(-(ball.getYSpeed()));
            }
        }
    }

    /**
     * Checks if the ball has hit the walls of the playing field
     * @param ball is the ball that is checked
     */
    public static void checkLines(Ball ball) {
        
        if (ball.getLeft() <= GameFrame.xMin) {
            
            ball.setXSpeed(-(ball.getXSpeed()));
            
        }
        if (ball.getRight() >= GameFrame.xMax) {
            
            ball.setXSpeed(-(ball.getXSpeed()));
            
        }
        if (ball.getTop() <= GameFrame.yMin) {
            
            ball.setYSpeed(-(ball.getYSpeed()));
            
        }
        if (ball.getTop() >= GameFrame.yMax) {
            
            lives -= 1;
            if (lives == 0) {
                
                JOptionPane.showMessageDialog(gameFrame, "Game over!", "Brick Breaker", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
                
            } else {
                
                JOptionPane.showMessageDialog(gameFrame, "Try Again", "Brick Breaker", JOptionPane.ERROR_MESSAGE);
                resetBall(ball);
                
            }
        }
    }

    /**
     * Checks if a brick has been hit
     * @param ball the ball in question
     */
    public static void checkBricks(Ball ball) {
        
        int count = 0;
        boolean noLevels = false;
        for (Brick curBrick : GameLevel.brickList) {
            
            if (curBrick.Collide(ball)) {
                
                score += 50 * (curBrick.getHealth() + 1);
                totalScore += 50 * (curBrick.getHealth() + 1);
                spawnPowerup(curBrick);
                
            }
            if (curBrick.isDestroyed()) {
                
                count++;
                
            }
        }
        if (count == GameLevel.brickList.length && !levelDone) {
            
            JOptionPane.showMessageDialog(gameFrame, "Level Complete!");
            level++;
            resetBall(ball);
            gameFrame.setEnabled(false);
            new menuSummary(level, score, totalScore, GameLevel.brickList.length, time, noLevels);
            levelDone = true;
            score = 0;
            
        }
    }

    /**
     * Resets the ball back to it's origin
     * @param ball
     */
    public static void resetBall(Ball ball) {
        
        paddle.setX((gameFrame.getWidth() / 2) - (paddle.getWidth() / 2));
        ball.setX(paddle.getX() + 10);
        ball.setY(GameFrame.yMax - 75 - paddle.getHeight() / 2);
        ball.setXSpeed(0);
        ball.setYSpeed(0);
        ball.setLaunched(false);
        
    }

    /**
     * Sleeps the thread for the defined amount of ms
     * @param ms
     */
    public static void Sleep(int ms) {
        
        try {
            
            Thread.sleep(ms);
            
        } catch (InterruptedException e) {
            
            e.printStackTrace();
            
        }
        
    }
    
}
