package com.example.lab2botnav;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AddFragment extends Fragment {
    EditText entering;
    EditText entering2;
    TextView res;
    Button transf;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment3, container, false);
        entering = v.findViewById(R.id.editText);
        entering2=v.findViewById(R.id.editText2);
        transf= v.findViewById(R.id.transform);
        res=v.findViewById(R.id.result);
        if(savedInstanceState == null){

        }else {
            res.setText(savedInstanceState.getString("RES"));
            entering.setText(savedInstanceState.getString("Num"),TextView.BufferType.EDITABLE);
            entering2.setText(savedInstanceState.getString("Num2"),TextView.BufferType.EDITABLE);
        }

        transf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tv_value = entering.getText().toString();
                String tv_value2= entering2.getText().toString();
                try{
                    int num1 = Integer.parseInt(tv_value,2) + Integer.parseInt(tv_value2,2);
                    res.setText(Integer.toString(num1));

                }
                catch (Exception e) {
                    Log.d("Exception","message" +e);}
            }
        });

        return v;
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        try {
            outState.putString("RES", res.getText().toString());
            outState.putString("Num", entering.toString());
            outState.putString("Num2", entering2.toString());
        }
       catch (Exception e) {}
    }
}
