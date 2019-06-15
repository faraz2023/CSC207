public class Animal extends FarmThing {
    public boolean goingRight;
    public boolean goingUp;

    /**
     *  Constructs an Animal Object.
     * @param goingRight
     * @param goingUp
     */
    public Animal(boolean goingRight, boolean goingUp){
        super();
        this.goingRight = goingRight;
        this.goingUp = goingUp;
    }

    /**
     *  Constructs an Animal Object.
     * @param goingRight
     */
    public Animal(boolean goingRight){
        super();
        this.goingRight = goingRight;
    }

    /** turns this Animal Object. */
    protected void turnAround() {
        goingRight = !goingRight;
        this.setAppearance(reverseAppearance());
    }

    /** Causes this item to take its turn in the farm-pen simulation. */
    public void move() {

        double   d3 = Math.random();
        if (d3 < 0.1) {
            turnAround();
        }

        // Move one spot to the right or left.
        if (goingRight) {
            if(this.getX() == (480/10) - 1){ turnAround(); }
            else{ this.setX(this.getX() + 1); }
        } else {
            if(this.getX() == 0){ turnAround(); }
            else{ this.setX(this.getX() - 1); }
        }

        // Sometimes we digest.
        double d = Math.random();
        if (d < 0.2) {
            clearStomach();
        }
    }

    /** Will Help animal clear stomach*/
    public void clearStomach(){ }
}
