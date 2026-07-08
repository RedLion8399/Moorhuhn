/**
 * The ZIndexable interface defines a contract for objects that have a z-index.
 * The z-index determines the rendering order of objects in the game world.
 * Objects with a lower z-index are rendered in front of objects with a higher
 * z-index.
 */
public interface ZIndexable {
    int getZIndex();
}
