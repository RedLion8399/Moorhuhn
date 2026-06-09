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
        getBackground().scale(getWidth(), getHeight());
        chickenAmount = 0;

        crosshair = new Crosshair(this);
        addObject(crosshair, getWidth() / 2, getHeight() / 2);
    }

    /**
     * The act method is the anchor for the game loop which calls it on every
     * frame. It controls the spawning of the targets and the crosshair.
     */
    public void act() {
        spawnChicken();
    }

    /**
     * Spawns a Chicken in the world based on a probability that depends on the
     * current number of chickens. The maximum number of chickens is limited to
     * 5.
     */
    public void spawnChicken() {
        if (Greenfoot.getRandomNumber(750) < 2 * (5 - chickenAmount)) {
            chickenAmount++;
            new Chicken(this);
        }
    }

    /**
     * The decreaseChickenAmount method decreases the chicken counter by one.
     */
    public void decreaseChickenAmount() {
        chickenAmount--;
    }
}