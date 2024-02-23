public class Go extends Square{
    public Go(int id) {
        setId(id);
    }

    @Override
    public String givemessage(Player player1, Player player2, Player realplayer, String dice) {
        return (super.givemessage(player1, player2, realplayer, dice)+realplayer.getName()+" is in GO square");
    }
}
