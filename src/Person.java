public  abstract class  Person {
    private String firstName;
    private String lastName;

    public Person(String firstName,String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String toString() {
        StringBuilder output= new StringBuilder();
        output.append("Full name: ").append(this.firstName).append(" ").append(this.lastName);
        return output.toString();
    }
}
