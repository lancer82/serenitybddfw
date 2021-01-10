package net.serenity.bdd.junit.cucumber.model;

/**
 * Created by arun on 25/05/2017.
 */
public class LoginData {

    private String userName;
    private String password;
    private String errorMessage;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getErrorMessage(){
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage){
        this.errorMessage=errorMessage;
    }

    public void setAll(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

}
