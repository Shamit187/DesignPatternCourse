package Product.Application;

public class DefaultApplication extends Application{
    protected static final String ProductType = "Default_Application#";
    protected static double Application_price = 15.0;

    public DefaultApplication() {
        ApplicationCount++;
        productID = ProductType + Integer.toString(ApplicationCount);
    }


    @Override
    public void changeProductPrice(double newPrice) {
        Application_price = newPrice;
    }

    @Override
    public double getPrice() {
        return Application_price;
    }
}
