public class OnionRings extends Fries{
    private static final double onionRingsPrice = 5.0;

    public OnionRings(Burger burger){
        super(burger);
    }
    @Override
    public void serve() {
        this.burger.serve();
        addOnionRings(burger);
    }

    @Override
    public double getPrice() {
        return this.burger.getPrice() + onionRingsPrice;
    }

    private void addOnionRings(Burger burger) {
        System.out.println("Serving with OnionRings.");
    }
}
