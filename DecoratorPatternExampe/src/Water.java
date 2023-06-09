public class Water extends Drinks{
    private static final double waterPrice = 1.0;

    public Water(Burger burger){
        super(burger);
    }
    @Override
    public void serve() {
        this.burger.serve();
        addWater(burger);
    }

    @Override
    public double getPrice() {
        return this.burger.getPrice() + waterPrice;
    }

    private void addWater(Burger burger) {
        System.out.println("Serving with Water.");
    }
}
