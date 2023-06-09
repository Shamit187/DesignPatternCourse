package Product.CommSystem;

public class WifiModule extends CommSystem{
    protected static final String ProductType = "Wifi_Module#";
    protected static double Wifi_price = 50.0;

    protected static double WifiYearlyCost = 2.0;

    public WifiModule() {
        CommCount++;
        productID = ProductType + Integer.toString(CommCount);
    }


    @Override
    public void changeProductPrice(double newPrice) {
        Wifi_price = newPrice;
    }

    @Override
    public double getPrice() {
        return Wifi_price;
    }

    @Override
    public double getYearlyCost() {
        return WifiYearlyCost;
    }

    @Override
    public void setYearlyCost(double newCost) {
        WifiYearlyCost = newCost;
    }
}
