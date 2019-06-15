import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * AnimalManure extends Farmthing
 */
public class AnimalManure extends FarmThing {

    /** Constructs an AnimalManure. */
    public AnimalManure() {
        super();
        super.setAppearance(".");
        super.setColor(Color.BLACK.darker().darker().darker());
    }

}
