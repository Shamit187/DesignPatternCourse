package Product.CommSystem;

import Product.Product;

public abstract class CommSystem extends Product {
    protected static int CommCount = 0;

    public abstract double getYearlyCost();
    public abstract void setYearlyCost(double newCost);
}
