/**
 * The Windmill functions as unmovable obstacle. It is on the last of all
 * layers. On the widmill, three windmill blades are rotating. They are hittable
 * objects on wich a chicken is detached each.
 */
public class Windmill extends Obstacle {

    /**
     * Constructor for objects of class Windmill.
     * 
     * @param world the world to which the Windmill is added
     */
    public Windmill(GameWorld world, BackgroundImage backgroundImage) {
        super(world, 0, 0);
        setImage("images/windmill-2.png");
        getImage().scale(350, 350);
        world.addObject(this, backgroundImage.getRandomXOnBackground(100),
                world.getHeight() / 2);
    }

    /**
     * The hit method is called when the windmill is hit by a projectile.
     * It does nothing as windmills are indestructible.
     * 
     * @see Crosshair#shoot()
     */
    public void hit() {
    }
}
