package Factory;

import Product.Processor.ATMega32;
import Product.Processor.ArduinoMega;
import Product.Processor.EProcessor;
import Product.Processor.RaspberryPi;
import Product.Product;
import Product.IProductEnum;

public class ProcessorFactory implements IFactory{
    @Override
    public Product getProduct(IProductEnum productType) {
        if(productType == EProcessor.ARDUINO){
            return new ArduinoMega();
        }else if(productType == EProcessor.ATMEGA32){
            return new ATMega32();
        }else if(productType == EProcessor.RASPBERRY){
            return new RaspberryPi();
        }else{
            return null;
        }
    }
}
