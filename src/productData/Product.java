package productData;

/**
 * Created by mac on 16/6/26.
 */
public class Product {
    private String productID;
    private int price;
    private int stock;
    private String statement;

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

    public boolean isAvaliable(){
        return stock > 0;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }
}
