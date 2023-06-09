package Product.Processor;

public class ATMega32 extends Processor{
    protected static final String ProductType = "AtMega_32#";
    protected static double Atmega_price = 10.0;

    public ATMega32() {
        ProcessorCount++;
        productID = ProductType + Integer.toString(ProcessorCount);
    }


    @Override
    public void changeProductPrice(double newPrice) {
        Atmega_price = newPrice;
    }

    @Override
    public double getPrice() {
        return Atmega_price;
    }
}
