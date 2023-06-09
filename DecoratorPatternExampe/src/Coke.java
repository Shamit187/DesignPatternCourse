public class Coke extends Drinks{
    private static final double cokePrice = 5.0;

    public Coke(Burger burger){
        super(burger);
    }
    @Override
    public void serve() {
        this.burger.serve();
        addCoke(burger);
    }

    @Override
    public double getPrice() {
        return this.burger.getPrice() + cokePrice;
    }

    private void addCoke(Burger burger) {
        System.out.println("Serving with Coke.");
    }
}
