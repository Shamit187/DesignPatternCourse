public class Chicken implements Burger{
    private static final double chickenPrice  = 20.0;
    @Override
    public void serve() {
        System.out.println("Serving Chicken Burger.");
    }

    @Override
    public double getPrice() {
        return chickenPrice;
    }
}
