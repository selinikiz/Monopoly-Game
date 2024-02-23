public class CommunityChest extends Action{
    public CommunityChest(String item) {
        super(item);
    }
    public CommunityChest(int id) {
        super(id);
    }

    //drawcommunity function apply rules in community cards
    public void drawcommunity(Player drawplayer,Player otherplayer,Banker banker) {
        if (Player.getCommunindex() == 0) {
            drawplayer.setPosition(1);
            drawplayer.setMoney(drawplayer.getMoney()+200);
            banker.setMoney(banker.getMoney()-200);
        }
        else if (Player.getCommunindex()==1) {
            drawplayer.setMoney(drawplayer.getMoney() + 75);
            banker.setMoney(banker.getMoney() - 75);
        }
        else if (Player.getCommunindex()==2) {
            drawplayer.setMoney(drawplayer.getMoney()-50);
            banker.setMoney(banker.getMoney()+50);
        }
        else if (Player.getCommunindex()==3) {
            drawplayer.setMoney(drawplayer.getMoney() + 10);
            otherplayer.setMoney(otherplayer.getMoney() - 10);
        }
        else if (Player.getCommunindex() == 4) {
            drawplayer.setMoney(drawplayer.getMoney() + 50);
            otherplayer.setMoney(otherplayer.getMoney() - 50);
        }
        else if(Player.getCommunindex() ==5) {
            drawplayer.setMoney(drawplayer.getMoney()+20);
            banker.setMoney(banker.getMoney()-20);
        }
        else if(Player.getCommunindex()==6) {
            drawplayer.setMoney(drawplayer.getMoney()+100);
            banker.setMoney(banker.getMoney()-100);
        }
        else if(Player.getCommunindex()==7) {
            drawplayer.setMoney(drawplayer.getMoney()-100);
            banker.setMoney(banker.getMoney()+100);
        }
        else if(Player.getCommunindex()==8) {
            drawplayer.setMoney(drawplayer.getMoney()-50);
            banker.setMoney(banker.getMoney()+50);
        }
        else if(Player.getCommunindex()==9) {
            drawplayer.setMoney(drawplayer.getMoney()+100);
            banker.setMoney(banker.getMoney()-100);
        }
        else if(Player.getCommunindex()==10) {
            drawplayer.setMoney(drawplayer.getMoney()+50);
            banker.setMoney(banker.getMoney()-50);
        }
        Player.setCommunindex(Player.getCommunindex()+1);
    }

    @Override
    public String givemessage(ListJsonReader cards, Player player1, Player player2, Player realplayer, String dice) {
        String message ="";
        if ((!player1.goesbankrupt(player1)) && (!player2.goesbankrupt(player2))) {
            if (realplayer.getPlayerdrawcard()){ //if command comes from chance cards, it changes the message to add it to end
                message = (" "+realplayer.getName()+" draw "+cards.getCommunitycards().get(Player.getCommunindex()-1).getItem());
            }
            else {
                message= (super.givemessage(player1, player2, realplayer, dice)+ realplayer.getName()+" draw "+ cards.getCommunitycards().get(Player.getCommunindex()-1).getItem()) ;
            }
        }
        else if (player1.goesbankrupt(player1)) {
            message= super.givemessage(player1, player2, realplayer, dice)+player1.getName()+" goes bankrupt";
        }
        else if (player2.goesbankrupt(player2)) {
            message= super.givemessage(player1, player2, realplayer, dice)+player2.getName()+" goes bankrupt";
        }
        return message;
    }

}
