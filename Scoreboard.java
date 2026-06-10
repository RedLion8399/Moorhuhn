import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The scoreboard displays essential information in the game,
 * the points and munition.
 * 
 * @author Paul Jonas Dohle
 * @version 0.1.0
 */
public class Scoreboard extends Actor {
    private final GameWorld WORLD;

    /**
     * The constructor initializes the scoreboard. It scales the image of the
     * scoreboard to a certain size and adds it to the world.
     */
    public Scoreboard(GameWorld world) {
        WORLD = world;
        getImage().scale(150, 50);

        WORLD.addObject(this, WORLD.getWidth() -
                getImage().getWidth() / 2 - 8,
                getImage().getHeight() / 2 + 8);
    }

    /**
     * The act method is the acces point for the game loop
     * and is called regularly. It calls other methods regularly
     * including the update methode.
     */
    public void act() {
    }
}
