package com.example.myfragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myfragment.InterfaceData.OnInputListener;

public class FragmentLogin extends Fragment {

    Button bt_register,btnLogin;
    FragmentRegister fragment;
    EditText etPass,etUser;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.login_fragment, container, false);
        SharedPreferences preferences = getContext().getSharedPreferences("MYPRESS", Context.MODE_PRIVATE );
        SharedPreferences.Editor editor = preferences.edit();
        String _userName = preferences.getString("userName","");
        String _pass = preferences.getString("newpassword","");

        bt_register = view.findViewById(R.id.bt_register);
        etUser =  view.findViewById(R.id.etUser);
        etPass = view.findViewById(R.id.etPass);
        btnLogin = view.findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = etUser.getText().toString().trim();
                String pass =  etPass.getText().toString().trim();
                if(userName.equals(""))
                {
                   etUser.setError("Please Enter UserName");
                }else  if(pass.equals(""))
                {
                    etPass.setError("Please Enter Password");
                }
                else  if(!userName.equals(_userName) || !pass.equals(_pass))
                {
                    Toast.makeText(getActivity(), getString(R.string.valib_msg), Toast.LENGTH_SHORT).show();
                } else {
                    editor.putBoolean("isLogin", true);
                    editor.commit();
                    Toast.makeText(getActivity(), "Login Successful", Toast.LENGTH_SHORT).show();
                            //welcome  fragment
                }

                bt_register.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        FragmentRegister fragment2 = new FragmentRegister();
                        FragmentManager fragmentManager = getFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_container, fragment2);
                        fragmentTransaction.commit();
                    }
                });


            }
        });
        return view;
    }

}
