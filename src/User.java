import java.util.Arrays;

public abstract class User extends Person {
    private String username;
    private String password;
    private ShoppingCart [] shoppingCarts;
    private double spent;
    private int amountOfPurchases;
    private Rank rank;


    public User(String firstName, String lastName, String username, String password,Rank rank) {
        super(firstName, lastName);
        this.username = username;
        this.password = password;
            this.shoppingCarts=new ShoppingCart[0];
            this.spent = 0;
            this.amountOfPurchases = 0;
            this.rank=rank;
    }
    public User(String firstName, String lastName, String username, String password, int rank) {
        this(firstName, lastName, username, password, Rank.fromInt(rank));
        if (!Rank.isValid(rank)) {
            throw new IllegalArgumentException("rank " + rank + " is not valid");
        }
    }

    public User(){
    }

    public double getDiscount() {
        return 1 - this.rank.getValue() * 0.1;
    }

    public String getPassword() {
        return password;
    }

    public ShoppingCart[] getShoppingCarts() {
        return shoppingCarts;
    }

    public void setShoppingCarts(ShoppingCart[] shoppingCarts) {
        this.shoppingCarts = shoppingCarts;
    }
    public abstract boolean isVIP();
    public String getUsername() {
        return username;
    }
    public  void startShopping(Shop shop){
        ShoppingCart cart = new ShoppingCart();
        shop.printProducts(this.isVIP());

        cart.addProducts(,,this.isVIP());

        addShoppingToArr(cart);
        double price = cart.getPrice()*this.getDiscount();
        spent+=price;
        amountOfPurchases++;
    }
    public abstract void login();
    public  void setSpent(){

    }
    public double getSpent(){
        return this.spent;
    }
    public void addShoppingToArr(ShoppingCart shoppingCart){
        this.shoppingCarts= (ShoppingCart[]) addToArray(this.shoppingCarts,shoppingCart);
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
    public Rank getRank() {
        return rank;
    }
    public boolean setRank(int rank) {
        if (Rank.isValid(rank)) {
            this.rank = Rank.fromInt(rank);
            return true;
        } else {
            System.out.println("Invalid selection");
            return false;
        }
    }
    public int getAmountOfPurchases(){
        return this.amountOfPurchases;
    }
    public String toString() {
        return  super.toString();
    }

}
