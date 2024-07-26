import java.lang.classfile.instruction.ThrowInstruction;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

public class Card extends StackPane {
    private double startX;
    private double startY;
    private game_events card_info;
    public CardDeck home;
    //constrctor
    public Card(String text, game_events gm, CardDeck deck){
        this.card_info = gm;
        this.home = deck;
        Rectangle rect = new Rectangle(400, 200);
        rect.setArcWidth(20);
        rect.setArcHeight(20);
        rect.setFill(Color.WHITESMOKE);

        Text cardText = new Text(text);
        cardText.setWrappingWidth(380);
        cardText.setTextAlignment(TextAlignment.CENTER);
        getChildren().addAll(rect, cardText);
        

        setOnMousePressed(this::handleMousePressed);
        setOnMouseDragged(this::handleMouseDragged);
        setOnMouseReleased(this::handleMouseReleased);
    }
    //gets where you grabbed the card
    private void handleMousePressed(MouseEvent event) {
        startX = event.getSceneX();
        startY = event.getSceneY();
        toFront();
    }
    //handles the dragging of the card
    private void handleMouseDragged(MouseEvent event) {
        double offsetX = event.getSceneX() - startX;
        double offsetY = event.getSceneY() - startY;

        setTranslateX(getTranslateX() + offsetX);
        setTranslateY(getTranslateY() + offsetY);

        double rotation = offsetX / 10;
        setRotate(rotation);

        startX = event.getSceneX();
        startY = event.getSceneY();
    }
    //doublechecks when drag is released
    private void handleMouseReleased(MouseEvent event) {
        double offsetX = getTranslateX();
        if (Math.abs(offsetX) > 150) {
            swipeOffScreen(offsetX);
        } else {
            resetPosition();
        }
    }
    //played when the cad is swiped far enough, gets rid of the card and starts the card handling
    private void swipeOffScreen(double offsetX) {
        double endX = offsetX > 0 ? 600 : -600;
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(500), this);
        translateTransition.setToX(endX);
        translateTransition.setOnFinished(event -> {
            StackPane parent = (StackPane) getParent();
            parent.getChildren().remove(this);
        });
        translateTransition.play();
        home.handle_card_swiped(endX, card_info);
    }
    //puts the card back if not swiped far enough
    private void resetPosition() {
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(500), this);
        translateTransition.setToX(0);
        translateTransition.setToY(0);
        
        RotateTransition rotateTransition = new RotateTransition(Duration.millis(500), this);
        rotateTransition.setToAngle(0);
        
        translateTransition.play();
        rotateTransition.play();
    }
}