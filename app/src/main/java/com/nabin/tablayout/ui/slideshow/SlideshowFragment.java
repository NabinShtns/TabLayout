package com.nabin.tablayout.ui.slideshow;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.nabin.tablayout.R;

import java.text.DecimalFormat;

public class SlideshowFragment extends Fragment {

    private EditText etFirst, etSecond;
    private Button btnCalculate;
    private TextView txresult;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_slideshow, container, false);
        etFirst = view.findViewById(R.id.etFirst);
        etSecond = view.findViewById(R.id.etSecond);
        btnCalculate = view.findViewById(R.id.btnCaluclate);
        txresult = view.findViewById(R.id.resultadd);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double first, second, result;
                DecimalFormat decimalFormat= new DecimalFormat("0.00");
                if (!TextUtils.isEmpty(etFirst.getText().toString())) {
                    first = Double.parseDouble(etFirst.getText().toString());
                    if (!TextUtils.isEmpty(etSecond.getText().toString())) {
                        second = Double.parseDouble(etSecond.getText().toString());
                        result = first + second;
                        txresult.setText(""+decimalFormat.format(first)+" + "+decimalFormat.format(second)+" = "+ decimalFormat.format(result));

                    }else{
                        etSecond.setError("please enter value");
                    }


                }else{
                    etFirst.setError("please enter value");
                }
            }
        });
        return view;
    }
}