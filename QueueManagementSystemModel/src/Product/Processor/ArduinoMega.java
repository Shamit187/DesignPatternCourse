package Product.Processor;

public class ArduinoMega extends Processor{
    protected static final String ProductType = "ArduinoMega#";
    protected static double ArduinoMega_price = 50.0;

    public ArduinoMega() {
        ProcessorCount++;
        productID = ProductType + Integer.toString(ProcessorCount);
    }


    @Override
    public void changeProductPrice(double newPrice) {
        ArduinoMega_price = newPrice;
    }

    @Override
    public double getPrice() {
        return ArduinoMega_price;
    }
}
