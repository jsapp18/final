
import java.util.Random;

public class player {
    //variables
    private int health;
    private int sanity;
    private int hunger;
    private int thirst;
    private MovableBar hp;
    private MovableBar s;
    private MovableBar h;
    private MovableBar t;
//constructor
    player(MovableBar hp, MovableBar s, MovableBar h, MovableBar t){
        this.health = 100;
        this.sanity = 100;
        this.hunger = 100;
        this.thirst = 100;
        this.hp = hp;
        this.s = s;
        this.h = h;
        this.t = t;
    }
//setters and getters
    public void setHP(int hp){
        this.health = hp;
    }
    public void setS(int s){
        this.sanity = s;
    }
    public void setH(int h){
        this.hunger = h;
    }
    public void setT(int t){
        this.thirst = t;
    }

    public int getHP(){
        return health;
    }
    public int getS(){
        return sanity;
    }
    public int getH(){
        return hunger;
    }
    public int getT(){
        return thirst;
    }
    //retrieves the reward / penalty for the card after an action is taken, and then computes it while checking if the game is over
    public void card_result_handling(reward card_reward, progress game_overall){
        if(card_reward.getPA() == "health"){
            int holder = this.getHP() + card_reward.getSV();
            if(game_overall.getB()){
                holder = 100;
                game_overall.setB(false);
            }
            if(holder > 100 || holder <= 0){
                if(game_overall.endGame(holder) == false){
                    holder = 100;
                    this.setHP(holder);
                    hp.increment(holder);
                }else{
                    game_overall.endGame(holder);
                    hp.increment(holder);
                }
            }else{
                this.setHP(holder);
                hp.increment(holder);
            }
        }else if(card_reward.getPA() == "hunger"){
            int holder = this.getH() + card_reward.getSV();
            if(holder > 100 || holder <= 0){
                if(game_overall.endGame(holder) == false){
                    holder = 100;
                    this.setH(holder);
                    h.increment(holder);
                }else{
                    game_overall.endGame(holder);
                    h.increment(holder);
                }
            }else{
                this.setH(holder);
                h.increment(holder);
            }
        }else if(card_reward.getPA() == "sanity"){
            int holder = this.getS() + card_reward.getSV();
            if(card_reward.getSV() >= 0){
                Random random = new Random();
                if(random.nextInt(11) % 2 == 0){
                    game_overall.setB(true);
                }
            }
            if(holder >= 100 || holder <= 0){
                if(holder <= 0){
                    holder = 100;
                    game_overall.setD(5);
                    this.setS(holder);
                    s.increment(holder);
                }else{
                    s.increment(holder);
                }
            }else{
                this.setS(holder);
                s.increment(holder);
            }
        }else if(card_reward.getPA() == "thirst"){
            int holder = this.getT() + card_reward.getSV();
            if(holder > 100 || holder <= 0){
                if(game_overall.endGame(holder) == false){
                    holder = 100;
                    this.setT(holder);
                    t.increment(holder);
                }else{
                    game_overall.endGame(holder);
                    t.increment(holder);
                }
            }else{
                this.setT(holder);
                t.increment(holder);
            }
        }
        if(game_overall.getD() >= 2){
            game_overall.setGP(game_overall.getGP() + 3);
            game_overall.endGame(game_overall.getGP());
        }else{
        game_overall.setGP(game_overall.getGP() + 5);
        game_overall.endGame(game_overall.getGP());
        }
    }
}
