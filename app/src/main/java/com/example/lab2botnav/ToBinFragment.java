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

import org.w3c.dom.Text;

public class ToBinFragment extends Fragment {
    EditText entering;
    TextView res;
    Button transf;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment1, container, false); //init
        transf = v.findViewById(R.id.transform);
        res = v.findViewById(R.id.result);
        entering = v.findViewById(R.id.editText);
        if(savedInstanceState == null){ //check збереження

        }else {
            res.setText(savedInstanceState.getString("RES"));
            entering.setText(savedInstanceState.getString("Num"),TextView.BufferType.EDITABLE);
        }
        transf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tv_value = entering.getText().toString();
                try {
                    int num1 = Integer.parseInt(tv_value);
                    res.setText(Integer.toBinaryString(num1));

                } catch (Exception e) {
                    Log.d("Exception", "message" + e);
                }
            }
        });

        return v;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        try {
            super.onSaveInstanceState(outState);
            outState.putString("RES", res.getText().toString());
            outState.putString("Num", entering.toString());
        }
        catch (Exception e){}
    }
}