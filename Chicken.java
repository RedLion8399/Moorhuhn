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
    private int x_0;
    private int y_0;

    /**
     * Initializes a Chicken with a random size and position, sets its
     * orientation (left or right), and adds it to the world.
     *
     * @param world the world to which the Chicken is added
     */
    public Chicken(GameWorld world) {
        this.world = world;
        size = Greenfoot.getRandomNumber(4) + 2;
        getImage().scale(size * 15, size * 15);

        y_0 = Greenfoot.getRandomNumber(world.getHeight() - 60) + 30;

        if (Greenfoot.getRandomNumber(2) == 1) {
            setRotation(0);
            x_0 = 0;
        } else {
            setRotation(180);
            getImage().mirrorVertically();
            x_0 = world.getWidth();
        }

        world.addObject(this, x_0, y_0);
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
