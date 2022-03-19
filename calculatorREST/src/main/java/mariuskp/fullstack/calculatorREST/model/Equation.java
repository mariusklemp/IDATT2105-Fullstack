package mariuskp.fullstack.calculatorREST.model;

public class Equation {
    private int userID;
    private String equation;

    public Equation(int userID, String equation){
        this.userID = userID;
        this.equation = equation;
    }
    public Equation(){

    }

    public int getUserID() {
        return userID;
    }

    public String getEquation() {
        return equation;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }
}
