public class ShoppingCart {
    private Product [] products;
    private double finalPrice;
    private Client client;

    public ShoppingCart(Client client){
        this.client=client;
        this.products=new Product[0];
        this.finalPrice=0;
    }
    public void addProduct(Product product){
        Product [] newProductArr = new Product[this.products.length+1];
        for (int i=0; i< this.products.length; i++){
            newProductArr[i]=this.products[i];
        }
        newProductArr[this.products.length]=product;
        this.products=newProductArr;
    }
    public void price(Product [] products){
        double price=0;
        for (int i=0; i< products.length; i++){
            price+=products[i].getPrice();
        }
        this.finalPrice=price;
    }


}
