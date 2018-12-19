package com.example.projekt1;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.LinearLayout;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class PasswordStrengthMeter extends LinearLayout {

    // Private variables
    private Context context;
    private Resources res = getResources();
    private EditText editText;
    private ProgressBar progressBar;
    private TextView textView;

    private int progressStatus = 0;
    // Constructor
    public PasswordStrengthMeter(Context cxt) {
        super(cxt);
        context = cxt;

        setLayout();
        setListeners();
    }

    //Create function that determines password strength
    private void getPasswordStrength(String pw) {

        String password = pw;
    }

    private void setLayout()
    {
        /** DEFINE LAYOUT PARAMETERS FOR ALL MODULES IN THE LAYOUT **/
        //Sets the params for the linearLayout
        LinearLayout.LayoutParams linearLayoutParams =
                new LinearLayout.LayoutParams(
                        LayoutParams.MATCH_PARENT,
                        LayoutParams.WRAP_CONTENT);
        // Sets the params for the progressBar
        LinearLayout.LayoutParams progressBarParams =
                new LinearLayout.LayoutParams(
                        LayoutParams.MATCH_PARENT,
                        LayoutParams.WRAP_CONTENT);
        // Sets the params for the editText
        LayoutParams editTextParams =
                new LinearLayout.LayoutParams(
                        LayoutParams.MATCH_PARENT,
                        LayoutParams.WRAP_CONTENT);
        // Sets the params for the textView
        LinearLayout.LayoutParams textViewParams =
                new LinearLayout.LayoutParams(
                        LayoutParams.MATCH_PARENT,
                        LayoutParams.WRAP_CONTENT);

        /** SET PROPERTIES FOR ALL MODULES IN THE LAYOUT **/
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        editText = new EditText(context);
        editText.setSingleLine(true);
        editText.setHint("Type Password...");

        progressBar = new ProgressBar(context, null, android.R.attr.progressBarStyleHorizontal);
        progressBar.setProgress(0);
        progressBar.setMax(100);
        progressBar.setIndeterminate(false);
        progressBar.setProgressDrawable(res.getDrawable(R.drawable.redprogress));

        textView = new TextView(context);
        textView.setText("Weak");

        linearLayout.addView(editText, editTextParams);
        linearLayout.addView(progressBar, progressBarParams);
        linearLayout.addView(textView, textViewParams);

        this.addView(linearLayout, linearLayoutParams);
    }
    // Create listeners for the interactive searcher
    private void setListeners()
    {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            // The only listener needed. Checks after we changed the text.
            @Override
            public void afterTextChanged(Editable pw) {
                String password = pw.toString();
                progressStatus = password.length()*10;
                if (progressStatus > 50 && progressStatus < 75)
                {
                    progressBar.setProgressDrawable(res.getDrawable(R.drawable.yellowprogress));
                    textView.setText("Good");
                }
                else if(progressStatus > 75)
                {
                    progressBar.setProgressDrawable(res.getDrawable(R.drawable.greenprogress));
                    textView.setText("Strong");
                }
                else
                {
                    progressBar.setProgressDrawable(res.getDrawable(R.drawable.redprogress));
                    textView.setText("Weak");
                }

                progressBar.setProgress(progressStatus);
                //TODO: Set this function to generate a value between 0-100 based on pw strength.
                getPasswordStrength(password);
            }
        });
    }
}

