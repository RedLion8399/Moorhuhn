import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The scoreboard displays essential information in the game,
 * the points and munition.
 * 
 * @author Paul Jonas Dohle
 * @version 1.0.0
 * 
 * @see GameWorld
 * @see Crosshair
 */
public class Scoreboard extends ImprovedActor {
    private final GameWorld world;
    private final Crosshair crosshair;

    /**
     * The constructor initializes the scoreboard. It scales the image of the
     * scoreboard to a certain size and adds it to the world.
     * 
     * @param world     the world in which the scoreboard is displayed
     * @param crosshair the crosshair of the player
     * 
     * @see GameWorld#addObject(Actor, int, int)
     */
    public Scoreboard(GameWorld world, Crosshair crosshair) {
        this.world = world;
        this.crosshair = crosshair;
        getImage().scale(150, 50);

        this.world.addObject(this, this.world.getWidth() -
                getImage().getWidth() / 2 - 8,
                getImage().getHeight() / 2 + 8);
    }

    /**
     * The act method is the acces point for the game loop
     * and is called regularly. It calls other methods regularly
     * including the {@link #update()} methode.
     */
    public void act() {
        update();
    }

    /**
     * The update method updates the scoreboard and displays
     * the points and munition.
     * 
     * @see GameWorld#getPoints()
     * @see Crosshair#getMunitionAmount()
     */
    private void update() {
        String message = String.format("Punkte: %d    Munition: %d",
                world.getPoints(), crosshair.getMunitionAmount());
        getImage().clear();
        setImage("images/display.png");
        getImage().drawString(message, 10,
                (getImage().getHeight() + getImage().getFont().getSize()) / 2);
        setLocation(world.getWidth() - getImage().getWidth() / 2 - 8, getY());

    }
}
