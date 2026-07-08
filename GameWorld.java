import java.util.List;
import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

@SuppressWarnings("unused")

/**
 * The GameWorld class is the world in which the game takes place.
 * It initializes all objects needed in the world and controls them.
 * 
 * @see Crosshair
 * @see Chicken
 * @see Scoreboard
 * @see BackgroundImage
 */
public class GameWorld extends World {
    private final Crosshair crosshair;
    private final Scoreboard scoreboard;
    private final BackgroundImage backgroundImage;

    private int chickenAmount = 0;
    private int points = 0;

    /**
     * Constructor for objects of class GameWorld.
     * It creates a GameWorld object with a fixed size and cell size.
     * It creates references to other objects that are needed in the
     * world.
     * 
     * @see Crosshair
     * @see Scoreboard
     * @see BackgroundImage
     */
    public GameWorld() {
        super(600, 400, 1, false);
        setPaintOrder(Crosshair.class, Scoreboard.class, ChickenFront.class,
                Tree.class, ChickenBack.class);
        getBackground().scale(getWidth(), getHeight());

        crosshair = new Crosshair(this);
        scoreboard = new Scoreboard(this, crosshair);
        backgroundImage = new BackgroundImage(this);
        new Tree(this);
    }

    /**
     * The act method is the anchor for the game loop which calls it on every
     * frame. It controls the spawning of the targets.
     * 
     * @see #spawnChicken()
     */
    @Override
    public void act() {
        spawnChicken();
    }

    /**
     * Spawns a {@link Chicken} in the world based on a probability that depends
     * on the current number of chickens. The maximum number of chickens is
     * limited to 5.
     */
    private void spawnChicken() {
        final int maxChickenAmount = 5;

        if (Greenfoot.getRandomNumber(750) < 2
                * (maxChickenAmount - chickenAmount)) {
            chickenAmount++;
            Chicken.getChicken(this, backgroundImage);
        }
    }

    /**
     * The move method moves the displayed excerpt of the world.
     * This includes the {@link Chicken}s and the {@link BackgroundImage}.
     * It can only move if the new position is within the bounds of the visible
     * world.
     * 
     * @param distance the amount of pixels to move
     */
    public void move(int distance) {
        if (distance > 0 && backgroundImage.getImageStart() + distance > 0) {
            return;
        } else if (distance < 0
                && backgroundImage.getImageEnd() + distance < getWidth()) {
            return;
        }
        backgroundImage.move(distance);

        List<Chicken> chickens = getObjects(Chicken.class);
        for (Chicken chicken : chickens) {
            chicken.move(chicken.isFacingRight() ? distance : -distance);
        }

        List<Obstacle> obstacles = getObjects(Obstacle.class);
        for (Obstacle obstacle : obstacles) {
            obstacle.move(distance);
        }
    }

    /**
     * The decreaseChickenAmount method decreases the chicken counter by one
     * if chickes exist. If no chickens exist the counter is not decreased.
     * 
     * @see Chicken
     */
    public void decreaseChickenAmount() {
        if (chickenAmount > 0) {
            chickenAmount--;
        }
    }

    /**
     * The addPoints method adds a certain amount of points to the score.
     * 
     * @param points the amount of points to add
     * 
     * @see #getPoints()
     */
    public void addPoints(int points) {
        this.points += points;
    }

    /**
     * The getPoints method returns the current score.
     * 
     * @return the current score
     * 
     * @see #addPoints(int)
     */
    public int getPoints() {
        return points;
    }
}