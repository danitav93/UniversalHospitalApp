package com.nodelab.UniversalHospitalApp.services;

public class SimpleFieldsInspector implements FieldsInspectorInterface {

    @Override
    public String checkPassword(String password) {
        if (!password.equals("test")) {
            return "PASSWORD ERRATA";
        }
        return null;
    }

    @Override
    public String checkEmail(String email) {
        if (!email.equals("test")) {
            return "EMAIL ERRATA";
        }
        return null;
    }
}
