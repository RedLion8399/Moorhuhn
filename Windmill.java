import greenfoot.Greenfoot;

/**
 * The Windmill functions as unmovable obstacle. It is on the last of all
 * layers. On the widmill, three windmill blades are rotating. They are hittable
 * objects.
 */
public class Windmill extends Obstacle {
    Blade blades;

    /**
     * Constructor for objects of class Windmill.
     * 
     * @param world the world to which the Windmill is added
     */
    public Windmill(GameWorld world, BackgroundImage backgroundImage) {
        super(world, 4, 0);
        setImage("images/windmill-2.png");
        getImage().scale(350, 350);
        world.addObject(this, backgroundImage.getRandomXOnBackground(100),
                world.getHeight() / 2);

        blades = new Blade(world);
    }

    /**
     * The act method is the anchor for the game loop which calls it on every
     * frame. It rotates the windmill blades.
     * 
     * @see #rotateBlades()
     */
    @Override
    public void act() {
        rotateBlades();
    }

    /**
     * The hit method is called when the windmill is hit by a projectile.
     * It does nothing as windmills are indestructible.
     * 
     * @see Crosshair#shoot()
     */
    @Override
    public void hit() {
    }

    /**
     * The rotateBlades method rotates the windmill blades around the center.
     */
    private void rotateBlades() {
        blades.turn(1);
    }

    class Blade extends Obstacle {
        Windmill windmill;

        /**
         * Constructor for objects of class Blade.
         * It creates a new blade that is centered on the roof of the windmill.
         * 
         * @param world the world to which the Blade is added
         */
        public Blade(GameWorld world) {
            super(world, 4, 25);
            windmill = Windmill.this;

            setImage("images/windmill-3.png");
            getImage().scale(300, 300);
            world.addObject(this, windmill.getX(),
                    windmill.getY() - getImage().getHeight() / 17);
        }

        /**
         * The move method positions the blades on the windmill.
         * 
         * @param distance an unused parameter
         */
        @Override
        public void move(int distance) {
            windmill = Windmill.this;
            setLocation(windmill.getX(),
                    windmill.getY() - getImage().getHeight() / 17);
        }

        /**
         * The hit method is called when the windmill is hit by a projectile.
         * On hit the blades are removed and 25 points are added.
         * 
         * @see Crosshair#shoot()
         */
        @Override
        public void hit() {
            world.addPoints(points);
            world.removeObject(this);
            Greenfoot.playSound("sounds/hit-target.mp3");
        }
    }
}
