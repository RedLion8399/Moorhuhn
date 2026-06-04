import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Crosshair class represents the crosshair in the game and is the equal to
 * a player. It controlls the player input and processes them by moving the
 * crosshair, checking for hits on the targets, controlling the munition and
 * reloading it.
 * 
 * @author Paul Jonas Dohle
 * @version 0.1.0
 */
public class Crosshair extends Actor {
    private int munitionAmount;
    private GameWorld world;

    /**
     * The constructor initializes the crosshair.
     * It sets the munition to 8 and scales the image of the crosshair to a
     * certain size.
     * 
     * @param world the world in which the crosshair is located
     */
    public Crosshair(GameWorld world) {
        this.world = world;
        munitionAmount = 8;
        getImage().scale(30, 30);
    }

    /**
     * The act method is the anchor for the game loop which calls it on every
     * frame. It controls the player input and processes them.
     */
    public void act() {
    }

    /**
     * The shoot method controls the shooting of the gun. It is called in
     * the act method if the left mouse button is pressed. It shoots in the
     * direction the crosshair is currently facing. If the shot hits a target
     * the target is deleted and the chicken counter is decreased by one. The
     * method also decreases the munition by one when shooting. If there is no
     * munition left nothing happens.
     */
    public void shoot() {
    }

    /**
     * The reloadMunition method controls the reloading of the gun. It is called
     * in the act method if the right mouse button is pressed. It reloads the
     * gun with a certain amount of munition if it was empty before.
     */
    public void reloadMunition() {
    }
}