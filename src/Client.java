public class Client extends User {
    private boolean isVIP;


    public Client(String firstName, String lastName, String username, String password, boolean isVIP) {
        super(firstName, lastName, username, password, Rank.CUSTOMER.getValue());
        this.isVIP = isVIP;
    }
    public Client(){
    }

    @Override
    public void login() {
        System.out.println("Hello " + this.getFirstName() + " " + this.getLastName() +
                (this.isVIP() ? "VIP" : ""));
        Product[] productsInStock = inStock();
        boolean start = true;

        while (true) {
            printNumericalArray(productsInStock);
            int choice = getIntInput("Enter a int of product for exit press -1", x -> (productsInStock.length < x && x > 1) || x == -1);
            ShoppingCart cart = new ShoppingCart();
            if (choice != NOT_EXIST_INDEX) {
                int indexOfProduct = choice - 1;
                Product productUserChoice = productsInStock[indexOfProduct];
                int quantity = getIntInput("Enter quantity", x -> x > 0);
                cart.addProducts(productUserChoice, quantity);
                System.out.println(cart);
            } else {
                System.out.println("Final list: " + cart);
                this.addShoppingToArr(cart);
                start = false;
                break;
            }
        }
    }

    public boolean isVIP() {
        return isVIP;
    }

    public void setVIP(boolean VIP) {
        isVIP = VIP;
    }

    public String toString () {
            StringBuilder output = new StringBuilder(super.toString());
            if (isVIP) {
                output.append(" (VIP)");
            }
            return output.toString();
        }

}
