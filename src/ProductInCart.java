public class ProductInCart{
    private Product product;
    private int quantity;

    public ProductInCart(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getPrice(boolean isVip){
        return this.product.getPrice(isVip)*quantity;
    }
    public Product getProduct() {
        return product;
    }
    public int getQuantity() {
        return quantity;
    }
    public String toString(){
        return this.product.getProductName() +" * "+this.quantity+" price"+this.price;
    }
}
