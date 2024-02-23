import java.io.PrintWriter;

public class Users {
    private String name;
    private int money;

    public static void show(PrintWriter writer,Player player1, Player player2, Banker banker) {
        writer.println("-------------------------------------------------------------------------------------------------------------------------");
        writer.print("Player 1\t"+player1.getMoney()+"\thave: ");
        if (player1.getPlayerpro().size()==0) {
            writer.println();
        }
        for (Square prop : player1.getPlayerpro()) {
            if (player1.getPlayerpro().get(player1.getPlayerpro().size()-1).equals(prop)) { //used to get rid of "," in the end
                writer.print(((Property) prop).getName()+"\n");
            }
            else {
                writer.print(((Property) prop).getName()+", ");
            }
        }

        writer.print("Player 2\t"+player2.getMoney()+"\thave: ");
        if (player2.getPlayerpro().size()==0) {
            writer.println();
        }
        for (Square prop : player2.getPlayerpro()) {
            if (player2.getPlayerpro().get(player2.getPlayerpro().size()-1) == prop) {
                writer.print(((Property) prop).getName()+"\n");
            }
            else {
                writer.print(((Property) prop).getName()+", ");
            }
        }

        writer.println("Banker\t" +banker.getMoney());
        if (player1.getMoney() > player2.getMoney()) {
            writer.println("Winner\tPlayer 1");
        }
        else {
            writer.println("Winner\tPlayer 2");
        }
        writer.println("-------------------------------------------------------------------------------------------------------------------------");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }
}
