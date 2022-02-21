package com.example.myfragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myfragment.InterfaceData.OnInputListener;


public class FragmentRegister extends Fragment {

    private OnInputListener listener;
    Button bt_register;
    EditText etuser;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.regist_fragment,container,false);
        bt_register = view.findViewById(R.id.bt_register);
        etuser=view.findViewById(R.id.user);

        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = etuser.getEditableText().toString();
                if( listener !=null){
                   listener.input(userName);

                }else{


                }
            }
        });
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        listener = (OnInputListener) activity;
    }
}
