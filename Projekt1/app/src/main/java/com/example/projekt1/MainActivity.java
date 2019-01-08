package com.example.projekt1;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        // Create the layout params for the PasswordStrengthMeter
        LinearLayout.LayoutParams passwordStrengthMeterParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);

        // Create the PasswordStrengthMeter
        PasswordStrengthMeter passwordStrengthMeter = new PasswordStrengthMeter(this);
        passwordStrengthMeter.setMessages("Weak", "Medium", "Strong", "Very Strong");
        Drawable red = getResources().getDrawable(R.drawable.redprogress);
        Drawable yellow = getResources().getDrawable(R.drawable.yellowprogress);
        Drawable green = getResources().getDrawable(R.drawable.greenprogress);
        passwordStrengthMeter.setColors(red, yellow, green);

        linearLayout.addView(passwordStrengthMeter, passwordStrengthMeterParams);
        linearLayout.setPadding(40,40,40,40);
        setContentView(linearLayout);
        //setContentView(R.layout.activity_main);
    }
}
