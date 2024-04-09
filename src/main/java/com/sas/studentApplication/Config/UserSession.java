package com.sas.studentApplication.Config;
import java.util.Set;

/**
 * This will create the UserSession as we have used Singleton object for session management.
 */
public class UserSession {
    private String userName;
    private int userId;

    private String role;
    private Set<String> priviledges;

    private UserSession(String userName,int userId,String role,Set<String> priviledges){
        this.userName = userName;
        this.userId = userId;
        this.role = role;
        this.priviledges = priviledges;
    }

    //Getting the Instance of the Session
    private static UserSession instance;

    public static UserSession getInstance(String userName,int userId,String role,Set<String> priviledges){
        if(instance == null){
            instance = new UserSession(userName,userId,role ,priviledges);
        }
        return instance;

    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Set<String> getPriviledges() {
        return priviledges;
    }

    public void setPriviledges(Set<String> priviledges) {
        this.priviledges = priviledges;
    }

    public static void clearSession() {
        instance = null;
    }

    @Override
    public String toString() {
        return "UserSession{" +
                "userName='" + userName + '\'' +
                ", userId='" + userId + '\'' +
                ", priviledges=" + priviledges +
                '}';
    }
}
