package com.nabin.tablayout.model;

public class Datacenter {
    private String name;
    private String password;
    private String logname;

    public String getLogname() {
        return logname;
    }

    public void setLogname(String logname) {
        this.logname = logname;
    }

    public String getLogpassword() {
        return logpassword;
    }

    public void setLogpassword(String logpassword) {
        this.logpassword = logpassword;
    }

    private String logpassword;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
