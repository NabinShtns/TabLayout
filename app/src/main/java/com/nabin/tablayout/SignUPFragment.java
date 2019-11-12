package com.nabin.tablayout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nabin.tablayout.implement.InterfaceClassIMPL;
import com.nabin.tablayout.implement.TabLayoutInterface;
import com.nabin.tablayout.model.Datacenter;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUPFragment extends Fragment {
    EditText sName, sPassword, sRePassword;
    Button btnSignUP;

    public SignUPFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        sName = view.findViewById(R.id.signupName);
        sPassword = view.findViewById(R.id.sign1Pass);
        sRePassword = view.findViewById(R.id.sign2Pass);
        btnSignUP = view.findViewById(R.id.btnsignup);
        btnSignUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataStore();
            }
        });
        return view;
    }

    public void DataStore() {
        String name = "", password = "", repassword = "";
        if (!TextUtils.isEmpty(sName.getText().toString())) {
            name = sName.getText().toString();
            if (!TextUtils.isEmpty(sPassword.getText().toString())) {
                password = sPassword.getText().toString();
                if (!TextUtils.isEmpty(sRePassword.getText().toString())) {
                    repassword = sRePassword.getText().toString();
                } else {
                    sRePassword.setError("enter confirm password");
                    return;
                }
            } else {
                sPassword.setError("enter password");
                return;
            }
        } else {
            sName.setError("enter name");
            return;
        }

        if (password.equals(repassword)) {
            Datacenter datacenter = new Datacenter();
            datacenter.setPassword(password);
            datacenter.setName(name);
            TabLayoutInterface impl = new InterfaceClassIMPL();
            if( impl.adduser(datacenter)){
                Toast.makeText(getActivity(), "User saved swipe left to login", Toast.LENGTH_LONG).show();
                Clear();}

        } else {
            Toast.makeText(getActivity(), "Please enter same password", Toast.LENGTH_SHORT).show();
        }


    }
    public void Clear(){
        sName.setText("");
        sPassword.setText("");
        sRePassword.setText("");
    }


}

