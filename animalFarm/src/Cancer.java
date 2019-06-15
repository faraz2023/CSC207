import javafx.scene.paint.Color;

/**
 * Cancer class extends Animal
 */
public class Cancer extends Animal {

    /**
     * constructs a new Cancer
     */
    public Cancer(){
        super(true);
        this.setAppearance("^");
    this.setColor(Color.GREEN);
    }

    /** moves this Cancer object with a tragic twist. */
    public void move(){
        super.move();
        if (Math.random() < 0.05) {
          if (this.getY() != 0) {
            FarmThing.myFarmThings[this.getX()][this.getY() - 1] = new Cancer();
            FarmThing.myFarmThings[this.getX()][this.getY() - 1].setLocation(
                this.getX(), this.getY() - 1);
          }
        }
        if (Math.random() < 0.05) {
          if (this.getY() != 640 / 6 - 1) {
            FarmThing.myFarmThings[this.getX()][this.getY() + 1] = new Cancer();
            FarmThing.myFarmThings[this.getX()][this.getY() + 1].setLocation(
                this.getX(), this.getY() + 1);
          }
        }
    }
}
