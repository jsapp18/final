import javafx.scene.control.Alert;

public class progress {
    //variables
    private int game_progress;
    private int difficulty;
    private boolean buff;
//constructor
    progress(){
        this.game_progress = 0;
        this.difficulty = 1;
        this.buff = false;
    }
//setters and getters
    public void setGP(int gp){
        this.game_progress = gp;
    }
    
    public void setD(int d){
        this.difficulty = d;
    }

    public void setB(boolean b){
        this.buff = b;
    }

    public int getGP(){
        return game_progress;
    
    }
    public int getD(){
        return difficulty;
    }

    public boolean getB(){
        return buff;
    }
    //ends the game




    //checks if the game is over
    public boolean endGame(int holder){
        if (holder <= 0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("You lost...");
            alert.setContentText("Game over");
            alert.showAndWait();
            return true;
        }else if(holder >= 150){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("You Made It! You Won!");
            alert.setContentText("Congrats!!!");
            alert.showAndWait();
            return true;
        }else{
            return false;
        }
    }
    
}
