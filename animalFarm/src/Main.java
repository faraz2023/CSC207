import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Our take on the "classical" game Farm Ville
 *
 */



public class Main extends Application {

    /**
     * The width of a character.
     */
    public final static int charWidth = 6;
    /**
     * The height of a character.
     */
    public final static int charHeight = 10;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("FarmVille");

        Group root = new Group();
        Scene theScene = new Scene(root);
        primaryStage.setScene(theScene);
        Canvas canvas = new Canvas(1024, 720);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        FarmThing farm = new FarmThing();

        FarmThing.myFarmThings[0][0] = new Chicken();    FarmThing.myFarmThings[0][0].setLocation(0,0);
        FarmThing.myFarmThings[6][12]= new Chicken();    FarmThing.myFarmThings[6][12].setLocation(6,12);
        FarmThing.myFarmThings[17][4]= new Chicken();    FarmThing.myFarmThings[17][4].setLocation(17,4);
        FarmThing.myFarmThings[15][28]= new Chicken();   FarmThing.myFarmThings[15][28].setLocation(15,28);
        FarmThing.myFarmThings[23][18]= new Chicken();   FarmThing.myFarmThings[23][18].setLocation(23,18);
        FarmThing.myFarmThings[16][35]= new Chicken();   FarmThing.myFarmThings[16][35].setLocation(16,35);
        FarmThing.myFarmThings[16][22]= new Chicken();   FarmThing.myFarmThings[16][22].setLocation(16,22);
        FarmThing.myFarmThings[10][20]= new Pig();       FarmThing.myFarmThings[10][20].setLocation(10,20);
        FarmThing.myFarmThings[20][10] = new Pig();      FarmThing.myFarmThings[20][10].setLocation(20,10);
        FarmThing.myFarmThings[15][15]= new Cow();       FarmThing.myFarmThings[15][15].setLocation(15,15);
        FarmThing.myFarmThings[30][30]= new Human();     FarmThing.myFarmThings[30][30].setLocation(30,30);
 //       FarmThing.myFarmThings[23][40]= new Cancer();     FarmThing.myFarmThings[23][40].setLocation(23,40);

        gc.clearRect(0, 0, 1024, 720);
        drawShapes(gc);

        Timeline gameLoop = new Timeline();
        gameLoop.setCycleCount(Timeline.INDEFINITE);
        final long timeStart = System.currentTimeMillis();
        Human.timeStart = timeStart;

        KeyFrame kf = new KeyFrame(
                Duration.seconds(0.05),
                new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent ae) {
                        double t = (System.currentTimeMillis() - timeStart) / 1000.0;

                        for(int a=0;a!=(int)(480/10);a++)
                            for(int b=0;b!=(int)(640/6);b++){
                                if (FarmThing.myFarmThings[a][b] != null)
                                    FarmThing.myFarmThings[a][b].move();
                                if((Human.chicken_manure_age[a][b] !=null)){
                                    if(System.currentTimeMillis() - Human.chicken_manure_age[a][b]>=10000){
                                        FarmThing.chicken_manure_age[a][b] = null;
                                        if(FarmThing.myFarmThings[a][b] instanceof AnimalManure)
                                            FarmThing.myFarmThings[a][b] = new FarmThing();
                                    }
                                }
                            }
                        // Clear the canvas
                        gc.clearRect(0, 0, 1024, 720);
                        drawShapes(gc);
                    }
                });

        gameLoop.getKeyFrames().add(kf);
        gameLoop.play();
        primaryStage.show();
    }

  private void drawShapes(GraphicsContext gc) {
    // Tell all the farmyard items to draw themselves.
    for (int a = 0; a != (480 / 10); a++)
      for (int b = 0; b != (640 / 6); b++)
        if (FarmThing.myFarmThings[a][b] != null) FarmThing.myFarmThings[a][b].draw(gc);
        }
}
