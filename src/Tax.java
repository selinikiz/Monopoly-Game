public class Tax extends Square{
    public Tax(int id) {
        setId(id);
    }

    public void paytax(Player realplayer, Banker banker) {
        realplayer.setMoney(realplayer.getMoney()-100);
        banker.setMoney(banker.getMoney()+100);
    }

    @Override
    public String givemessage(Player player1, Player player2, Player realplayer, String dice) {
        if (!realplayer.goesbankrupt(realplayer)) {
            if (realplayer.getPlayerdrawcard()) {
                return (" " + realplayer.getName()+" paid tax");
            }
            else {
                return super.givemessage(player1, player2, realplayer, dice)+realplayer.getName()+" paid tax";
            }
        }
        else {
            return super.givemessage(player1, player2, realplayer, dice)+realplayer.getName()+" goes bankrupt";
        }
    }
}
