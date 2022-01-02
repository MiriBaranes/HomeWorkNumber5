public class Product {
    private String productName;
    private String serial;
    private String description;
    private double price;
    private boolean isInStoke;

    public Product(String productName,String serial,String description,double price,boolean isInStoke){
        this.productName=productName;
        this.serial=serial;
        this.description=description;
        if (price>=0) {
            this.price = price;
        }
        this.isInStoke=isInStoke;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price>=0) {
            this.price = price;
        }
    }

    public boolean isInStoke() {
        return isInStoke;
    }

    public void setInStoke(boolean inStoke) {
        isInStoke = inStoke;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String toString(){
        StringBuilder output= new StringBuilder();
        output.append(this.productName).append(" price: ").append(this.price);
        return output.toString();
    }
}
