public class Coffee extends Drinks{
    private static final double coffeePrice = 15.0;

    public Coffee(Burger burger){
        super(burger);
    }
    @Override
    public void serve() {
        this.burger.serve();
        addCoffee(burger);
    }

    @Override
    public double getPrice() {
        return this.burger.getPrice() + coffeePrice;
    }

    private void addCoffee(Burger burger) {
        System.out.println("Serving with Coffee.");
    }
}
