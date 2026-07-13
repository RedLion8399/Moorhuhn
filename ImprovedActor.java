import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The ImprovedActor class extend missing functionality in the normal Actor
 * class.
 * Therefore all CLasses that should regularly implement Actor should implement
 * this instead.
 */
public abstract class ImprovedActor extends Actor {
    protected final int zIndex;

    /**
     * Creates a new ImprovedActor.
     *
     * @param zIndex The z-index of the Actor
     */
    public ImprovedActor(int zIndex) {
        this.zIndex = zIndex;
    }

    /**
     * Creates a new ImprovedActor with a default z-index of 0.
     */
    public ImprovedActor() {
        this(0);
    }

    /**
     * The method returns if the image of an ImprovedActor is transparent at a
     * certain position
     * It the given position is outside the image false is returned
     *
     * @param absX The x-coordinate of the position absolute to the World
     * @param absY The y-coordinate of the position absolute to the World
     *
     * @return true if the given position is transparent, false otherwise
     */
    public boolean isTransparentAtPosition(int absX, int absY) {
        GreenfootImage image = this.getImage();
        int relX = absX - getX() + image.getWidth() / 2;
        int relY = absY - getY() + image.getHeight() / 2;

        if (relX >= 0 && relX < image.getWidth() && relY >= 0
                && relY < image.getHeight()) {
            return image.getColorAt(relX, relY).getAlpha() > 0;
        } else {
            return false;
        }
    }

    /**
     * Returns the z-index of the Actor.
     * The z-index is used to determine if the Actor is in front of or behind
     * an other Actor. If the z-index of the Actor is lower it is more in the
     * front.
     * If the z-index of the Actor is higher it is more in the back.
     *
     * @return the z-index of the Actor
     */
    public int getZIndex() {
        return zIndex;
    }
}