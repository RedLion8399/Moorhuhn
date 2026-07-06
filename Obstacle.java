import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Obstacle class represents obstacles in the game.
 * 
 * @author Paul Jonas Dohle
 * @version 0.1.0
 * 
 * @see Tree
 */
public abstract class Obstacle extends Actor implements ZIndexable {
    protected final GameWorld world;
    protected final int zIndex;
    protected final int points;

    /**
     * Constructs objects of class Obstacle
     */
    public Obstacle(GameWorld world, int zIndex, int points) {
        this.world = world;
        this.zIndex = zIndex;
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
     * Returns the z-index of the obstacle.
     * 
     * @return the z-index of the obstacle
     */
    @Override
    public int getZIndex() {
        return zIndex;
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
