package Product.CommSystem;

public class SimCard extends CommSystem{
    protected static final String ProductType = "Sim_Card#";
    protected static double Sim_price = 10.0;

    protected static double SimYearlyCost = 5.0;

    public SimCard() {
        CommCount++;
        productID = ProductType + Integer.toString(CommCount);
    }


    @Override
    public void changeProductPrice(double newPrice) {
        Sim_price = newPrice;
    }

    @Override
    public double getPrice() {
        return Sim_price;
    }

    @Override
    public double getYearlyCost() {
        return SimYearlyCost;
    }

    @Override
    public void setYearlyCost(double newCost) {
        SimYearlyCost = newCost;
    }
}
