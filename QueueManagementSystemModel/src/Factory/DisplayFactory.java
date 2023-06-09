package Factory;

import Product.Display.EDisplay;
import Product.Display.LCD;
import Product.Display.LED;
import Product.Product;
import Product.IProductEnum;

public class DisplayFactory implements IFactory{
    @Override
    public Product getProduct(IProductEnum productType) {
        if (productType == EDisplay.LCD) {
            return new LCD();
        } else if (productType == EDisplay.LED) {
            return new LED();
        } else {
            return null;
        }
    }
}
