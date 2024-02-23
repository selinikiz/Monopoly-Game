import java.io.PrintWriter;

public class Chance extends Action{
    public Chance(String item) {
        super(item);
    }
    public Chance(int id) {
        super(id);
    }

    //drawchance function apply rules in cards,if card's index is 1 or 2, it calls again the applycommand function to do instructions
    //local variable outputline is used to hold applycommands' output, in this way the print message cannot be mixed
    public String drawchance(ListJsonReader cards, PropertyJsonReader reader,PrintWriter writer,Player player1, Player player2,Player drawplayer,Player otherplayer, Banker banker,String dice) {
        String outputline = "";
        if (Player.getChanceindex()==0) {
            drawplayer.setPosition(1);
            drawplayer.setMoney(drawplayer.getMoney()+200);
            banker.setMoney(banker.getMoney()-200);
        }
        else if (Player.getChanceindex()==1) {
            if (drawplayer.getPosition()>27) {
                drawplayer.setMoney(drawplayer.getMoney()+200);
                banker.setMoney(banker.getMoney()-200);
            }
            drawplayer.setPosition(27);
            drawplayer.setPlayerdrawcard(true);// in this way, it will find the correct version to print in givemessage functions
            outputline = GameBegins.applycommands(cards,reader,writer,player1,player2,drawplayer,otherplayer,banker, "0"); //call function again to make duties
            //made dice 0, and record the first dice to print later
            drawplayer.setPlayerdrawcard(false);
        }
        else if(Player.getChanceindex()==2) {
            drawplayer.setPosition(drawplayer.getPosition()-3);
            drawplayer.setPlayerdrawcard(true);
            outputline = GameBegins.applycommands(cards,reader,writer,player1,player2,drawplayer,otherplayer,banker, "0");
            drawplayer.setPlayerdrawcard(false);

        }
        else if(Player.getChanceindex()==3) {
            drawplayer.setMoney(drawplayer.getMoney()-15);
            banker.setMoney(banker.getMoney()+15);
        }
        else if(Player.getChanceindex()==4) {
            drawplayer.setMoney(drawplayer.getMoney()+150);
            banker.setMoney(banker.getMoney()-150);
        }
        else if(Player.getChanceindex()==5) {
            drawplayer.setMoney(drawplayer.getMoney()+100);
            banker.setMoney(banker.getMoney()-100);
        }
        Player.setChanceindex(Player.getChanceindex()+1);
        return outputline;
    }


    @Override
    public String givemessage(ListJsonReader cards, Player player1, Player player2, Player realplayer, String dice) {
        if (!realplayer.goesbankrupt(realplayer)) {
            return (super.givemessage(player1, player2, realplayer, dice)+ realplayer.getName()+" draw "+ cards.getChancecards().get(Player.getChanceindex()-1).getItem());
        }
        else {
            return super.givemessage(player1, player2, realplayer, dice)+realplayer.getName()+" goes bankrupt";
        }
    }


}
