package com.nabin.tablayout.implement;


import com.nabin.tablayout.model.Datacenter;

public class InterfaceClassIMPL implements TabLayoutInterface {
    static String names, password;



    @Override
    public boolean adduser(Datacenter dc) {
        boolean b;
        if ((!dc.getPassword().isEmpty()) && (!dc.getName().isEmpty())) {
            names = dc.getName();
            password = dc.getPassword();
            b = true;
        } else {
            b = false;
        }
        return b;
    }

    @Override
    public boolean Checkuser(String name, String password) {
        boolean b = false;
        try{  if (names.equals(name)&&(password.equals(password))) {
            b = true;
        } else {
            b = false;
        }}catch (Exception ex){
            ex.printStackTrace();
        }
        return b;
    }


}

