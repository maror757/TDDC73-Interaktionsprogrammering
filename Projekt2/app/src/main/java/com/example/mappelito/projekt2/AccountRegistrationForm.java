package com.example.mappelito.projekt2;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class AccountRegistrationForm  extends LinearLayout {

    // Private variables
    private Context context;
    private LinearLayout verticalLinearLayout;

    private EditText etPassword;
    private EditText etPassword2;

    private FormField nameForm;
    private FormField usernameForm;
    private FormField emailForm;
    private FormField passwordForm;
    private FormField password2Form;
    private FormField genderSpinnerForm;
    private FormField ageSpinnerForm;

    private int numberOfTextForms = 0;
    private ArrayList<FormField> textFormList = new ArrayList<>();
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

    //Initiates all the FormFields
    private void initiateForm()
    {
        nameForm = new FormField(context);

        usernameForm = new FormField(context);

        emailForm = new FormField(context);

        genderSpinnerForm = new FormField(context);

        ageSpinnerForm = new FormField(context);

        passwordForm = new FormField(context);

        password2Form = new FormField(context);

    }

    //Adds the TextForm in a vertical layout, increments number of Forms and
    //it also adds the entry to the textFormList.
    private void addForm(FormField textForm, String title, String hint)
    {
        textForm.addTextRow(title, hint);
        verticalLinearLayout.addView(textForm);
        numberOfTextForms++;
        textFormList.add(textForm);
    }

    //Adds a spinner with different String variables from an ArrayList.
    private void addStringSpinner(FormField spinnerForm, String title)
    {
        ArrayList<String> spinnerArray = new ArrayList<>();
        spinnerArray.add("Male");
        spinnerArray.add("Female");
        spinnerForm.addStringSpinnerRow(title, spinnerArray);
        verticalLinearLayout.addView(spinnerForm);
    }

    //Adds a spinner with Integer values generated from a for-loop
    private void addIntegerSpinner(FormField spinnerForm, String title)
    {
        ArrayList<Integer> spinnerArray = new ArrayList<>();
        for(int i = 0; i < 100; i++)
        {
            spinnerArray.add(i);
        }
        spinnerForm.addIntegerSpinnerRow(title, spinnerArray);
        verticalLinearLayout.addView(spinnerForm);
    }

    private void setLayout()
    {
        //Sets the params for the linearLayout
        LinearLayout.LayoutParams linearLayoutParams =
                new LinearLayout.LayoutParams(
                        LayoutParams.MATCH_PARENT,
                        LayoutParams.WRAP_CONTENT);

        addForm(nameForm, "Full Name", "First Last");
        addForm(usernameForm, "Username", "user123");
        addForm(emailForm, "Email", "user123@gmail.com");
        addStringSpinner(genderSpinnerForm, "Gender"); //Gender dropdown selection list, male or female
        addIntegerSpinner(ageSpinnerForm, "Age"); //Age dropdown selection list, 0-100

        addForm(passwordForm,"Password", "");
        etPassword = passwordForm.getEditText();
        etPassword.setTransformationMethod(new PasswordTransformationMethod());

        addForm(password2Form, "Confirm Password", "");
        etPassword2 = password2Form.getEditText();
        etPassword2.setTransformationMethod(new PasswordTransformationMethod());

        Button signUpBtn = new Button(context);
        signUpBtn.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT)
        );
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
        for(int i = 0; i < textFormList.size(); i++)
        {
            FormField textRow = textFormList.get(i);
            EditText et = textRow.getEditText();
            String submittedEntry = et.getText().toString();
            if(!textRow.isOptional() && submittedEntry.length() == 0)
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
        if(optionalList.size() < numberOfTextForms)
            Log.e("ERROR", "Input Arraylist size must be larger or equal to " + numberOfTextForms);
        else
        {
            for(int i = 0; i < textFormList.size(); i++)
            {
                textFormList.get(i).setOptional(optionalList.get(i));
            }
        }
    }
}
