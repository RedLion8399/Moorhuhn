import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The tree functions as unmovable obstacle chickens can hide behinde in order
 * to avoiid being hit.
 * 
 * @author Paul Jonas Dohle
 * @version 0.1.0
 */
public class Tree extends Obstacle {

    /**
     * Constructs objects of class tree
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
