import java.util.Random;
public class game_events{
    //variables
    private String event_text;
    private String event_sol1;
    private String event_sol2;
    public reward s1Reward;
    public reward s2Reward;
 

    public game_events(){}
    //probably wont use full constructor, but who knows
    public game_events(String et, String e1, String e2, reward s1, reward s2){
        this.event_text = et;
        this.event_sol1 = e1;
        this.event_sol2 = e2;
        this.s1Reward = s1;
        this.s2Reward = s2;
    }
    //setter functions
    public void setET(String et){
        this.event_text = et;
    }
    public void setE1(String e1){
        this.event_sol1 = e1;
    }
    public void setE2(String e2){
        this.event_sol2 = e2;
    }
    public void setR1(reward r1){
        this.s1Reward = r1;
    }
    public void setR2(reward r2){
        this.s2Reward = r2;
    }

    //getter functions
    public String getET(){
        return event_text;
    }
    public String getE1(){
        return event_sol1;
    }
    public String getE2(){
        return event_sol2;
    }
    public reward getR1(){
        return s1Reward;
    }
    public reward getR2(){
        return s2Reward;
    }
    //creates a random event
    public void randomize_event(String[][] events, reward[][] gains){
        Random random = new Random();
        int event_selector = random.nextInt(events.length);
        setET(events[event_selector][0]);
        setE1(events[event_selector][1]);
        setE2(events[event_selector][2]);
        setR1(gains[event_selector][0]);
        setR2(gains[event_selector][1]);
    }
}