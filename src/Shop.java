import java.util.Arrays;
import java.util.Scanner;

public class Shop {
    public static final int EMPLOYEE_ACCOUNT = 0;
    public static final int CLIENT_ACCOUNT = 1;
    public static final int VIP = 1;
    public static final int NOT_VIP = 0;
    public static final int NOT_EXIST_INDEX = -1;
    private DynamicArray<User> users;
    private DynamicArray<Product> products;

    public Shop() {
        this.users = new DynamicArray<>(User.class);
        this.products = new DynamicArray<>(Product.class);
    }

    public Class<? extends User> storeUsers(int type_number) {
        Class<? extends User> type = null;
        if (type_number == 0)
            type = Employee.class;
        else // type_number == 1
            type = Client.class;
        return type;
    }

    public void currentUser() {
        int type = getIntInput("Press 0 for employee 1 for customer", x -> x == EMPLOYEE_ACCOUNT || x == CLIENT_ACCOUNT);
        String firstName = new ParserBaseFullName("Enter a your first name name").getInput();
        Class<? extends User> userType = storeUsers(type);
        String lastName = new ParserBaseFullName("Enter your last name: ").getInput();
        String username = new ParserBaseUsername("Enter a user name: ", this, userType).getInput();
        String password = new ParserBasePassword("Enter a password: ").getInput();
        User user1;
        if (type == CLIENT_ACCOUNT) {
            int UsersVIP = getIntInput("for vip tap 1, else 0", x -> x == VIP || x == NOT_VIP);
            boolean isVip = (UsersVIP == 1);
            user1 = new Client(firstName, lastName, username, password, isVip);
        } else {
            int typeOfEmployee = getIntInput("Enter the rank of your employee -\n" +
                    " 1- regular employee\n" +
                    " 2- manager\n" +
                    " 3- member of management", x -> 1 <= x && x <= 3);
            user1 = new Employee(firstName, lastName, username, password, typeOfEmployee);
        }
        this.users.addItem(user1);
    }

    public User loginToAnExistingAccount() {
        int kindOfBill = getIntInput("tap 0 to employee account\ntap 1 to customer account", x -> x == CLIENT_ACCOUNT || x == EMPLOYEE_ACCOUNT);
        Class<? extends User> type = storeUsers(kindOfBill);

        String userName = getInput("Enter your username");
        String password = getInput("Enter your password");
        int index = isExistAccount(type, userName, password);
        User user = null;
        if (index != NOT_EXIST_INDEX) {
            user = users.getItem(index);
            user.login();
        }
        return user;
    }

    public void employeeLogin(User employee) {
        System.out.println("Hello " + employee.getFirstName() + " " + employee.getLastName() +
                " " + ((Employee) employee).upperFirst(employee.getRank().name()));
    }

    public DynamicArray<Product> inStock() {
        DynamicArray<Product> productInStock = new DynamicArray<>(Product.class);
        for (int i = 0; i < products.length(); i++) {
            if (products.getItem(i).isInStoke()) {
                productInStock.addItem(products.getItem(i));
            }
        }
        return productInStock;
    }

    public boolean matchUser(User storeUsers, String username, String password) {
        boolean mach = false;
        if (storeUsers.getUsername().equals(username) && storeUsers.getPassword().equals(password)) {
            mach = true;
        }
        return mach;
    }

    private int isExistAccount(Class<? extends User> type, String username, String password) {
        int index = NOT_EXIST_INDEX;
        for (int i = 0; i < users.length(); i++) {
            if (users.getItem(i).getClass().equals(type)) {
                if (matchUser(users.getItem(i), username, password)) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }

    private String getInput(String request) {

        return new ParserBase(request).getInput();
    }

    private int getIntInput(String request, IntValidator validator) {
        Scanner scanner = new Scanner(System.in);
        int input;
        do {
            System.out.println(request);
            input = scanner.nextInt();
        } while (!validator.isValid(input));
        return input;
    }


    private void printNumericalArray(Object[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println((i + 1) + " - " + array[i]);
        }
    }

    public DynamicArray<User> getUsers() {
        return users;
    }
}
