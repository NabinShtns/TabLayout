package com.nabin.tablayout;

import android.content.Intent;
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
public class LoginFragment extends Fragment {
    EditText loginName, LoginPasssword;
    Button btnlogin;


    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        loginName = view.findViewById(R.id.loginName);
        LoginPasssword = view.findViewById(R.id.loginPass);
        btnlogin = view.findViewById(R.id.btnLogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataStore();
            }
        });

        return view;
    }

    public void DataStore() {
        Datacenter Datacenter = new Datacenter();
        String name = "", password = "";
        if (!TextUtils.isEmpty(loginName.getText().toString())) {
            name = loginName.getText().toString();

            if (!TextUtils.isEmpty(LoginPasssword.getText().toString())) {
                password = LoginPasssword.getText().toString();

            } else {
                LoginPasssword.setError("enter password");
                return;
            }
        } else {
            loginName.setError("enter  name");
            return;
        }
        TabLayoutInterface impl = new InterfaceClassIMPL();
        if (impl.Checkuser(name,password)) {
            Toast.makeText(getActivity(), "Welcome " + name, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getActivity(),NavMain.class);
            intent.putExtra("names",name);
            startActivity(intent);
        }else{
            Toast.makeText(getActivity(), "Login failed\nplease check ! " , Toast.LENGTH_SHORT).show();

        }


    }
}

