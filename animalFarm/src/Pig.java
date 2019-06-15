import javafx.scene.paint.Color;

public class Pig extends Animal {

    /**Constructs a new Pig. */
    public Pig() {
        super(true);
        this.setColor(Color.PINK.darker().darker().darker());
        this.setAppearance(":(8)");
    }

  /**Helps animal clear stomach. */
  public final void clearStomach() {
    if (!(FarmThing.myFarmThings[this.getX()][this.getY()] instanceof Animal)) {
      if (!(FarmThing.myFarmThings[this.getX()][this.getY()] instanceof Human)) {
        System.out.println("Pig stink");

        AnimalManure newManure = new AnimalManure();
        newManure.setAppearance("*");
        newManure.setLocation(this.getX(), this.getY());

        int x = this.getX();
        int y = this.getY();
        this.move();
        FarmThing.myFarmThings[x][y] = newManure;
      }
    }
  }
}
