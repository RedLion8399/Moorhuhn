import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The GameWorld class is the world in which the game takes place.
 * It innitializes all objects needed in the world and controls them.
 * 
 * @author Paul Jonas Dohle
 * @version 0.1.0
 */
public class GameWorld extends World {
    private int chickenAmount;
    private Crosshair crosshair;

    /**
     * Constructor for objects of class GameWorld.
     * It creates a GameWorld object with certain dimensions and a certain cell
     * size. It creates references to other objects that are needed in the
     * world.
     */
    public GameWorld() {
        super(600, 400, 1, false);
    }

    /**
     * The act method is the anchor for the game loop which calls it on every
     * frame. It controls the spawning of the targets and the crosshair.
     */
    public void act() {
    }

    /**
     * The spawnHuhn method controls the spawning of the targets. It is called
     * in the act method. It spawns chickens in the world with a certain
     * probability based on the number of chickens currently in the world. The
     * more chickens are currently in the world the lower the probability of
     * spawning a new chicken.
     * The method also increases the chicken counter by one when a new chicken
     * is spawned.
     */
    public void spawnHuhn() {
    }
}