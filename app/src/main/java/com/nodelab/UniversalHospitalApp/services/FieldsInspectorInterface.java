package com.nodelab.UniversalHospitalApp.services;

public interface FieldsInspectorInterface {

    /**
     *
     * @param password
     * @return null if password is correct, else return the error
     */
    String checkPassword(String password);

    /**
     *
     * @param email
     * @return null if password is correct, else return the error
     */
    String checkEmail(String email);



}
