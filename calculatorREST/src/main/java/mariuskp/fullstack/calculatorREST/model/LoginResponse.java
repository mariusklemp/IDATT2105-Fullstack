package mariuskp.fullstack.calculatorREST.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginResponse {

    private String loginStatus;
    private int userID;
    private String JWToken;

    public LoginResponse(@JsonProperty("loginStatus")  String loginStatus, int userID) {
        this.loginStatus = loginStatus;
        this.userID = userID;
        this.JWToken = JWToken;
    }

    @JsonProperty("loginStatus")
    public String getLoginStatus() {
        return loginStatus;
    }

    public int getUserID() {
        return userID;
    }

    public String getJWToken() {
        return JWToken;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }

    public void setJWToken(String JWToken) {
        this.JWToken = JWToken;
    }
}
