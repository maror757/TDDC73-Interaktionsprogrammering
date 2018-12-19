package com.example.projekt1;

import android.content.Context;
import android.widget.EditText;
import android.widget.LinearLayout;

public class PasswordStrengthMeter extends LinearLayout {

    // Private variables
    private Context context; // The context from the main app.
    private EditText editText;
    // Constructor
    public PasswordStrengthMeter(Context context) {
        super(context);
        this.context = context;
        editText = new EditText(context);
        editText.setSingleLine(true);
        editText.setHint("Type Password...");

        // Sets the params for the edit text
        LayoutParams editTextParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
        this.addView(editText, editTextParams);
    }
}