public class Jail extends Square{
    public Jail(int id) {
        setId(id);
    }
    public void waitingjail(Player player) {
        player.setCount(player.getCount()+1);
    }


    @Override
    public String givemessage(Player player1, Player player2, Player realplayer, String dice) {
        if (realplayer.getCount()==1) {
            return(super.givemessage(player1, player2, realplayer, dice)+realplayer.getName() + " went to jail" );
        }
        else {
            return(super.givemessage(player1,player2,realplayer,dice)+realplayer.getName() + " in jail (count=="+(realplayer.getCount()-1)+")" );
        }
    }
}
