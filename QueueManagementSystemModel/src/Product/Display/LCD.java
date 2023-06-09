package Product.Display;

public class LCD extends Display{
    protected static final String ProductType = "LCD_Panel#";
    protected static double LCD_price = 40.0;

    public LCD() {
        displayCount++;
        productID = ProductType + Integer.toString(displayCount);
    }


    @Override
    public void changeProductPrice(double newPrice) {
        LCD_price = newPrice;
    }

    @Override
    public double getPrice() {
        return LCD_price;
    }
}
