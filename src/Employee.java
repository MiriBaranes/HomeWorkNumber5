public class Employee extends User{
    public static final int REGULAR_WORKER=1;
    public static final int DIRECTOR=2;
    public static final int MEMBER_OF_THE_MANAGEMENT_TEAM=3;
    private int rank;

    public Employee(String firstName, String lastName, String username, String password, int rank) {
        super(firstName, lastName, username, password);
        if (rank>=REGULAR_WORKER &&rank<=MEMBER_OF_THE_MANAGEMENT_TEAM) {
            this.rank = rank;
        }
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        if (rank>REGULAR_WORKER &&rank<=MEMBER_OF_THE_MANAGEMENT_TEAM) {
            this.rank = rank;
        }
        else {
            System.out.println("Invalid selection");
        }
    }
    public String toString(){
        StringBuilder output= new StringBuilder();
        output.append(super.toString());
        if (this.rank==REGULAR_WORKER){
            output.append(" Regular worker");
        }
        else if (this.rank==DIRECTOR){
            output.append(" Director");
        }
        else if (this.rank==MEMBER_OF_THE_MANAGEMENT_TEAM){
            output.append(" Member of the management team");
        }
        return output.toString();
    }
}
