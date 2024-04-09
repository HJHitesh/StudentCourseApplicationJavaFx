package com.sas.studentApplication.DOA;

import com.sas.studentApplication.DTO.User;

public interface UserDOA {

    //This will validated user credentials.
    public User validateUser(String userName , String passwrord);

    boolean save(User user);

}
