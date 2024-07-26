public class reward{
    //variables
    private String player_attribute;
    private int stat_value;

    reward(){}

    reward(String attr, int num){
        this.player_attribute = attr;
        this.stat_value = num;
    }
    //setters and getters
    public String getPA(){
        return player_attribute;
    }

    public int getSV(){
        return stat_value;
    }

    public void setPA(String attr){
        this.player_attribute = attr;
    }

    public void setSV(int num){
        this.stat_value = num;
    }

}
