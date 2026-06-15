import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Chicken class represents the targets in the game.
 * It controls the behaviour, properties and movement of the targets.
 * 
 * @author Paul Jonas Dohle
 * @version 0.1.0
 * 
 * @see GameWorld
 * @see Crosshair
 */
public class Chicken extends Actor {
    private final int POINTS;
    private final GameWorld WORLD;

    private final int SIZE;
    private final int x_0;
    private final int y_0;
    private final int SPEED;
    private final int FLIGHT_HEIGHT;
    private final int FLIGHT_FREQUENCY;

    /**
     * Initializes a Chicken with a random size and position, sets its
     * orientation (left or right), sets its speed, parameters for its movement
     * curve and points and adds it to the {@link GameWorld}.
     *
     * @param world the world to which the Chicken is added
     * 
     * @see GameWorld#addObject(Actor, int, int)
     * 
     * @throws IllegalStateException if te size is out of bounds
     */
    public Chicken(GameWorld world) {
        this.WORLD = world;
        SIZE = Greenfoot.getRandomNumber(3) + 1;
        getImage().scale(SIZE * 25, SIZE * 25);

        y_0 = Greenfoot.getRandomNumber(WORLD.getHeight() - 60) + 30;
        FLIGHT_HEIGHT = Greenfoot.getRandomNumber(40) + 10;
        FLIGHT_FREQUENCY = Greenfoot.getRandomNumber(300) + 85;

        if (Greenfoot.getRandomNumber(2) == 1) {
            setRotation(0);
            x_0 = 0;
            SPEED = Greenfoot.getRandomNumber(4) + 1;
        } else {
            setRotation(180);
            getImage().mirrorVertically();
            x_0 = WORLD.getWidth();
            SPEED = -Greenfoot.getRandomNumber(4) - 1;
        }

        WORLD.addObject(this, x_0, y_0);

        switch (SIZE) {
            case 1 -> POINTS = 25;
            case 2 -> POINTS = 10;
            case 3 -> POINTS = 5;

            default -> throw new IllegalStateException(
                    "Unexpected value SIZE: " + SIZE);
        }
    }

    /**
     * The act method is the anchor for the game loop which calls it on every
     * frame. Especially the movement of the targets is controlled in this
     * method.
     * 
     * @see #move()
     */
    @Override
    public void act() {
        move();
    }

    /**
     * The move method controls the movement of the targets. It is called in the
     * {@link #act()} method. It moves the chicken with constant speed in the
     * direction it is currently facing. If the chicken reaches the edge of
     * the world it is deleted and the chicken counter is decreased by one.
     */
    private void move() {
        int x = getX();
        int y = getY();

        x += SPEED;
        y = (int) (FLIGHT_HEIGHT
                * Math.sin(x * (Math.PI / FLIGHT_FREQUENCY))
                + y_0);
        setLocation(x, y);

        if (getX() < 0 || getX() > WORLD.getWidth()) {
            WORLD.decreaseChickenAmount();
            WORLD.removeObject(this);
        }
    }

    /**
     * The hit method is called if a shot hits a target.
     * It deletes the target, decreases the chicken counter and adds points.
     */
    public void hit() {
        WORLD.decreaseChickenAmount();
        WORLD.addPoints(POINTS);
        WORLD.removeObject(this);
    }
}
