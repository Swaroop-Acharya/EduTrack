package com.example.edutrack;

public class UserHelperClass {
    String reg_fname,reg_phone,reg_email,reg_password;

    public  UserHelperClass(){}
    public UserHelperClass(String reg_fname, String reg_phone, String reg_email, String reg_password) {
        this.reg_fname = reg_fname;
        this.reg_phone = reg_phone;
        this.reg_email = reg_email;
        this.reg_password = reg_password;
    }

    public String getReg_fname() {
        return reg_fname;
    }

    public void setReg_fname(String reg_fname) {
        this.reg_fname = reg_fname;
    }

    public String getReg_phone() {
        return reg_phone;
    }

    public void setReg_phone(String reg_phone) {
        this.reg_phone = reg_phone;
    }

    public String getReg_email() {
        return reg_email;
    }

    public void setReg_email(String reg_email) {
        this.reg_email = reg_email;
    }

    public String getReg_password() {
        return reg_password;
    }

    public void setReg_password(String reg_password) {
        this.reg_password = reg_password;
    }
}
