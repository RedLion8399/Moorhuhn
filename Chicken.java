import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Chicken class represents the targets in the game.
 * It controls the behaviour, properties and movement of the targets.
 * The Chicken superclass provides the functionality which the subclasses
 * specify by different z-coordinates.
 * 
 * @author Paul Jonas Dohle
 * @version 0.2.0
 * 
 * @see GameWorld
 * @see Crosshair
 */
public abstract class Chicken extends Actor implements ZIndexable {
    private final int points;
    private final GameWorld world;
    private final BackgroundImage background;

    private final int zIndex;
    private final int size;
    private final int x_0;
    private final int y_0;
    private final int speed;
    private final int flightHight;
    private final int flightFrequency;
    private final boolean facingRight;

    /**
     * Returns an object of a random subclass of the Chicken class.
     * 
     * @param world the world to which the Chicken is added
     *
     * @return an object of a random subclass of the Chicken class
     */
    public static Chicken getChicken(GameWorld world,
            BackgroundImage backgroundImage) {
        if (Greenfoot.getRandomNumber(2) == 1) {
            return new ChickenFront(world, backgroundImage);
        } else {
            return new ChickenBack(world, backgroundImage);
        }
    }

    /**
     * Initializes a Chicken with a random size and position, sets its
     * orientation (left or right), sets its speed, parameters for its movement
     * curve and points and adds it to the {@link GameWorld}.
     *
     * @param world      the world to which the Chicken is added
     * @param background the BackgroundImage of the world
     * 
     * @see GameWorld#addObject(Actor, int, int)
     * 
     * @throws IllegalStateException if te size is out of bounds
     */
    public Chicken(GameWorld world, BackgroundImage background, int zIndex) {
        this.world = world;
        this.background = background;
        size = Greenfoot.getRandomNumber(3) + 1;
        getImage().scale(size * 25, size * 25);

        this.zIndex = zIndex;
        y_0 = Greenfoot.getRandomNumber(this.world.getHeight() - 60) + 30;
        flightHight = Greenfoot.getRandomNumber(40) + 10;
        flightFrequency = Greenfoot.getRandomNumber(300) + 85;

        if (Greenfoot.getRandomNumber(2) == 1) {
            facingRight = true;
            setRotation(0);
            x_0 = this.background.getImageStart();
            speed = Greenfoot.getRandomNumber(4) + 1;
        } else {
            facingRight = false;
            setRotation(180);
            getImage().mirrorVertically();
            x_0 = this.background.getImageEnd();
            speed = -Greenfoot.getRandomNumber(4) - 1;
        }

        this.world.addObject(this, x_0, y_0);

        switch (size) {
            case 1 -> points = 25;
            case 2 -> points = 10;
            case 3 -> points = 5;

            default -> throw new IllegalStateException(
                    "Unexpected value size: " + size);
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
     * Returns the z-index of the target.
     * 
     * @return the z-index of the target
     */
    @Override
    public int getZIndex() {
        return zIndex;
    }

    /**
     * The move method controls the movement of the targets. It is called in the
     * {@link #act()} method. It moves the chicken with constant speed in the
     * direction it is currently facing. If the chicken reaches the edge of
     * the Background it is deleted and the chicken counter is decreased by one.
     */
    private void move() {
        int x = getX();
        int y = getY();

        x += speed;
        y = (int) (flightHight
                * Math.sin(x * (Math.PI / flightFrequency))
                + y_0);
        setLocation(x, y);

        if (!intersects(background)) {
            world.decreaseChickenAmount();
            world.removeObject(this);
        }
    }

    /**
     * The hit method is called if a shot hits a target.
     * It deletes the target, decreases the chicken counter and adds points.
     * 
     * @see Crosshair#shoot()
     * @see GameWorld#addPoints(int)
     */
    public void hit() {
        Obstacle obstacle = (Obstacle) getOneIntersectingObject(Obstacle.class);
        if (obstacle != null && obstacle.getZIndex() < getZIndex()) {
            obstacle.hit();
            return;
        }
        world.decreaseChickenAmount();
        world.addPoints(points);
        world.removeObject(this);
        Greenfoot.playSound("sounds/hit-target.mp3");
    }

    /**
     * The isFacingRight method returns whether the chicken is currently facing
     * right or left.
     * 
     * @return whether the chicken is currently facing right or left
     */
    public boolean isFacingRight() {
        return facingRight;
    }
}
