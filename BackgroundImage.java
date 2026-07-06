import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The BackgroundImage class represents the background image in the game.
 * As the Backround has to move a seperate actor is needed to represet it.
 * 
 * @author Paul Jonas Dohle
 * @version 0.1.0
 */
public class BackgroundImage extends Actor {
    private final GameWorld world;

    /**
     * Creates a new BackgroundImage object.
     * The image is scaled to be wider than the game world in order o allow
     * scrolling.
     * 
     * @param world the world the actor is in
     */
    public BackgroundImage(GameWorld world) {
        this.world = world;
        getImage().scale(this.world.getWidth() * 2, this.world.getHeight());

        this.world.addObject(this, this.world.getWidth() / 2,
                this.world.getHeight() / 2);
    }

    /**
     * Returns the start coordinate of the BackgroundImage
     * 
     * @return the start position
     */
    public int getImageStart() {
        return getX() - getImage().getWidth() / 2;
    }

    /**
     * Returns the end coordinate of the BackgroundImage
     * 
     * @return the end position
     */
    public int getImageEnd() {
        return getX() + getImage().getWidth() / 2;
    }
}
