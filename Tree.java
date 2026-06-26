import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The tree functions as unmovable obstacle chickens can hide behinde in order
 * to avoiid being hit.
 * 
 * @author Paul Jonas Dohle
 * @version 0.1.0
 */
public class Tree extends Actor implements ZIndexable {
    private final GameWorld WORLD;
    private static final int Z_INDEX = 2;

    /**
     * Constructs objects of class tree
     */
    public Tree(GameWorld world) {
        WORLD = world;
        getImage().scale(300, 300);
        WORLD.addObject(this,
                Greenfoot.getRandomNumber(WORLD.getWidth() - 200) + 100,
                WORLD.getHeight() - getImage().getHeight() / 2);
    }

    /**
     * Returns the z-index of the tree.
     * 
     * @return the z-index of the tree
     */
    @Override
    public int getZIndex() {
        return Z_INDEX;
    }
}
