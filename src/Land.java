public class Land extends Property{

    public Land(int id, String name, int cost) {
        super(id, name, cost);
    }
    @Override
    public void rent(int cost) {
        if (cost<=2000) {
            setRent((int) (cost*((double)40/100)));
        }
        else if ((2001<=cost) && (cost<=3000)) {
            setRent((int) (cost*((double)30/100)));
        }
        else if ((3001<=cost) && (cost<=4000)) {
            setRent((int) (cost*((double)35/100)));
        }
    }

}
