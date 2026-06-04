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
    }

    /**
     * The act method is the anchor for the game loop which calls it on every
     * frame. It controls the spawning of the targets and the crosshair.
     */
    public void act() {
        spawnChicken();
    }

    /**
     * The spawnChicken method controls the spawning of the Chickens. It is
     * called in the act method. It spawns chickens in the world with a
     * certain probability based on the number of chickens currently in the
     * world. The more chickens are currently in the world the lower the
     * probability of spawning a new chicken. The maximum number of chickens
     * in the world is 5. they are by random spawned facing left or right and at
     * a random height. 30 pixels are reserved at the top and bottom of the
     * world to prevent the chickens from being spawned too close to the edge of
     * the world.
     */
    public void spawnChicken() {
        if (Greenfoot.getRandomNumber(750) < 2 * (5 - chickenAmount)) {
            chickenAmount++;
            if (Greenfoot.getRandomNumber(2) == 1) {
                addObject(new Chicken(this, true), 0,
                        Greenfoot.getRandomNumber(getHeight() - 60) + 30);
            } else {
                addObject(new Chicken(this, false), getWidth(),
                        Greenfoot.getRandomNumber(getHeight() - 60) + 30);
            }
        }
    }

    /**
     * The increaseChickenAmount method increases the chicken counter by one. It
     * is called in the constructor of the Chicken class when a new chicken is
     * spawned.
     */
    public void increaseChickenAmount() {
        chickenAmount++;
    }
}