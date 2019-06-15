import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Animal Food, Parent is Farmthing
 */

public class AnimalFood extends FarmThing{
    /** Use for random movement left and right.  */
    private int windUp;
    private int windLeft;

    /**cunstructs an AnimalFood */
    public AnimalFood() {
        super();
        super.setColor(Color.GRAY.darker().darker().darker());
        // start off with o as the appearance cause all animal food looks the same
        super.setAppearance("%");
    }

    /** methods for the movement of the AnimalFood object */
    public void move(){
        this.windUp = Wind.windBlowingUp();
        this.windLeft = Wind.windBlowingLeft();
        if(windUp == 1) if(this.getY() != (640/6) - 1) this.setLocation(this.getX(), this.getY() + 1);
        if(windUp == -1) if(this.getY() != 0) this.setLocation(this.getX(), this.getY() - 1);
        if(windLeft == 1) if(this.getX() != (480/10) - 1) this.setLocation(this.getX() + 1, this.getY());
        if(windLeft == -1) if(this.getX() != 0) this.setLocation(this.getX() - 1, this.getY());

    }

}
