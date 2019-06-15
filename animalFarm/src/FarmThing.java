import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class FarmThing {
    /**
     * (int)(640/6) columns, (int)(480/10) rows.
     */
    public static FarmThing[][] myFarmThings = new FarmThing[(480 / 10)][(640 / 6)];
    //public static ArrayList<ArrayList<FarmThing>> myFarmThings = new ArrayList<>();
    public static Long[][] chicken_manure_age = new Long[(int) (480 / 10)][(int) (640 / 6)];
    public static long timeStart;

    private String appearance;
    private int x;
    private int y;
    private Color color;

    public FarmThing(){
        this.appearance = null;
        this.setLocation(0,0);
    }

    /**
    General Setters here
     */
    public void setX(int x){this.x = x;}
    public void setY(int y){this.y = y;}
    public void setColor(Color c){this.color = c;}
    public void setAppearance(String s){this.appearance =s;}
    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     General getters here
     */
    public int getX(){return this.x;}
    public int getY(){return this.y;}
    public String getAppearance(){return this.appearance;}
    public Color getColor() { return color;}

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
        g.setFill(this.getColor());
        g.fillText(s, x * 10, y * 6);
    }

    /**
     * Draws this farm pen item.
     *
     * @param  g  the graphics context in which to draw this item.
     */
    public void draw(GraphicsContext g) {
        drawString(g, appearance, x, y);
    }

    /**
     * reverses the appearance of this FarmThing Object
     * @return String the reversed of this FarmThing appearance
     */
    public String reverseAppearance() {
        String reverse = "";
        for (int i=this.getAppearance().length()-1; i>=0; i--) {
            switch (this.getAppearance().charAt(i)) {
                case '\\': reverse += '/'; break;
                case '/': reverse += '\\'; break;
                case ')': reverse += '('; break;
                case '(': reverse += ')'; break;
                case '>': reverse += '<'; break;
                case '<': reverse += '>'; break;
                case '}': reverse += '{'; break;
                case '{': reverse += '}'; break;
                case '[': reverse += ']'; break;
                case ']': reverse += '['; break;
                default: reverse += this.getAppearance().charAt(i); break;
            }
        }

        return reverse;
    }

    /** just an abstract for move methods in other child classes. */
    public void move(){}

}
