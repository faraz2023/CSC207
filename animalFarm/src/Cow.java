import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Cow extends Animal{

    /**
     * Constructs a new Cow
     */

    public Cow() {
        super(false);
        this.setColor(Color.PINK.darker().darker());
        this.setAppearance("MOO");
    }

  /** Helps animal clear stomach. */
  public final void clearStomach() {
    if (!(FarmThing.myFarmThings[this.getX()][this.getY()] instanceof Animal)) {
      if (!(FarmThing.myFarmThings[this.getX()][this.getY()] instanceof Human)) {
        System.out.println("Cow stink");

        AnimalManure newManure = new AnimalManure();
        newManure.setAppearance("&");
        newManure.setLocation(this.getX(), this.getY());
        int x = this.getX();
        int y = this.getY();
        this.move();
        FarmThing.myFarmThings[x][y] = newManure;
      }
    }
  }
}
