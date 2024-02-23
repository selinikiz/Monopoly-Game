public class GotoJail extends Square{
    public GotoJail(int id) {
        setId(id);
    }
    public void gotojail(Player player) {
        player.setPosition(11);
        player.setCount(player.getCount()+1);
    }

    @Override
    public String givemessage(Player player1, Player player2, Player realplayer, String dice) {
        return (super.givemessage(player1, player2, realplayer, dice)+realplayer.getName()+" went to jail");
    }
}
