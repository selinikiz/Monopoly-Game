public abstract class Action extends Square{
    private String item;
    public Action(int id) {
        setId(id);
    }
    public Action(String item) {
        setItem(item);

    }
    public void setItem(String item) {
        this.item = item;
    }
    public String getItem() {
        return item;
    }


    public abstract String givemessage(ListJsonReader cards, Player player1, Player player2, Player realplayer, String dice);
}
