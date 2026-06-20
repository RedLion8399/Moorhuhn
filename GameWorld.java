import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

@SuppressWarnings("unused")

/**
 * The GameWorld class is the world in which the game takes place.
 * It innitializes all objects needed in the world and controls them.
 * 
 * @author Paul Jonas Dohle
 * @version 0.1.0
 * 
 * @see Crosshair
 * @see Chicken
 * @see Scoreboard
 * @see BackgroundImage
 */
public class GameWorld extends World {
    private final Crosshair CROSSHAIR;
    private final Scoreboard SCOREBOARD;
    private final BackgroundImage BACKGROUND_IMAGE;

    private int chickenAmount;
    private int points;

    /**
     * Constructor for objects of class GameWorld.
     * It creates a GameWorld object with certain dimensions and a certain cell
     * size. It creates references to other objects that are needed in the
     * world.
     * 
     * @see Crosshair
     * @see Scoreboard
     * @see BackgroundImage
     */
    public GameWorld() {
        super(600, 400, 1, false);
        setPaintOrder(Crosshair.class, Chicken.class, Scoreboard.class,
                GameWorld.class);
        chickenAmount = 0;

        CROSSHAIR = new Crosshair(this);
        addObject(CROSSHAIR, getWidth() / 2, getHeight() / 2);

        SCOREBOARD = new Scoreboard(this, CROSSHAIR);

        BACKGROUND_IMAGE = new BackgroundImage(this);
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
        if (Greenfoot.getRandomNumber(750) < 2 * (5 - chickenAmount)) {
            chickenAmount++;
            new Chicken(this, BACKGROUND_IMAGE);
        }
    }

    /**
     * The decreaseChickenAmount method decreases the chicken counter by one.
     * 
     * @see Chicken
     */
    public void decreaseChickenAmount() {
        chickenAmount--;
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