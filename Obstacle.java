/**
 * The Obstacle class represents obstacles in the game.
 * 
 * @see Tree
 */
public abstract class Obstacle extends ImprovedActor implements Hittable {
    protected final GameWorld world;
    protected final int points;

    /**
     * Constructs objects of class Obstacle
     */
    public Obstacle(GameWorld world, int zIndex, int points) {
        super(zIndex);
        this.world = world;
        this.points = points;
    }

    /**
     * Returns the points of the obstacle.
     * 
     * @return the points of the obstacle
     */
    public int getPoints() {
        return points;
    }
}
