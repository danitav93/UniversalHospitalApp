package com.nodelab.UniversalHospitalApp.singleton;

import android.support.annotation.NonNull;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.nodelab.UniversalHospitalApp.model.User;



public class LoggedUser {

    //create instance
    private static User user = new User();

    private static boolean isLogged = false;

    private static  GoogleSignInClient googleSignInClient;

    //prevent class from being instantiated
    private LoggedUser() {
    }

    public static User getLoggedUser() {
        return user;
    }

    public boolean isLogged() {
        return isLogged;
    }



    public void setName(String name) {
        user.setName(name);
    }

    public void setEmail(String email) {
         user.setEmail(email);
    }

    public static void setIsLogged(boolean isLoggedInput) {
        isLogged=isLoggedInput;
    }

    public static void setGoogleSignInClient(GoogleSignInClient googleSignInClient) {
        LoggedUser.googleSignInClient = googleSignInClient;
    }

    public static GoogleSignInClient getGoogleSignInClient() {
        return googleSignInClient;
    }

    public static void reset() {

        user=new User();

        isLogged=false;

        googleSignInClient=null;

    }
}
