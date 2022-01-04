public class Product {
    private String productName;
    private String serial;
    private String description;
    private double price;
    private boolean isInStoke;
    private double vipPrice;

    public Product(String productName, String serial, String description, double price, boolean isInStoke, double discount) {
        if (price < 0)
            throw new IllegalArgumentException("price can't be negative");

        this.productName = productName;
        this.serial = serial;
        this.description = description;
        this.price = price;
        this.isInStoke = isInStoke;
        this.vipPrice = (1 - discount) * price;
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

    public void setDiscount(double discount) {
        this.vipPrice = (1-discount)*this.price;
    }

    public double getPrice(boolean isVip) {
        return isVip ? this.vipPrice : this.price;
    }

    public void setPrice(double price) {
        if (price >= 0) {
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

    public double getDiscount() {
        return 1-vipPrice/price;
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(this.productName).append(" price: ").append(this.price);
        return output.toString();
    }
}
