import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Chicken class represents the targets in the game.
 * It controls the behaviour, properties and movement of the targets.
 * 
 * @author Paul Jonas Dohle
 * @version 0.1.0
 */
public class Chicken extends Actor {
    private int size;
    private GameWorld world;

    /**
     * The constructor initializes the size of the target, sets the image of the
     * target and stores a reference to the world.
     */
    public Chicken() {
        world = (GameWorld) getWorld();
        size = Greenfoot.getRandomNumber(4) + 2;
        getImage().scale(size * 15, size * 15);
        world.increaseChickenAmount();
    }

    /**
     * The act method is the anchor for the game loop which calls it on every
     * frame. Especially the movement of the targets is controlled in this
     * method.
     */
    public void act() {
    }

    /**
     * The move method controls the movement of the targets. It is called in the
     * act method. It moves the chicken with constant speed in the direction it
     * is currently facing. If the chicken reaches the edge of the world it is
     * deleted and the chicken counter is decreased by one.
     */
    public void move() {
    }

}
