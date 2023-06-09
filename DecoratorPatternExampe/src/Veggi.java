public class Veggi implements Burger{
    private static final double veggiPrice  = 10.0;
    @Override
    public void serve() {
        System.out.println("Serving Vegetable Burger.");
    }

    @Override
    public double getPrice() {
        return veggiPrice;
    }
}
