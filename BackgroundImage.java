import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The BackgroundImage class represents the background image in the game.
 * As the Backround has to move a seperate actor is needed to represet it.
 * 
 * @author Paul Jonas Dohle
 * @version 0.1.0
 */
public class BackgroundImage extends Actor {
    private final GameWorld WORLD;

    /**
     * Creates a new BackgroundImage object.
     * The image is scaled to be wider than the game world in order o allow
     * scrolling.
     * 
     * @param world the world the actor is in
     */
    public BackgroundImage(GameWorld world) {
        this.WORLD = world;
        getImage().scale(WORLD.getWidth() * 2, WORLD.getHeight());

        WORLD.addObject(this, WORLD.getWidth() / 2, WORLD.getHeight() / 2);
    }
}
