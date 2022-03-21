package mariuskp.fullstack.calculatorREST.model;

public class User {
    private int userID;
    private String username;
    private String passw;


    public User(int userID, String username, String passw){
        this.userID = userID;
        this.username = username;
        this.passw = passw;
    }
    public User() {

    }

    public User(String username, String passw) {
        this.username = username;
        this.passw = passw;
    }

    public int getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassw() {
        return passw;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }
}
