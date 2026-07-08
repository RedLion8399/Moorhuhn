import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The BackgroundImage class represents the background image in the game.
 * As the Background has to move a seperate actor is needed to represent it.
 * 
 * @author Paul Jonas Dohle
 * @version 1.0.0
 */
public class BackgroundImage extends ImprovedActor {
    private static final int SCALE_FACTOR = 2;

    /**
     * Creates a new BackgroundImage object.
     * The image is scaled to be wider than the game world in order to allow
     * scrolling.
     * 
     * @param world the world the actor is in
     */
    public BackgroundImage(GameWorld world) {
        getImage().scale(world.getWidth() * SCALE_FACTOR,
                world.getHeight());

        world.addObject(this, world.getWidth() / 2,
                world.getHeight() / 2);
    }

    /**
     * Returns the leftmost coordinate of the BackgroundImage
     * 
     * @return the start position
     */
    public int getImageStart() {
        return getX() - getImage().getWidth() / 2;
    }

    /**
     * Returns the rightmost coordinate of the BackgroundImage
     * 
     * @return the end position
     */
    public int getImageEnd() {
        return getX() + getImage().getWidth() / 2;
    }
}
