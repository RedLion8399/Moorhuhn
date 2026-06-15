import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Crosshair class represents the crosshair in the game and is the equal to
 * a player. It controlls the player input and processes them by moving the
 * crosshair, checking for hits on the targets, controlling the munition and
 * reloading it.
 * 
 * @author Paul Jonas Dohle
 * @version 0.1.0
 * 
 * @see Chicken
 * @see GameWorld
 */
public class Crosshair extends Actor {
    private int munitionAmount;
    private final GameWorld WORLD;
    private int shootingDelay;

    /**
     * The constructor initializes the crosshair.
     * It sets the munition to 8 and scales the image of the crosshair to a
     * certain size.
     * 
     * @param world the world in which the crosshair is located
     * 
     * @see GameWorld
     */
    public Crosshair(GameWorld world) {
        this.WORLD = world;
        munitionAmount = 8;
        shootingDelay = 0;
        getImage().scale(30, 30);
    }

    /**
     * The act method is the anchor for the game loop which calls it on every
     * frame. It controls the player input and processes them.
     * 
     * @see #processUserInput()
     * @see #move()
     */
    @Override
    public void act() {
        move();
        processUserInput();
    }

    /**
     * The processUserInput method processes the user input. It is called in the
     * {@link #act()} method. It checks if the left or right mouse button is
     * pressed and calls the {@link #shoot()} method if the left mouse button is
     * pressed and the {@link #reloadMunition()} method if the right mouse
     * button is pressed. It also controls the shooting delay.
     * 
     * @see greenfoot.MouseInfo
     */
    private void processUserInput() {
        final int LEFT_MOUSE_BUTTON = 1;
        final int RIGHT_MOUSE_BUTTON = 3;

        shootingDelay++;

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
     * 
     * @see greenfoot.MouseInfo
     */
    private void move() {
        MouseInfo mouseInfo = Greenfoot.getMouseInfo();
        if (mouseInfo != null) {
            setLocation(mouseInfo.getX(), mouseInfo.getY());
        }
    }

    /**
     * The shoot method controls the shooting of the gun. It is called in
     * the {@link #act()} method if the left mouse button is pressed. It shoots
     * in the direction the crosshair is currently facing. If the shot hits a
     * target the target is deleted and the chicken counter is decreased by
     * one. The method also decreases the munition by one when shooting. If
     * there is no munition left nothing happens. On these different events
     * different sounds are played. After shooting there is a short delay
     * until the next shot can be fired which is reset after shooting.
     * 
     * @see Chicken
     * @see Greenfoot#playSound(String)
     */
    private void shoot() {
        if (shootingDelay < 10) {
            return;
        }

        if (munitionAmount == 0) {
            Greenfoot.playSound("sounds/no-munition.mp3");
            return;
        }
        munitionAmount--;
        shootingDelay = 0;
        Greenfoot.playSound("sounds/peng-1.mp3");

        Chicken chicken = (Chicken) getOneIntersectingObject(Chicken.class);
        if (chicken != null) {
            Greenfoot.playSound("sounds/hit-target.mp3");
            chicken.hit();
        } else {
            Greenfoot.playSound("sounds/miss-shot.mp3");
        }
    }

    /**
     * The reloadMunition method controls the reloading of the gun. It is called
     * in the {@link #act()} method if the right mouse button is pressed. It
     * reloads the gun with 8 bullets if there is no munition left and plays a
     * sound.
     */
    private void reloadMunition() {
        if (munitionAmount == 0) {
            munitionAmount = 8;
            Greenfoot.playSound("sounds/reload.mp3");
        }
    }

    /**
     * The getMunitionAmount method returns the current munition amount.
     * 
     * @return the current munition amount
     */
    public int getMunitionAmount() {
        return munitionAmount;
    }
}