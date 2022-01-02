public class Client extends User{
    private boolean isVIP;


    public Client(String firstName, String lastName, String username, String password,boolean isVIP) {
        super(firstName,lastName,  username, password);
        this.isVIP=isVIP;
    }

    public boolean isVIP() {
        return isVIP;
    }

    public void setVIP(boolean VIP) {
        isVIP = VIP;
    }
    public String toString(){
        StringBuilder output= new StringBuilder();
        output.append(super.toString());
        if (isVIP){
            output.append( " vip");
        }
        return output.toString();
    }
}
