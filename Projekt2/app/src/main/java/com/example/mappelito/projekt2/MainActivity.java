package com.example.mappelito.projekt2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setPadding(40,40,40,40);

        // Create the layout params for the PasswordStrengthMeter
        final LinearLayout.LayoutParams accountFormParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);

        // Create the PasswordStrengthMeter
        final AccountRegistrationForm accountForm = new AccountRegistrationForm(this);




        //set the properties for button
        Button createAccountBtn = new Button(this);
        createAccountBtn.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        createAccountBtn.setText("Create Account");

        createAccountBtn.setOnClickListener(new View.OnClickListener()
                                {
                                    @Override
                                    public void onClick(View v) {
                                        linearLayout.removeAllViews();
                                        linearLayout.addView(accountForm, accountFormParams);
                                    }
                                });



        linearLayout.addView(createAccountBtn);
        setContentView(linearLayout);
        //setContentView(R.layout.activity_main);
    }
}
