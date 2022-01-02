public abstract class User extends Person {
    private String username;
    private String password;


    public User(String firstName, String lastName, String username, String password) {
        super(firstName,lastName);
        this.username=username;
        this.password=password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String toString() {
        StringBuilder output= new StringBuilder();
        output.append(" Hello ").append(super.toString());
        return output.toString();
    }

}
