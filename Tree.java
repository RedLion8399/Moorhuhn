import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The tree functions as unmovable obstacle chickens can hide behinde in order
 * to avoiid being hit.
 */
public class Tree extends Obstacle {

    /**
     * Constructs objects of class tree
     * It scales the image to a fixed size and adds it to the world at a random
     * position within the world boundaries with a margin of 100 pixels on the
     * left and right side.
     * 
     * @param world The game world
     */
    public Tree(GameWorld world) {
        super(world, 2, 0);
        getImage().scale(300, 300);
        world.addObject(this,
                Greenfoot.getRandomNumber(world.getWidth() - 200) + 100,
                world.getHeight() - getImage().getHeight() / 2);
    }

    /**
     * The hit method is called when the tree is hit by a projectile.
     * It does nothing as trees are indestructible.
     * 
     * @see Crosshair#shoot()
     */
    public void hit() {
    }
}
