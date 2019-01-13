package com.example.mappelito.projekt2;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
    private int textViewWidth = 150;
    private int numberOfTextFields = 5;
    private boolean OPTIONAL = true;
    private boolean NOT_OPTIONAL = false;
    private ArrayList<Pair<Boolean, EditText>> nonOptionalEntriesList = new ArrayList<>();
    private View.OnClickListener signUpListener;

    public AccountRegistrationForm(Context cxt) {
        super(cxt);
        context = cxt;
        verticalLinearLayout = new LinearLayout(context);
        verticalLinearLayout.setOrientation(LinearLayout.VERTICAL);

        signUpListener = new View.OnClickListener() {
            public void onClick(View v){
                runDefaultLogic();
            }
        };
        initiateForm();
        setLayout();
    }

    //TODO: bryt ut raden TV + ET till egen class.
    //Initiates all the textviews and editable text views with titles and hints.
    private void initiateForm()
    {
        tvName  = new TextView(context);
        tvName.setText("Full Name");

        etName = new EditText(context);
        etName.setHint("First Last");

        tvUsername  = new TextView(context);
        tvUsername.setText("Username");

        etUsername = new EditText(context);
        etUsername.setHint("user123");

        tvEmail = new TextView(context);
        tvEmail.setText("Email");

        etEmail = new EditText(context);
        etEmail.setHint("example@gmail.com");

        tvPassword = new TextView(context);
        tvPassword.setText("Password");
        tvPassword2 = new TextView(context);
        tvPassword2.setText("Confirm Password");

        etPassword = new EditText(context);
        etPassword.setTransformationMethod(new PasswordTransformationMethod());
        etPassword2 = new EditText(context);
        etPassword2.setTransformationMethod(new PasswordTransformationMethod());

    }

    //Combines the title with its editable text field in a horizontal layout
    //It also adds the entry to the nonOptionalEntriesList if it is marked as a NON-OPTIONAL info.
    private void addLayout(TextView tv, EditText et, boolean optional)
    {

        //Log.d("CREATION", "addLayout done");
        Pair<Boolean,EditText> entry = new Pair<>(optional,et);
        nonOptionalEntriesList.add(entry);
        // Sets the params for the TextView
        LinearLayout.LayoutParams tvParams =
                new LinearLayout.LayoutParams(
                        textViewWidth,
                        LayoutParams.WRAP_CONTENT);

        // Sets the params for the EditText
        LinearLayout.LayoutParams etParams =
                new LinearLayout.LayoutParams(
                        LayoutParams.MATCH_PARENT,
                        LayoutParams.WRAP_CONTENT);
        et.setBackgroundResource(android.R.drawable.edit_text);

        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.HORIZONTAL);

        layout.addView(tv, tvParams);
        layout.addView(et, etParams);
        layout.setPadding(0,0,20,0);

        verticalLinearLayout.addView(layout);
    }

    //Adds a spinner with different String variables from an ArrayList.
    private void addStringSpinner()
    {
        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.HORIZONTAL);

        TextView tvGender = new TextView(context);
        tvGender.setText("Gender");
        tvGender.setWidth(textViewWidth);

        ArrayList<String> spinnerArray = new ArrayList<>();
        spinnerArray.add("Male");
        spinnerArray.add("Female");

        Spinner spinner = new Spinner(context);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, spinnerArray);
        spinner.setAdapter(spinnerArrayAdapter);

        // Sets the params for the Spinner
        LinearLayout.LayoutParams spinnerParams =
                new LinearLayout.LayoutParams(
                        LayoutParams.WRAP_CONTENT,
                        LayoutParams.WRAP_CONTENT);
        // Sets the paras for the TextView and Horizontal Layout
        LinearLayout.LayoutParams layoutParams =
                new LinearLayout.LayoutParams(
                        LayoutParams.WRAP_CONTENT,
                        LayoutParams.WRAP_CONTENT);
        layout.addView(tvGender, layoutParams);
        layout.addView(spinner, spinnerParams);

        verticalLinearLayout.addView(layout, layoutParams);
    }

    //Adds a spinner with Integer values generated from a for-loop
    private void addIntegerSpinner()
    {
        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.HORIZONTAL);

        TextView tvAge = new TextView(context);
        tvAge.setText("Age");
        tvAge.setWidth(textViewWidth);

        ArrayList<Integer> spinnerArray = new ArrayList<>();
        for(int i = 0; i < 100; i++)
        {
            spinnerArray.add(i);
        }

        Spinner spinner = new Spinner(context);
        ArrayAdapter<Integer> spinnerArrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, spinnerArray);
        spinner.setAdapter(spinnerArrayAdapter);

        // Sets the params for the Spinner
        LinearLayout.LayoutParams spinnerParams =
                new LinearLayout.LayoutParams(
                        LayoutParams.MATCH_PARENT,
                        LayoutParams.WRAP_CONTENT);
        // Sets the params for the TextView and Horizontal Layout
        LinearLayout.LayoutParams layoutParams =
                new LinearLayout.LayoutParams(
                        LayoutParams.WRAP_CONTENT,
                        LayoutParams.WRAP_CONTENT);
        layout.addView(tvAge, layoutParams);
        layout.addView(spinner, spinnerParams);

        verticalLinearLayout.addView(layout, layoutParams);
    }

    private void setLayout()
    {
        //Sets the params for the linearLayout
        LinearLayout.LayoutParams linearLayoutParams =
                new LinearLayout.LayoutParams(
                        LayoutParams.MATCH_PARENT,
                        LayoutParams.WRAP_CONTENT);

        addLayout(tvName, etName, NOT_OPTIONAL);
        addLayout(tvEmail, etEmail, NOT_OPTIONAL);
        addLayout(tvUsername, etUsername, NOT_OPTIONAL);
        addStringSpinner(); //Gender dropdown selection list, male or female
        addIntegerSpinner(); //Age dropdown selection list, 0-100
        addLayout(tvPassword, etPassword, NOT_OPTIONAL);
        addLayout(tvPassword2, etPassword2, NOT_OPTIONAL);

        Button signUpBtn = new Button(context);
        signUpBtn.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        signUpBtn.setText("Sign up");
        verticalLinearLayout.addView(signUpBtn);

        signUpBtn.setOnClickListener(signUpListener);

        this.addView(verticalLinearLayout, linearLayoutParams);
    }

    public void setSignUpListener(View.OnClickListener onClickListener)
    {
        signUpListener = onClickListener;
    }
    private void runDefaultLogic()
    {
        if(!checkMandatoryInput())
        {
            String text = "Enter all non-optional information";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else if(!checkPasswordMatch())
        {
            String text = "Passwords must match";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else
        {
            String text = "Registration complete!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

    }
    private boolean checkMandatoryInput()
    {
        for(int i = 0; i < nonOptionalEntriesList.size(); i++)
        {
            boolean optional = nonOptionalEntriesList.get(i).first;
            EditText et = nonOptionalEntriesList.get(i).second;
            String submittedEntry = et.getText().toString();
            if(!optional && submittedEntry.length() == 0)
            {
                // Initialize a new GradientDrawable that is set to have a red border
                //so the user knows what field needs to be entered.
                GradientDrawable gd = new GradientDrawable();
                gd.setColor(Color.parseColor("#00ffffff"));
                gd.setStroke(2,Color.RED);
                et.setBackground(gd);
                return false;
            }
            else
            {
                //Resets the background if text is entered and to remove the red border.
                et.setBackgroundResource(android.R.drawable.edit_text);
            }
        }
        return true;
    }

    //Checks if the password matches the one entered in the "Confirm Password"-field
    private boolean checkPasswordMatch()
    {
        String password = etPassword.getText().toString();
        String password2 = etPassword2.getText().toString();

        return password.matches(password2);
    }

    public void setOptionalFields(ArrayList<Boolean> optionalList)
    {
        if(optionalList.size() < numberOfTextFields)
            Log.e("ERROR", "Input Arraylist size must be larger or equal to " + numberOfTextFields);
        else
        {
            for(int i = 0; i < nonOptionalEntriesList.size(); i++)
            {
                Pair<Boolean, EditText> changedOptional = new Pair<>(optionalList.get(i), nonOptionalEntriesList.get(i).second);
                nonOptionalEntriesList.set(i, changedOptional);
            }
        }

    }
}
