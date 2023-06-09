package Product.Display;

public class LED extends Display{

    protected static final String ProductType = "LED_Matrix#";
    protected static double LED_price = 5.0;

    public LED() {
        displayCount++;
        productID = ProductType + Integer.toString(displayCount);
    }


    @Override
    public void changeProductPrice(double newPrice) {
        LED_price = newPrice;
    }

    @Override
    public double getPrice() {
        return LED_price;
    }
}
