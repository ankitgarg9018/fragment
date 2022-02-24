package com.example.myfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.myfragment.InterfaceData.OnInputListener;

public class MainActivity extends AppCompatActivity {
private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences preferences = getSharedPreferences("MYPRESS", Context.MODE_PRIVATE );
        boolean isLogin = preferences.getBoolean("isLogin",false);
          if(isLogin)
          {
            //  TODO call Welcome Fragment
              Toast.makeText(this, "Login", Toast.LENGTH_SHORT).show();
          }else {
              if (savedInstanceState == null) {
                  FragmentManager fragmentManager = getSupportFragmentManager();
                  //   FragmentLogin fragment = new FragmentLogin();

                  FragmentTransaction transaction = fragmentManager.beginTransaction();
                  transaction.add(R.id.fragment_container, new FragmentLogin());
                  transaction.commit();
              }
          }

    }
}