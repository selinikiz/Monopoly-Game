public class Railroad extends Property{
    @Override
    public void rent(int numrailroads) {
        setRent(25*numrailroads);
    }

    public Railroad(int id, String name, int cost) {
        super(id, name, cost);
    }
}
