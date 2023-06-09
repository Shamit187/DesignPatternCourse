public class Beef implements Burger{
    private static final double beefPrice  = 30.0;
    @Override
    public void serve() {
        System.out.println("Serving Beef Burger.");
    }

    @Override
    public double getPrice() {
        return beefPrice;
    }
}
