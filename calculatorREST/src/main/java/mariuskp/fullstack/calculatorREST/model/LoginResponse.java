package mariuskp.fullstack.calculatorREST.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginResponse {

    final private String loginStatus;
    final private int userID;

    public LoginResponse(@JsonProperty("loginStatus")  String loginStatus, int userID) {
        this.loginStatus = loginStatus;
        this.userID = userID;
    }

    @JsonProperty("loginStatus")
    public String getLoginStatus() {
        return loginStatus;
    }

    public int getUserID() {
        return userID;
    }
}
