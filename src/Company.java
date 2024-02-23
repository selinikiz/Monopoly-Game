public class Company extends Property{
    @Override
    public void rent(int dice) {
        setRent(dice*4);
    }

    public Company(int id, String name, int cost) {
        super(id, name, cost);
    }
}
