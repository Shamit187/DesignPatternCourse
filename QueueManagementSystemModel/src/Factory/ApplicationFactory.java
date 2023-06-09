package Factory;

import Product.Application.DefaultApplication;
import Product.Application.EApplication;
import Product.Product;
import Product.IProductEnum;

public class ApplicationFactory implements IFactory{
    @Override
    public Product getProduct(IProductEnum productType) {
        if(productType == EApplication.DEFAULT){
            return new DefaultApplication();
        }else{
            return null;
        }
    }
}
