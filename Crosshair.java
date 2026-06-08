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
        move();
        processUserInput();
    }

    /**
     * The processUserInput method processes the user input. It is called in the
     * act method. It checks if the left or right mouse button is pressed and
     * calls the shoot method if the left mouse button is pressed and the
     * reloadMunition method if the right mouse button is pressed.
     */
    public void processUserInput() {
        final int LEFT_MOUSE_BUTTON = 1;
        final int RIGHT_MOUSE_BUTTON = 3;

        MouseInfo mouseInfo = Greenfoot.getMouseInfo();
        if (mouseInfo != null) {
            if (mouseInfo.getButton() == LEFT_MOUSE_BUTTON) {
                shoot();
            } else if (mouseInfo.getButton() == RIGHT_MOUSE_BUTTON) {
                reloadMunition();
            }
        }
    }

    /**
     * The move method controls the movement of the crosshair parallel to the
     * mouse cursor.
     */
    public void move() {
        MouseInfo mouseInfo = Greenfoot.getMouseInfo();
        if (mouseInfo != null) {
            setLocation(mouseInfo.getX(), mouseInfo.getY());
        }
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
        if (munitionAmount == 0) {
            return;
        }
        munitionAmount--;

        Chicken chicken = (Chicken) getOneIntersectingObject(Chicken.class);
        if (chicken != null) {
            world.removeObject(chicken);
            world.decreaseChickenAmount();
        }
    }

    /**
     * The reloadMunition method controls the reloading of the gun. It is called
     * in the act method if the right mouse button is pressed. It reloads the
     * gun with a certain amount of munition if it was empty before.
     */
    public void reloadMunition() {
        if (munitionAmount == 0) {
            munitionAmount = 8;
        }
    }
}