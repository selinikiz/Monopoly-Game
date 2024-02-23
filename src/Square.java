public class Square {

    // this method is overrided in some of the subclasses with appropriate endings
    public String givemessage(Player player1, Player player2, Player realplayer,String dice) {
        return (realplayer.getName()+"\t"+dice+"\t"+realplayer.getPosition()+"\t"+player1.getMoney()+"\t"+player2.getMoney()+"\t");
    }
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


}
