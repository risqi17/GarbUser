package com.risqi17.drawer;

/**
 * Created by Risqi17 on 16/05/2017.
 */

public class Config {
    //URL to our login.php file
    public static final String IP = "192.168.43.154";
    public static final String LOGIN_URL = "http://"+IP+"/Garb/API/userLogin.php";
    public static final String REGISTER_URL = "http://"+IP+"/Garb/API/userRegister.php";
    public static final String LUPA_PASSWORD_URL = "http://"+IP+"/Garb/API/userLupaPassword.php";
    public static final String SARAN_URL = "http://"+IP+"/Garb/API/saran.php";
    public static final String JSON_GET_PENJAHIT = "http://"+IP+"/Garb/API/userGetPenjahit.php";

    //Keys for email and password as defined in our $_POST['key'] in login.php
    public static final String KEY_ID = "id";
    public static final String KEY_PASSWORD = "password";

    //If server response is equal to this that means login is successful
    public static final String LOGIN_SUCCESS = "success";

    //Keys for Sharedpreferences
    //This would be the name of our shared preferences
    public static final String SHARED_PREF_NAME = "garbLogin";

    //This would be used to store the email of current logged in user
    public static final String ID_SHARED_PREF = "id";

    //We will use this to store the boolean in sharedpreference to track user is loggedin or not
    public static final String LOGGEDIN_SHARED_PREF = "loggedin";
}
