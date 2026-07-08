/**
 * The Obstacle class represents obstacles in the game.
 * 
 * @see Tree
 */
public abstract class Obstacle extends ImprovedActor {
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
     * The hit method is called when the obstacle is hit by a projectile.
     * It needs to be implemented by subclasses to define specific behavior when
     * hit.
     * 
     * @see Crosshair#shoot()
     */
    public abstract void hit();

    /**
     * Returns the points of the obstacle.
     * 
     * @return the points of the obstacle
     */
    public int getPoints() {
        return points;
    }
}
