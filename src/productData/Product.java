package productData;

import java.io.Serializable;

/**
 * Created by mac on 16/6/26.
 */
public class Product implements Serializable{
    private String productID;
    private String name;
    private double price;
    private int stock;
    private String statement;

    public Product(String productID, String name, double price, int stock, String statement) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.statement = statement;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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

    @Override
    public String toString() {
        return "Product:" + productID
                + "," + name
                + "," + price
                + "," + stock
                + "," + statement;
    }

    public Product clone() {
        return new Product(this.productID,this.name,this.price, this.stock, this.statement);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        return productID != null ? productID.equals(product.productID) : product.productID == null;

    }
}
