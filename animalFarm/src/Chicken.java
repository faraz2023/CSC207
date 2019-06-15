import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Chicken extends Animal {

  /** Constructs a new Chicken. */
  public Chicken() {
    super(true,true);
    this.setColor(Color.RED);
    this.setAppearance("/'/>");
  }

  /** Turns this chicken around, causing it to reverse direction. */
  protected void turnAroundVertical() {
    goingUp = !goingUp;
  }

  /** moves this animal vertically and horizontally. */
  public void move() {

    // Sometimes food doesn't sit well in the stomach, so I have to clear my stomach
    double d1 = Math.random();
    if (d1 < 0.2) {
      clearStomach();
    }
    // Move one spot to the right or left.
    if (goingRight) {
      if(this.getX() == (480/10) - 1){ turnAround(); }
      else{ this.setX(this.getX() + 1); }
    } else {
      if(this.getX() == 0){ turnAround(); }
      else{ this.setX(this.getX() - 1); }
    }

    // Move one spot to the up or down.
    if (goingUp) {
      if(this.getY() == (640/6) - 1){ turnAroundVertical(); }
      else{ this.setY(this.getY() + 1); }
    } else {
      if(this.getY() == 0){ turnAroundVertical(); }
      else{ this.setY(this.getY() - 1); }
    }
    double d2 = Math.random();
    if (d2 < 0.1) {
      layEgg();
    }
    double d3 = Math.random();
    if (d3 < 0.1) {
      turnAround();
    }
    if(d1 > 0.8) {
      turnAroundVertical();
    }
  }

  /** Lay an egg. */
  private void layEgg() {
    if (!(FarmThing.myFarmThings[this.getX()][this.getY()] instanceof Animal)) {
      if (!(FarmThing.myFarmThings[this.getX()][this.getY()] instanceof Human)) {
        System.out.println("Breakfast! " + "Egg loc: " + this.getX() + " " + this.getY());

        Egg egg = new Egg();

        egg.setLocation(this.getX(), this.getY());

        FarmThing.myFarmThings[this.getX()][this.getY()] = egg;
      }
    }
  }

  /** Finish digesting*/
  public final void clearStomach() {
    if (!(FarmThing.myFarmThings[this.getX()][this.getY()] instanceof Animal)) {
      if (!(FarmThing.myFarmThings[this.getX()][this.getY()] instanceof Human)) {
        System.out.println("New stuff to make things grow.");

        AnimalManure newManure = new AnimalManure();
        newManure.setAppearance(".");
        newManure.setLocation(this.getX(), this.getY());
        int x = this.getX();
        int y = this.getY();
        this.move();
        FarmThing.myFarmThings[x][y] = newManure;
        FarmThing.chicken_manure_age[this.getX()][this.getY()] = System.currentTimeMillis();
      }
    }
  }
}
