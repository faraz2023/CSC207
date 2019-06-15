import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

/**
 * A Human
 */

public class Human extends FarmThing{

    /** Indicates whether this human is moving right. */
    private boolean goingRight;

    private ArrayList<Egg> myBasket = new ArrayList<Egg>();

    private GraphicsContext g;


    /**
     * Constructs a new Human.
     */
    public Human() {
        super();
        this.setAppearance("human");
        this.setColor(Color.SANDYBROWN.darker());
        goingRight = true;
    }

    /**
     * Causes human to drop down 4 piece s of food all around.
     */
    protected void dropFood() {
        if (this.getX() > 0 && this.getY() > 0) {
            if (!(FarmThing.myFarmThings[this.getX() - 1][this.getY() - 1] instanceof Animal)) {
                AnimalFood food = new AnimalFood();
                food.setLocation(this.getX() - 1, this.getY() - 1);
                FarmThing.myFarmThings[this.getX() - 1][this.getY() - 1] = food;
            }
        }

        if (this.getX() > 0 && this.getY() < (640/6) - 1) {
            if (!(FarmThing.myFarmThings[this.getX() - 1][this.getY() + 1] instanceof Animal)){
            AnimalFood food = new AnimalFood();
            food.setLocation(this.getX() - 1, this.getY() + 1);
            FarmThing.myFarmThings[this.getX() - 1][this.getY() + 1] = food;
            }
        }

        if (this.getX() < (480/10) - 1 && this.getY() > 0) {
            if (!(FarmThing.myFarmThings[this.getX() + 1][this.getY() - 1] instanceof Animal)){
            AnimalFood food = new AnimalFood();
            food.setLocation(this.getX() + 1, this.getY() - 1);
            FarmThing.myFarmThings[this.getX() + 1][this.getY() - 1] = food;
            }
        }

        if (this.getX() < (480/10) - 1 && this.getY() < (640/6) - 1) {
            if (!(FarmThing.myFarmThings[this.getX() + 1][this.getY() + 1] instanceof Animal)) {
            AnimalFood food = new AnimalFood();
            food.setLocation(this.getX() + 1, this.getY() + 1);
            FarmThing.myFarmThings[this.getX() + 1][this.getY() + 1] = food;
            }
        }
    }


    /**
     * Turns this human around, causing it to reverse direction.
     */
    protected void turnAround() {
        goingRight = !goingRight;
        this.setAppearance(reverseAppearance());
    }


    /**
     * Draws the given string in the given graphics context at
     * at the given cursor location.
     *
     * @param  g  the graphics context in which to draw the string.
     * @param  s  the string to draw.
     * @param  x  the x-coordinate of the string's cursor location.
     * @param  y  the y-coordinate of the string's cursor location.
     */
    public void drawString(GraphicsContext g, String s, int x, int y) {
        g.fillText(this.getAppearance(), y * 10, x * 6);
        g.fillText("Eggs: " + myBasket.size(), 2 * 10, 2 * 6);

    }

    /**
     * Draws this farm pen item.
     *
     * @param  g  the graphics context in which to draw this item.
     */
    public void draw(GraphicsContext g) {
        this.g = g; g.setFill(this.getColor());
        drawString(g, this.getAppearance(), this.getX(), this.getY());
    }


    Egg target = null;

    /**
     * Causes this item to take its turn in the farm-pensimulation.
     */
    public void move() {

        if (target == null) {
            target = Egg.anEggisHere();
        }
        if (target != null) {
            System.out.println("Target acquired: " + target.getX() + " " + target.getY() + "| Me: " + this.getX() + " " + this.getY());
            // Am I on an egg?
            if (this.getX() == target.getX() && this.getY() == target.getY()) {
                System.out.println("Egg!");
                this.myBasket.add(target);
                FarmThing.myFarmThings[target.getX()][target.getY()] = new FarmThing();
                target = null;
                if (myBasket.size() % 12 == 0) {
                    System.out.println("Dozen!");
                    g.fillText("Eggs: " + myBasket.size(), 1 * 10, 1 * 6);
                }

            }

            else {

                // move toward the egg
                if (this.getX() < target.getX()) {
                    this.setX(this.getX() + 1);
                } else if (this.getX() > target.getX())  {
                    this.setX(this.getX() - 1);
                }
                else{}

                if (this.getY() < target.getY()) {
                    this.setY(this.getY() + 1);
                } else if (this.getY() > target.getY()){
                    this.setY(this.getY() - 1);
                }
                else{}
            }
        }
        else // no egg to pick up

        // Move one spot to the right or left.
        if (goingRight) {
            // Figure out whether to move up or down, or neither.
            double d = Math.random();
            if (d < 0.1) {
                if(this.getX() == (480/10) - 1){ turnAround(); }
                else{ this.setX(this.getX() + 1); }
            } else if (d < 0.2) {
                if(this.getX() == 0){ turnAround(); }
                else{ this.setX(this.getX() - 1); }
            }
                if(this.getY() != (640/6) - 1){this.setY(this.getY() + 1); }
        } else {
            // Figure out whether to move up or down, or neither.
            double d = Math.random();
            if (d < 0.1) {
                if(this.getX() == (480/10) - 1){ turnAround(); }
                else{ this.setX(this.getX() + 1); }
            } else if (d < 0.2) {
                if(this.getX() == 0){ turnAround(); }
                else{ this.setX(this.getX() - 1); }
            }
            if(this.getY() != 0){this.setY(this.getY() - 1); }

        }

        // Figure out whether I should drop food.
        double d = Math.random();
        if (d < 0.05) {
            dropFood();
        }

        // Figure out whether I turn around.
        d = Math.random();
        if (d < 0.1) {
            turnAround();
        }
    }
}
