public class FrenchFires extends Fries{
    private static final double frenchFriesPrice = 5.0;

    public FrenchFires(Burger burger){
        super(burger);
    }
    @Override
    public void serve() {
        this.burger.serve();
        addFrenchFries(burger);
    }

    @Override
    public double getPrice() {
        return this.burger.getPrice() + frenchFriesPrice;
    }

    private void addFrenchFries(Burger burger) {
        System.out.println("Serving with FrenchFires.");
    }
}
