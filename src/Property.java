public abstract class Property extends Square{
    private String name;
    private int cost;
    private int rent;

    public abstract void rent(int rentvalue);

    public Property(int id, String name, int cost) {
        setId(id);
        setName(name);
        setCost(cost);
    }


    public void buyproperty( Player realplayer,Banker banker, Square square) {
        realplayer.getPlayerpro().add(square);
        realplayer.setMoney(realplayer.getMoney() - ((Property) square).getCost());
        banker.setMoney(banker.getMoney() + ((Property) square).getCost());
    }
    public void payrent(Square square, Player realplayer, Player otherplayer,String dice) {
        if (square instanceof Land) {
            ((Land) square).rent(((Property) square).getCost());
            realplayer.setMoney(realplayer.getMoney()-getRent());
            otherplayer.setMoney(otherplayer.getMoney()+getRent());
        }

        else if (square instanceof Company) {
            ((Company)square).rent(Integer.parseInt(dice));
            realplayer.setMoney(realplayer.getMoney()-getRent());
            otherplayer.setMoney(otherplayer.getMoney()+getRent());
        }

        else if (square instanceof Railroad) {
            int numofrailroad = 0;
            for (Square railsquare : otherplayer.getPlayerpro()) {
                if (railsquare instanceof Railroad) {
                    numofrailroad++;
                }
            }
            ((Railroad) square).rent(numofrailroad);
            realplayer.setMoney(realplayer.getMoney() - getRent());
            otherplayer.setMoney(otherplayer.getMoney() + getRent());
        }
    }

    public String payrentmessage(Square square,Player player1, Player player2, Player realplayer,String dice) {
        if (!realplayer.goesbankrupt(realplayer)) {
            if (realplayer.getPlayerdrawcard()) {
                return (" " + realplayer.getName()+" paid rent for " +((Property)square).getName());
            }
            else {
                return super.givemessage(player1, player2, realplayer, dice)+realplayer.getName()+" paid rent for "+((Property) square).getName();
            }
        }
        else {
            return super.givemessage(player1, player2, realplayer, dice)+realplayer.getName()+" goes bankrupt";
        }

    }
    public String buypropertymessage(Square square,Player player1, Player player2, Player realplayer,String dice) {
        if (!realplayer.goesbankrupt(realplayer)) {
            if (realplayer.getPlayerdrawcard()) {
                return (" " + realplayer.getName()+" bought " +((Property)square).getName());
            }
            else {
                return super.givemessage(player1, player2, realplayer, dice)+realplayer.getName()+" bought "+((Property) square).getName();
            }
        }
        else {
            return super.givemessage(player1, player2, realplayer, dice)+realplayer.getName()+" goes bankrupt";
        }

    }
    public String haspropertymessage(Square square,Player player1,Player player2, Player realplayer,String dice) {
        if (realplayer.getPlayerdrawcard()) {
            return (" " + realplayer.getName()+" has " +((Property)square).getName());
        }
        else {
            return super.givemessage(player1, player2, realplayer, dice)+realplayer.getName()+" has "+((Property) square).getName();
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }
    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }
}
