import javafx.scene.shape.Rectangle;
//this class makes it to where I can have stat bars to display the stats
public class MovableBar{
    private Rectangle resourceRect;
    private double maxResource = 100.0;

    public MovableBar(Rectangle resourceRect) {
        this.resourceRect = resourceRect;
    }

    private double getMR(){
        return maxResource;
    }
    //increments the stat bar based off of the stat and the percentage of stat left.
    public void increment(int rewardLevel) {
        double percentage = Math.max(Math.min(rewardLevel / maxResource, 1.0), 0.0);
        resourceRect.setWidth(196 * percentage);
    }
}
