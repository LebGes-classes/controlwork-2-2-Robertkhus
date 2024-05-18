import java.util.ArrayList;

public class TVChanel {
    private ArrayList<String> name = new ArrayList<>();
    private ArrayList<BroadcastsTime> broadcastsTime = new ArrayList<>();
    private String chanel;


    public ArrayList<BroadcastsTime> getBroadcastsTime() {
        return broadcastsTime;
    }

    public void setBroadcastsTime(ArrayList<BroadcastsTime> broadcastsTime) {
        this.broadcastsTime = broadcastsTime;
    }

    public ArrayList<String> getName() {
        return name;
    }

    public void setName(ArrayList<String> name) {
        this.name = name;
    }

    public String getChanel() {
        return chanel;
    }

    public void setChanel(String chanel) {
        this.chanel = chanel;
    }
}
