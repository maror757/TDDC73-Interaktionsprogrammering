package com.example.mappelito.projekt2;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;

public class FormField extends LinearLayout {

    private Context context;
    private TextView textView;
    private EditText editText;
    private Spinner spinner;
    private boolean OPTIONAL = true;
    private int textViewWidth = 150;

    public FormField(Context cxt) {
        super(cxt);
        context = cxt;
        this.setOrientation(LinearLayout.HORIZONTAL);
        this.setLayoutParams(new LinearLayout.LayoutParams(
                            LayoutParams.MATCH_PARENT,
                            LayoutParams.WRAP_CONTENT)
        );

        textView = new TextView(context);
        addTextView();
    }


    private void addTextView()
    {
        // Sets the params for the TextView
        LinearLayout.LayoutParams tvParams =
                new LinearLayout.LayoutParams(
                        textViewWidth,
                        LayoutParams.WRAP_CONTENT);
        this.addView(textView, tvParams);
    }

    public void addTextRow(String tvTitle, String etHint) {

        textView.setText(tvTitle);
        editText = new EditText(context);
        editText.setHint(etHint);

        // Sets the params for the EditText
        LinearLayout.LayoutParams etParams =
                new LinearLayout.LayoutParams(
                        LayoutParams.MATCH_PARENT,
                        LayoutParams.WRAP_CONTENT);
        editText.setBackgroundResource(android.R.drawable.edit_text);
        this.addView(editText, etParams);
        this.setPadding(0, 0, 20, 0);
    }

    public void addStringSpinnerRow(String tvTitle,  ArrayList<String> spinnerArray)
    {
        textView.setText(tvTitle);

        spinner = new Spinner(context);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, spinnerArray);
        spinner.setAdapter(spinnerArrayAdapter);

        // Sets the params for the Spinner
        LinearLayout.LayoutParams spinnerParams =
                new LinearLayout.LayoutParams(
                        LayoutParams.WRAP_CONTENT,
                        LayoutParams.WRAP_CONTENT);
        this.addView(spinner, spinnerParams);
    }
    public void addIntegerSpinnerRow(String tvTitle,  ArrayList<Integer> spinnerArray)
    {
        textView.setText(tvTitle);

        spinner = new Spinner(context);
        ArrayAdapter<Integer> spinnerArrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, spinnerArray);
        spinner.setAdapter(spinnerArrayAdapter);

        // Sets the params for the Spinner
        LinearLayout.LayoutParams spinnerParams =
                new LinearLayout.LayoutParams(
                        LayoutParams.WRAP_CONTENT,
                        LayoutParams.WRAP_CONTENT);
        this.addView(spinner, spinnerParams);
    }

    public boolean isOptional()
    {
        return OPTIONAL;
    }

    public void setOptional(boolean optional)
    {
        OPTIONAL = optional;
    }

    public EditText getEditText()
    {
        return editText;
    }
}
