package com.example.myfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.example.myfragment.InterfaceData.OnInputListener;

public class MainActivity extends AppCompatActivity implements OnInputListener {
private FragmentManager fragmentManager;
    EditText euser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
         //   FragmentLogin fragment = new FragmentLogin();

            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.add(R.id.fragment_container, new FragmentLogin());
            transaction.commit();
        }
        euser = findViewById(R.id.user);

    }

    @Override
    public void input(String inputSting) {
       euser.setText(inputSting);
    }
}