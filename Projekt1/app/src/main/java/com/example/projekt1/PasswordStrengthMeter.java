package com.example.projekt1;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
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
    private Drawable clr1 = res.getDrawable(R.drawable.redprogress);
    private Drawable clr2 = res.getDrawable(R.drawable.yellowprogress);
    private Drawable clr3 = res.getDrawable(R.drawable.greenprogress);

    private int WEAK = 0;
    private int MEDIUM = 33;
    private int STRONG = 66;
    private int VERY_STRONG= 100;
    private String textWEAK = "bad";
    private String textMEDIUM = "decent";
    private String textSTRONG = "good";
    private String textVERY_STRONG = "very good";
    private int progressStatus = 0;
    private PasswordStrengthCalculator strengthCalculator;
    // Constructor
    public PasswordStrengthMeter(Context cxt) {
        super(cxt);
        context = cxt;

        strengthCalculator = new PasswordStrengthCalculator(context);

        setPasswordStrengthMethod(0);
        setLayout();
        setListeners();
    }

    //Create function that determines password strength
    private int getPasswordStrength(String password) {
        return strengthCalculator.getStrength(password);
    }

    private void setPasswordStrengthMethod(int method)
    {
        strengthCalculator.setMethod(method);
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
                //progressStatus = password.length()*10;
                progressStatus = getPasswordStrength(password);
                if (progressStatus == WEAK)
                {
                    textView.setText(textWEAK);
                }
                else if(progressStatus == MEDIUM)
                {
                    progressBar.setProgressDrawable(clr1);
                    textView.setText(textMEDIUM);
                }
                else if(progressStatus == STRONG)
                {
                    progressBar.setProgressDrawable(clr2);
                    textView.setText(textSTRONG);
                }
                else
                {
                    progressBar.setProgressDrawable(clr3);
                    textView.setText(textVERY_STRONG);
                }

                progressBar.setProgress(progressStatus);
            }
        });
    }

    public void setMessages(String msg1, String msg2, String msg3, String msg4)
    {
        textWEAK = msg1;
        textMEDIUM = msg2;
        textSTRONG = msg3;
        textVERY_STRONG = msg4;
    }

    public void setColors(Drawable color1, Drawable color2, Drawable color3)
    {
        clr1 = color1;
        clr2 = color2;
        clr3 = color3;
    }
}

