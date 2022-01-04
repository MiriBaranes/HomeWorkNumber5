import java.util.Locale;

public class Employee extends User {
    private double discount;

    public Employee(String firstName, String lastName, String username, String password, int rank) {
        super(firstName, lastName, username, password, rank);
    }
    public Employee() {

    }

    public boolean isVIP(){
        return false;
    }
    // should be static
    public String upperFirst(String str){
        StringBuilder sb = new StringBuilder((str.charAt(0) + "").toUpperCase());
        str = str.toLowerCase(Locale.ROOT);
        for (int i = 1; i < str.length(); i++) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public String toString() {
        return super.toString() +" ["+ upperFirst(this.getRank().name())+"]";
    }
}
