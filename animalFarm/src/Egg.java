import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/** An egg that a farmer collects. */
public class Egg extends FarmThing {

    /** Creates and Egg. */

    public Egg(){
        super();
        this.setAppearance("o");
        this.setColor(Color.ROSYBROWN);
    }

    /**
     * Draws this farm pen item.
     * @param  g  the graphics context in which to draw this item.
     */
    public void draw(GraphicsContext g) {
        System.out.println("Brown stuff");
        drawString(g, this.getAppearance(), this.getX(), this.getY());
    }

    /** Finds an Egg for the Farmer */
    public static Egg anEggisHere() {
        for (int r = 0; r != FarmThing.myFarmThings.length; r++)
            for (int c = 0; c != FarmThing.myFarmThings[0].length; c++)
                if (FarmThing.myFarmThings[r][c] instanceof Egg) { return (Egg) FarmThing.myFarmThings[r][c]; }
        return null;
    }
}
