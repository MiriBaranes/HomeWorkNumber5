import java.util.Scanner;

public class ParserBaseUsername extends ParserBase {
    private Class<? extends User> userType;

    public ParserBaseUsername(String request, Object helperData, Class<? extends User> userType) {
        super(request, helperData);
        this.userType = userType;
    }

    public ParserBaseUsername(String request) {
        this(request, null, null);
    }


    protected boolean checkInput(String input, Object helperData) {
        Shop shop = (Shop) helperData;
        boolean existUserName = false;
        User[] users = shop.getUsers();
        for (int i = 0; i < shop.getUsers().length; i++) {
            if (users[i].getClass().equals(userType)) {
                if (users[i].getUsername().equals(input)) {
                    existUserName = true;
                    break;
                }
            }
        }
        return !existUserName;
    }

}
