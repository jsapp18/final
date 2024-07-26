import java.lang.classfile.Label;
import javafx.geometry.Insets;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

//makes a stack of cards using random events found here. Will addd more before final submission
public class CardDeck extends StackPane{
    private String[][] eventText = {
        {"There is a zombie up ahead, with a knife through its hand.", "While trying to eliminate the zombie, You gets stabbed in the arm", "You sneak around - not worth the trouble"},
        {"As you walk past, you hear the sound of voices in a boarded house", "You walk away with supplies in tow, but your sins weigh heavier", "While they might have had plenty of supplies, your morals are still around"},
        {"The infected are in a group surrounding you, but haven't noticed you yet", "You found some food in the aftermath, but suffered some cuts and bruises", "Best to slip out un-noticed, but you see that they were surrounding some canned goods."},
        {"You encounter an infected child, holding a small toy plane", "You wish you could have helped, but atleast the child had a water bottle", "While running you fall and sprain your ankle, but find a protein bar"},
        {"You see a single zombie in the distance", "Easy kill", "No need to mess with it..."},
        {"You meet a child, with their family (swipe left for hard mode... just takes longer to win)","You are a horrible person","They give you some soup as thanks"},
        {"Your being chased by a giant boulder!", "You broke your foot trying to stop the boulder", "That left you winded, but you are fine"},
        {"When climbing to the top of the house, you notice a can of soup on the roof (swipe left to display game over message)", "You dont feel so good", "Probably shouldnt eat that"}

    };
    private reward[][] reward = {
        {new reward("health", -10), new reward("health", 10)},
        {new reward("sanity", -60), new reward("sanity", 20)},
        {new reward("hunger", 10), new reward("health", 20)},
        {new reward("thirst", 20), new reward("hunger", 10)},
        {new reward("sanity", 20), new reward("health", 10)},
        {new reward("sanity", -200), new reward("hunger", 10)},
        {new reward("health", -30), new reward("hunger", -20)},
        {new reward("health", -150), new reward("thirst", -20)}
    };

    private player the_player;
    private progress player_progress;
    private javafx.scene.control.Label output;
    //creates the card stack
    public CardDeck(progress pg, player p, javafx.scene.control.Label op) {
        this.output = op;
        this.the_player = p;
        this.player_progress = pg;
        for (int i = 0; i < 25; i++) {
            game_events cardeventmaker = new game_events();
            cardeventmaker.randomize_event(eventText, reward);
            Card card = new Card(cardeventmaker.getET(), cardeventmaker, this);
            getChildren().add(card);
        }
    }
    //identifies direction card is swiped, then handles it
    public void handle_card_swiped(double direction, game_events r){
        if(direction == -600.0){
            the_player.card_result_handling(r.getR1(), player_progress);
            output.setText(r.getE1());
        }else{
            the_player.card_result_handling(r.getR2(), player_progress);
            output.setText(r.getE2());
        }
    }
}