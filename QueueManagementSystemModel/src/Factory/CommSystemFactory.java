package Factory;

import Product.CommSystem.ECommSystem;
import Product.CommSystem.SimCard;
import Product.CommSystem.WifiModule;
import Product.Product;
import Product.IProductEnum;

public class CommSystemFactory implements IFactory{
    @Override
    public Product getProduct(IProductEnum productType) {
        if(productType == ECommSystem.SIMCARD){
            return new SimCard();
        }else if(productType == ECommSystem.WIFIMODULE){
            return new WifiModule();
        }else{
            return null;
        }
    }
}
