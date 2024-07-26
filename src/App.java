import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javax.script.ScriptEngineManager;


public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage the_stage) throws Exception {
		//Making the basis of the screen
        StackPane stack_pane = new StackPane();
		VBox vertHolder = new VBox(10);
		HBox holder = new HBox(8);
		vertHolder.getChildren().add(holder);

		//Background image setup
		Image bg = new Image("Images/bg.jpg");
		BackgroundImage background = new BackgroundImage(bg, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, false));


		//All stat bar creation
		Rectangle hpb = new Rectangle(200, 20);
        hpb.setFill(null);
        hpb.setStroke(Color.BLACK);
        hpb.setStrokeWidth(2);

		Rectangle sb = new Rectangle(200, 20);
        sb.setFill(null);
        sb.setStroke(Color.BLACK);
        sb.setStrokeWidth(2);

		Rectangle hb = new Rectangle(200, 20);
        hb.setFill(null);
        hb.setStroke(Color.BLACK);
        hb.setStrokeWidth(2);

		Rectangle tb = new Rectangle(200, 20);
        tb.setFill(null);
        tb.setStroke(Color.BLACK);
        tb.setStrokeWidth(2);

		Rectangle healthPB = new Rectangle(196, 16);
        healthPB.setFill(Color.GREEN); 
        healthPB.setStroke(null); 

		Rectangle sanityPB = new Rectangle(196, 16);
        sanityPB.setFill(Color.GREEN); 
        sanityPB.setStroke(null);

		Rectangle thirstPB = new Rectangle(196, 16);
        thirstPB.setFill(Color.GREEN); 
        thirstPB.setStroke(null); 

		Rectangle hungerPB = new Rectangle(196, 16);
        hungerPB.setFill(Color.GREEN); 
        hungerPB.setStroke(null); 


		StackPane healthPane = new StackPane(healthPB, hpb);
		StackPane sanityPane = new StackPane(sanityPB, sb);
		StackPane hungerPane = new StackPane(hungerPB, hb);
		StackPane thirstPane = new StackPane(thirstPB, tb);


		healthPane.setRotate(270);
		sanityPane.setRotate(270);
		hungerPane.setRotate(270);
		thirstPane.setRotate(270);

		holder.getChildren().add(healthPane);
		holder.getChildren().add(sanityPane);
		holder.getChildren().add(hungerPane);
		holder.getChildren().add(thirstPane);


		MovableBar hpBar = new MovableBar(healthPB);
		MovableBar sBar = new MovableBar(sanityPB);
		MovableBar hBar = new MovableBar(hungerPB);
		MovableBar tBar = new MovableBar(thirstPB);

		//Getting the cards set up
		
		Label movementLabel = new Label();
        movementLabel.setStyle("-fx-background-color: white; -fx-padding: 20; -fx-border-color: black; -fx-border-width: 2;");
		player gamer = new player(hpBar, sBar, hBar, tBar);
		progress gameProgress = new progress();
		CardDeck cardDeck = new CardDeck(gameProgress, gamer,movementLabel);
		cardDeck.toFront();

		//creating the app
		StackPane text = new StackPane(movementLabel);
		BorderPane root = new BorderPane();
		stack_pane.getChildren().add(vertHolder);
		stack_pane.getChildren().add(cardDeck);
		stack_pane.autosize();
		root.setCenter(stack_pane);
		root.setBottom(text);
		root.setBackground(new Background(background));
		Scene scene = new Scene(root, 900, 680);
		the_stage.setTitle("ZombieCardGame");
		the_stage.setScene(scene);
		the_stage.show(); 
    }
}
