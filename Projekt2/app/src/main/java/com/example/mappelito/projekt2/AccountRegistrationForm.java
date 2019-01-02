package com.example.mappelito.projekt2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AccountRegistrationForm  extends LinearLayout {

    // Private variables
    private Context context;
    private LinearLayout verticalLinearLayout;
    private EditText etName;
    private EditText etUsername;
    private EditText etEmail;
    private EditText etPassword;
    private EditText etPassword2;
    private TextView tvName;
    private TextView tvUsername;
    private TextView tvEmail;
    private TextView tvPassword;
    private TextView tvPassword2;

    public AccountRegistrationForm(Context cxt) {
        super(cxt);
        context = cxt;
        verticalLinearLayout = new LinearLayout(context);
        verticalLinearLayout.setOrientation(LinearLayout.VERTICAL);

        initiateForm();
        setLayout();
    }

    private void initiateForm()
    {
        tvName  = new TextView(context);
        tvName.setText("Full Name");
        tvName.setPadding(0,0,5,0);

        etName = new EditText(context);
        etName.setHint("First Last");

        tvUsername  = new TextView(context);
        tvUsername.setText("Username");

        etUsername = new EditText(context);
        etUsername.setHint("user123");

        tvEmail = new TextView(context);
        tvEmail.setText("Email");
        tvEmail.setPadding(0,0, 88, 0);

        etEmail = new EditText(context);
        etEmail.setHint("example@gmail.com");

        tvPassword = new TextView(context);
        tvPassword.setText("Password");
        tvPassword.setPadding(0,0,160,0);
        tvPassword2 = new TextView(context);
        tvPassword2.setText("Confirm Password");

        etPassword = new EditText(context);
        etPassword2 = new EditText(context);

    }

    private void addLayout(TextView tv, EditText et)
    {
        // Sets the params for the textView
        LinearLayout.LayoutParams tvParams =
                new LinearLayout.LayoutParams(
                        LayoutParams.WRAP_CONTENT,
                        LayoutParams.WRAP_CONTENT);
        //tvParams.setMarginStart(100);

        // Sets the params for the textView
        LinearLayout.LayoutParams etParams =
                new LinearLayout.LayoutParams(
                        LayoutParams.MATCH_PARENT,
                        LayoutParams.WRAP_CONTENT);

        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.addView(tv, tvParams);
        layout.addView(et, etParams);
        layout.setPadding(5,0,20,0);

        verticalLinearLayout.addView(layout);
    }

    private void addGenderSpinner()
    {
        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.HORIZONTAL);

        TextView tvGender = new TextView(context);
        tvGender.setText("Gender");
        tvGender.setPadding(0,0,50,0);

        ArrayList<String> spinnerArray = new ArrayList<>();
        spinnerArray.add("Male");
        spinnerArray.add("Female");

        Spinner spinner = new Spinner(context);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, spinnerArray);
        spinner.setAdapter(spinnerArrayAdapter);

        // Sets the params for the textView
        LinearLayout.LayoutParams spinnerParams =
                new LinearLayout.LayoutParams(
                        LayoutParams.MATCH_PARENT,
                        LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams layoutParams =
                new LinearLayout.LayoutParams(
                        LayoutParams.WRAP_CONTENT,
                        LayoutParams.WRAP_CONTENT);
        layout.addView(tvGender, layoutParams);
        layout.addView(spinner, spinnerParams);

        verticalLinearLayout.addView(layout, layoutParams);
    }

    private void addAgeSpinner()
    {
        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.HORIZONTAL);

        TextView tvGender = new TextView(context);
        tvGender.setText("Age");
        tvGender.setPadding(0,0,120,0);

        ArrayList<Integer> spinnerArray = new ArrayList<>();
        for(int i = 0; i < 100; i++)
        {
            spinnerArray.add(i);
        }

        Spinner spinner = new Spinner(context);
        ArrayAdapter<Integer> spinnerArrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, spinnerArray);
        spinner.setAdapter(spinnerArrayAdapter);

        // Sets the params for the textView
        LinearLayout.LayoutParams spinnerParams =
                new LinearLayout.LayoutParams(
                        LayoutParams.MATCH_PARENT,
                        LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams layoutParams =
                new LinearLayout.LayoutParams(
                        LayoutParams.WRAP_CONTENT,
                        LayoutParams.WRAP_CONTENT);
        layout.addView(tvGender, layoutParams);
        layout.addView(spinner, spinnerParams);

        verticalLinearLayout.addView(layout, layoutParams);
    }

    private void setLayout()
    {
        /** DEFINE LAYOUT PARAMETERS FOR ALL MODULES IN THE LAYOUT **/
        //Sets the params for the linearLayout
        LinearLayout.LayoutParams linearLayoutParams =
                new LinearLayout.LayoutParams(
                        LayoutParams.MATCH_PARENT,
                        LayoutParams.WRAP_CONTENT);

        addLayout(tvName, etName);
        addLayout(tvEmail, etEmail);
        addLayout(tvUsername, etUsername);
        addGenderSpinner(); //Gender dropdown selection list, male or female
        addAgeSpinner();
        addLayout(tvPassword,etPassword);
        addLayout(tvPassword2, etPassword2);

        Button signUpBtn = new Button(context);
        signUpBtn.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        signUpBtn.setText("Sign up");
        verticalLinearLayout.addView(signUpBtn);

        signUpBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if(!checkMandatoryInput())
                {
                    //TODO: give message saying not all mandatory forms have been set
                }
                else if(!checkPasswordMatch())
                {
                    //TODO: give message saying passwords don't match
                }
                else
                {
                    //TODO: clear view and send message, "Registration complete"
                }

            }
        });

        this.addView(verticalLinearLayout, linearLayoutParams);
    }

    private boolean checkMandatoryInput()
    {
        return true;
    }
    private boolean checkPasswordMatch()
    {
        return true;
    }
}
