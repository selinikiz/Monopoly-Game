import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GameBegins {


    //command function reads commands and call applycommands/show function according to commands
    public static void command(File file) throws FileNotFoundException {
        ListJsonReader cards = new ListJsonReader();
        PropertyJsonReader reader = new PropertyJsonReader();
        reader.addsquares();
        PrintWriter writer = new PrintWriter("output.txt");
        Banker banker = new Banker();
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        String lastline = ""; // to check whether it includes show command or not
        Scanner read = new Scanner(file);
        while (read.hasNext()&&(!player1.getBankruptflag())&&(player1.getMoney()!=0) &&(player2.getMoney()!=0)&&(!player2.getBankruptflag())) {
            String[] lines = read.nextLine().split(";");
            if (lines[0].equals("show()")){
                Users.show(writer,player1,player2,banker);
            }
            else if (lines[0].equals("Player 1")) {
                writer.println(applycommands(cards,reader,writer,player1,player2,player1,player2,banker,lines[1]));
            }
            else if (lines[0].equals("Player 2")) {
                writer.println(applycommands(cards,reader,writer,player1, player2, player2, player1, banker, lines[1]));
            }
            lastline = lines[0];
        }
        if (!lastline.equals("show()")) {
            Users.show(writer,player1,player2,banker);
        }
        writer.close();

    }


    //applycommands function simply find square's propertys, and implement necessary methods
    public static String applycommands(ListJsonReader cards, PropertyJsonReader reader,PrintWriter writer,Player player1, Player player2,Player realplayer,Player otherplayer,Banker banker,String dice ) {
        String message = "";
        player1.setInitialmoney(player1.getMoney());
        player2.setInitialmoney(player2.getMoney());

        if (!((realplayer.getPosition()==11 && realplayer.getCount()!=4) || (realplayer.getPosition()==21 && realplayer.getParkcount()!=2) )) {
            int newposition = realplayer.getPosition() + Integer.parseInt(dice);
            if (newposition>40) {
                realplayer.setPosition(newposition-(40*(newposition/40)));
                realplayer.setMoney(realplayer.getMoney()+200); //when player finishes one tour, gets money in here
                banker.setMoney(banker.getMoney()-200);
            }
            else {
                realplayer.setPosition(newposition);
            }
        }

        for (Square square:reader.getSquares()) {
            if (square.getId()==realplayer.getPosition()) {
                //here, it matches squares with subclasses, and call subclass methods
                if (square instanceof Property) {
                    if ((!realplayer.getPlayerpro().contains(square))  && (!otherplayer.getPlayerpro().contains(square))) {
                        ((Property)square).buyproperty(realplayer,banker,square);
                        message = ((Property)square).buypropertymessage(square,player1,player2,realplayer,dice);
                    }
                    else if (realplayer.getPlayerpro().contains(square)) {
                        message = ((Property)square).haspropertymessage(square,player1,player2,realplayer,dice);
                    }
                    else if (otherplayer.getPlayerpro().contains(square)) {
                        ((Property)square).payrent(square,realplayer,otherplayer,dice);
                        message = ((Property)square).payrentmessage(square,player1,player2,realplayer,dice);
                    }
                }

                else if (square instanceof Tax) {
                    ((Tax) square).paytax(realplayer,banker);
                    message = (square.givemessage(player1,player2,realplayer,dice));
                }

                else if (square instanceof GotoJail) {
                    ((GotoJail) square).gotojail(realplayer);
                    message = (square.givemessage(player1,player2,realplayer,dice));
                }

                else if (square instanceof Jail) {
                    ((Jail) square).waitingjail(realplayer);
                    message= (square.givemessage(player1,player2,realplayer,dice));
                }

                else if(square instanceof FreeParking) {
                    ((FreeParking) square).waitingparking(realplayer);
                    message= (square.givemessage(player1,player2,realplayer,dice));
                }

                else if (square instanceof CommunityChest) {
                    ((CommunityChest)square).drawcommunity(realplayer,otherplayer,banker);
                    message = (((CommunityChest) square).givemessage(cards, player1, player2, realplayer, dice));
                }

                else if (square instanceof Chance) {
                    String outputline = ((Chance)square).drawchance(cards,reader,writer,player1, player2,realplayer,otherplayer,banker,dice);
                    message =(((Chance)square).givemessage(cards,player1, player2,realplayer,dice)+outputline);
                }

                else if (square instanceof Go) {
                    message = (square.givemessage(player1,player2,realplayer,dice));
                }
            }
        }
        return message;
    }

}

