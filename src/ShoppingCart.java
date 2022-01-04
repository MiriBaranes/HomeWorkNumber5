import java.util.Arrays;

public class ShoppingCart {
    private ProductInCart [] products;
    private double price;
    private double discount;

    public ShoppingCart() {
        this.products = new ProductInCart[0];
        this.discount=0;
    }
    public ShoppingCart(double discount) {
        this.products = new ProductInCart[0];
        this.discount=discount;
    }
    public void setDiscount(double discount){
        this.discount=discount;
    }
    public ProductInCart[] getProducts() {
        return products;
    }
    public void addProduct(Product product, int quantity) {
        this.addProducts(product, quantity);
    }

    public double getPrice(){
        this.price=0;
        for (int i=0; i<products.length; i++){
            this.price+=products[i].getPrice()-(products[i].getPrice()*this.discount);
        }
        return this.price;
    }
    public Object[] addToArray(Object[] oldArray, Object toAdd) {
        Object[] newArray = new Object[oldArray.length + 1];
        for (int i = 0; i < oldArray.length; i++) {
            newArray[i] = oldArray[i];
        }
        newArray[oldArray.length] = toAdd;
        newArray= Arrays.asList(newArray).toArray(oldArray);
        return newArray;
    }
    public void printNumericalArray(Object[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println((i + 1) + " - " + array[i]);
        }
    }
    public void addProducts(Product product, int quantity, boolean isVip) {
        ProductInCart pic = new ProductInCart(product, quantity);
        this.products = (ProductInCart[]) addToArray(this.products, pic);
        this.price += pic.getPrice(isVip);
    }
    public String toString (){
        StringBuilder output = new StringBuilder();
        for (int i=0; i<products.length; i++){
            output.append(i+1).append(". ").append(products[i]);
        }
        output.append(" \ntotal price: ").append(getPrice());
        return output.toString();
    }




}