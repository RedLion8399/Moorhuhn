import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The ImprovedActor class extend missing functionality in the normal Actor
 * class.
 * Therefore all CLasses that should regularly implement Actor should implement
 * this instead.
 */
public abstract class ImprovedActor extends Actor {

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

        if (relX >= 0 && relY < image.getWidth() && relY >= 0
                && relY < image.getHeight()) {
            return image.getColorAt(relX, relY).getAlpha() > 0;
        } else {
            return false;
        }
    }
}