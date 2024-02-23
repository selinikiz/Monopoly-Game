import java.util.ArrayList;

public class Player extends Users{
    private static int chanceindex=0;
    private static int communindex=0;
    private int count =0;
    private int initialmoney;
    private int parkcount =0;
    private int position;
    private boolean playerdrawcard=false;
    private boolean bankruptflag = false;
    private ArrayList<Square> playerpro = new ArrayList<>(); //it gives player's properties

    Player(String player) {
        setName(player);
        setMoney(15000);
        setPosition(1);
    }

    public boolean getBankruptflag(){
        return bankruptflag;
    }

    public boolean goesbankrupt(Player player) {
        if (player.getMoney()<0) {
            player.setMoney(player.getInitialmoney());
            bankruptflag = true;
        }
        return bankruptflag;
    }

    public static void setChanceindex(int chanceindex) {
        Player.chanceindex = chanceindex;
    }

    public static int getChanceindex() {
        return chanceindex;
    }

    public static void setCommunindex(int communindex) {
        Player.communindex = communindex;
    }

    public static int getCommunindex() {
        return communindex;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public ArrayList<Square> getPlayerpro() {
        return playerpro;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setParkcount(int parkcount) {
        this.parkcount = parkcount;
    }

    public int getParkcount() {
        return parkcount;
    }
    public void setInitialmoney(int initialmoneyp) {
        this.initialmoney = initialmoneyp;
    }

    public int getInitialmoney() {
        return initialmoney;
    }
    public void setPlayerdrawcard(boolean playerdrawcard) {
        this.playerdrawcard = playerdrawcard;
    }
    public boolean getPlayerdrawcard() {
        return playerdrawcard;
    }

}

