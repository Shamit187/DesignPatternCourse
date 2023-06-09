public class DefaultCheese extends ExtraCheese{
    private static final double cheesePrice = 5.0;

    public DefaultCheese(Burger burger){
        super(burger);
    }
    @Override
    public void serve() {
        this.burger.serve();
        addCheese(burger);
    }

    @Override
    public double getPrice() {
        return this.burger.getPrice() + cheesePrice;
    }

    private void addCheese(Burger burger) {
        System.out.println("Serving with extra cheese.");
    }
}
