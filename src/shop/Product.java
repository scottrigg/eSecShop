package shop;

/**
 * Created by mac on 16/6/26.
 */
public class Product {
    private String productID;
    private int price;
    private int stock;

    public Product(String productID, int price, int stock) {
        this.productID = productID;
        this.price = price;
        this.stock = stock;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
