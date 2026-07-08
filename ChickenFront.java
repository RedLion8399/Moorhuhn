/**
 * The ChickenFront extends the Chicken superclass as the target that is in
 * front of every other obstacle. It has a z-index of 1.
 * 
 * @see GameWorld
 * @see Crosshair
 */
public class ChickenFront extends Chicken {
    public ChickenFront(GameWorld world, BackgroundImage backgroundImage) {
        super(world, backgroundImage, 1);
    }
}
