package Factory;

import Product.Product;
import Product.IProductEnum;

public interface IFactory {
    Product getProduct(IProductEnum productType);
}
