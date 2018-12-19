package com.example.projekt1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        // Create the layout params for the interactive searcher
        LinearLayout.LayoutParams passwordStrengthMeterParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);

        // Create the interactive searcher
        PasswordStrengthMeter passwordStrengthMeter = new PasswordStrengthMeter(this);
        linearLayout.addView(passwordStrengthMeter, passwordStrengthMeterParams);


        linearLayout.setPadding(40,40,40,40);
        setContentView(linearLayout);
        //setContentView(R.layout.activity_main);
    }
}
