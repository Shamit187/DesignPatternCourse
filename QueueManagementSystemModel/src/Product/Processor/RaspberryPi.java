package Product.Processor;

public class RaspberryPi extends Processor{
    protected static final String ProductType = "Raspberry_Pi#";
    protected static double Raspberry_price = 100.0;

    public RaspberryPi() {
        ProcessorCount++;
        productID = ProductType + Integer.toString(ProcessorCount);
    }


    @Override
    public void changeProductPrice(double newPrice) {
        Raspberry_price = newPrice;
    }

    @Override
    public double getPrice() {
        return Raspberry_price;
    }
}
