package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  class CheckInput {
    private static  CheckInput INSTANCE;

    private  CheckInput(){

    }
    public static CheckInput getINSTANCE(){
        if(INSTANCE==null) INSTANCE = new CheckInput();
        return INSTANCE;
    }

    private final Pattern CHECK_PHONE_NUMBER = Pattern.compile("^[0-9]{10}$");
    private final Pattern CHECK_EMAIL = Pattern.compile("^[a-zA-z0-9]+@[a-zA-z0-9]+(\\.[a-zA-z0-9]+){1,2}$");



    public boolean checkPhoneNumber(String input){
        Matcher matcher = CHECK_PHONE_NUMBER.matcher(input);
        return matcher.find();
    }
    public boolean checkEmail(String input){
        Matcher matcher = CHECK_EMAIL.matcher(input);
        return matcher.find();
    }
}
