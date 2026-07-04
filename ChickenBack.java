/**
 * The ChickenBack extends the Chicken superclass as the target that is in
 * behind every other obstacle.
 * 
 * @author Paul Jonas Dohle
 * @version 0.1.0
 * 
 * @see GameWorld
 * @see Crosshair
 */
public class ChickenBack extends Chicken {
    public ChickenBack(GameWorld world, BackgroundImage backgroundImage) {
        super(world, backgroundImage, 3);
    }
}
