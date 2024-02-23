public class FreeParking extends Square{
    public FreeParking(int id) {
        setId(id);
    }
    public void waitingparking(Player player) {
        player.setParkcount(player.getParkcount()+1);
    }

    @Override
    public String givemessage(Player player1, Player player2, Player realplayer, String dice) {
        if (realplayer.getParkcount()==1) {
            return (super.givemessage(player1,player2,realplayer,dice)+realplayer.getName()+" is in Free Parking");
        }
        else {
            return (super.givemessage(player1,player2,realplayer,dice)+realplayer.getName()+" is in Free Parking (count=="+(realplayer.getParkcount()-1)+")");
        }
    }
}

