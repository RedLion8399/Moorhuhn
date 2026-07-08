import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Crosshair class represents the crosshair in the game and acts as the
 * player's interface. It controlls the player input and processes them by
 * moving the crosshair, checking for hits on the targets, controlling the
 * munition and reloading it.
 * 
 * @see Chicken
 * @see GameWorld
 */
public class Crosshair extends ImprovedActor {
    private static final int MAX_MUNITION = 8;
    private final GameWorld world;

    private int munitionAmount;
    private int shootingDelayCounter;

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
        this.world = world;
        munitionAmount = MAX_MUNITION;
        shootingDelayCounter = 0;
        getImage().scale(30, 30);

        this.world.addObject(this,
                this.world.getWidth() / 2,
                this.world.getHeight() / 2);
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
        final int leftMouseButton = 1;
        final int rightMouseButton = 3;

        shootingDelayCounter++;

        MouseInfo mouseInfo = Greenfoot.getMouseInfo();
        if (mouseInfo != null) {
            if (mouseInfo.getButton() == leftMouseButton) {
                shoot();
            } else if (mouseInfo.getButton() == rightMouseButton) {
                reloadMunition();
            }
        }

        checkScrolling();
    }

    /**
     * The checkScrolling method is checks if the user gives a scolling input.
     * If the Crosshair moves in a range of 50 pixels to the visable borders the
     * displayed world is moved to that side.
     */
    private void checkScrolling() {
        final int scrollSpeed = 5;
        final int scrollThreshold = 50;

        if (getX() < scrollThreshold) {
            world.move(scrollSpeed);
        } else if (getX() > world.getWidth() - scrollThreshold) {
            world.move(-scrollSpeed);
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
        final int shootingDelay = 10;

        if (shootingDelayCounter < shootingDelay) {
            return;
        }

        if (munitionAmount == 0) {
            Greenfoot.playSound("sounds/no-munition.mp3");
            return;
        }
        munitionAmount--;
        shootingDelayCounter = 0;
        Greenfoot.playSound("sounds/peng-1.mp3");

        Chicken chicken = (Chicken) getOneIntersectingObject(Chicken.class);
        if (chicken != null) {
            chicken.hit(getX(), getY());
        } else {
            Greenfoot.playSound("sounds/miss-shot.mp3");
        }
    }

    /**
     * The reloadMunition method controls the reloading of the gun. It is called
     * in the {@link #act()} method if the right mouse button is pressed. It
     * reloads the gun with 8 bullets if there is no munition left and plays a
     * sound.
     * 
     * @see #shoot()
     */
    private void reloadMunition() {
        if (munitionAmount == 0) {
            munitionAmount = MAX_MUNITION;
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