/**
 * The Hittable interface represents objects that can be hit by projectiles.
 * It defines the hit method which needs to be implemented by subclasses.
 * 
 */
public interface Hittable {
    /**
     * The hit method is called when the obstacle is hit by a projectile.
     * It needs to be implemented by subclasses to define specific behavior when
     * hit.
     * 
     * @see Crosshair#shoot()
     */
    public abstract void hit();
}
