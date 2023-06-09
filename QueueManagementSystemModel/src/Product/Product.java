package Product;

public abstract class Product {
    protected String productID;

    public String getProductID() {
        return productID;
    }

    public abstract void changeProductPrice(double newPrice);
    public abstract double getPrice();
}
