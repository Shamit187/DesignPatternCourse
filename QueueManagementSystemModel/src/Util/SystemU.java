package Util;

import Product.CommSystem.CommSystem;
import Product.Product;

import java.util.ArrayList;

public class SystemU {
    private final ArrayList<Product>productList;
    private int usedYears;
    private static int SystemCount = 0;
    private final int instanceNumber;

    public SystemU() {
        this.productList = new ArrayList<>();
        this.usedYears = 0;
        SystemCount++;
        instanceNumber = SystemCount;
    }

    public int getInstanceNumber() {
        return instanceNumber;
    }

    public void addProduct(Product product){
        productList.add(product);
    }

    public double getYearlyCost(){
        double yearlyCommCost = 0;
        for(int i = 0; i < productList.size(); i++){
            if(productList.get(i) instanceof CommSystem){
                CommSystem commProduct = (CommSystem) productList.get(i);
                yearlyCommCost = commProduct.getYearlyCost();
                break;
            }
        }
        return usedYears * yearlyCommCost;
    }

    public double getCost(){
        double totalCost = 0;
        for (Product product: productList){
            totalCost += product.getPrice();
        }
        return totalCost + getYearlyCost();
    }

    public void increaseUseYear(){
        usedYears++;
    }

    public String seeProductDescription(){
        StringBuilder productDescription = new StringBuilder();
        productDescription.append("System ID: " + instanceNumber + '\n');
        for (Product product: productList){
            productDescription.append(product.getProductID() + '\n');
        }
        productDescription.append("Product Usage: " + usedYears + " years\n");
        productDescription.append("Product Cost: " + getCost());
        return productDescription.toString();
    }
}
