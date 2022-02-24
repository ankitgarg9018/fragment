package com.example.myfragment;

import android.app.Activity;
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

import java.text.BreakIterator;


public class FragmentRegister extends Fragment {
private SharedPreferences sharedPreferences;
private SharedPreferences.Editor editor;
    Button bt_register,btreg;
   EditText user,password,cpassword;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.regist_fragment, container, false);
        SharedPreferences preferences = getContext().getSharedPreferences("MYPRESS",Context.MODE_PRIVATE );
        SharedPreferences.Editor editor = preferences.edit();

        bt_register = view.findViewById(R.id.bt_register);
        user =view.findViewById(R.id.user);
        password= view.findViewById(R.id.password);
        cpassword= view.findViewById(R.id.cpassword);
        btreg = view.findViewById(R.id.btreg);
        btreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               String newUser = user.getText().toString();
                String newPassword = password.getText().toString();
                String conPasssword = cpassword.getText().toString();

                editor.putString("userName",newUser);
                editor.putString("newpassword",newPassword);
                editor.putString("confpassword",conPasssword);
                editor.putBoolean("isRegister",true);
                editor.commit();

                preferences.getString("userName","");
                Toast.makeText(getActivity(), "Register Successful", Toast.LENGTH_SHORT).show();
                FragmentLogin fragment2 = new FragmentLogin();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment2);
                fragmentTransaction.commit();
            }
        });
        return view;
    }


}
