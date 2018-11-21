package com.example.mappelito.laboration12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.view.ViewGroup.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout myVertLayout = new LinearLayout(this);
        myVertLayout.setOrientation(LinearLayout.VERTICAL);
        LayoutParams linLayoutParam = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

            ////////******** HORIZONTAL LAYOUT 1 ********////////
            LinearLayout myHorizontalLayout1 = new LinearLayout(this);
            myHorizontalLayout1.setOrientation(LinearLayout.HORIZONTAL);
            myHorizontalLayout1.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

                //CREATION OF NAMN TEXT LABEL
                TextView disabledText1 = new TextView(this);
                disabledText1.setText("Namn");
                disabledText1.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
                disabledText1.setPadding(0,0,42,0);

                //CREATION OF NAMN TEXT FIELD
                EditText editableText1 = new EditText(this);
                editableText1.setText("Martin");
                editableText1.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
                editableText1.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

            myHorizontalLayout1.addView(disabledText1);
            myHorizontalLayout1.addView(editableText1);

            ////////******** HORIZONTAL LAYOUT 2 ********////////
            LinearLayout myHorizontalLayout2 = new LinearLayout(this);
            myHorizontalLayout2.setOrientation(LinearLayout.HORIZONTAL);
            myHorizontalLayout2.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

                //CREATION OF PASSWORD TEXT LABEL
                TextView disabledText2 = new TextView(this);
                disabledText2.setText("Lösenord");
                disabledText2.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));

                //CREATION OF PASSWORD TEXT FIELD
                EditText editableText2 = new EditText(this);
                editableText2.setText("1234567");
                editableText2.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
                editableText2.setInputType(InputType.TYPE_CLASS_TEXT |
                        InputType.TYPE_TEXT_VARIATION_PASSWORD);

            myHorizontalLayout2.addView(disabledText2);
            myHorizontalLayout2.addView(editableText2);

            ////////******** HORIZONTAL LAYOUT 3 ********////////
            LinearLayout myHorizontalLayout3 = new LinearLayout(this);
            myHorizontalLayout3.setOrientation(LinearLayout.HORIZONTAL);
            myHorizontalLayout3.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

                //CREATION OF EMAIL TEXT LABEL
                TextView disabledText3 = new TextView(this);
                disabledText3.setText("Epost");
                disabledText3.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
                disabledText3.setPadding(0,0,42,0);

                //CREATION OF EMAIL TEXT FIELD
                EditText editableText3 = new EditText(this);
                editableText3.setText("maror757@liu.se");
                editableText3.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));

            myHorizontalLayout3.addView(disabledText3);
            myHorizontalLayout3.addView(editableText3);

            ////////******** HORIZONTAL LAYOUT 4 ********////////
            LinearLayout myHorizontalLayout4 = new LinearLayout(this);
            myHorizontalLayout4.setOrientation(LinearLayout.HORIZONTAL);
            myHorizontalLayout4.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

                //CREATION OF AGE TEXT LABEL
                TextView disabledText4 = new TextView(this);
                disabledText4.setText("Ålder");
                disabledText4.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
                disabledText4.setPadding(0,0,25,0);

                //CREATION OF AGE TEXT FIELD
                SeekBar seekBar = new SeekBar(this);
                seekBar.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
                seekBar.setMax(99);
                seekBar.setProgress(25);

            myHorizontalLayout4.addView(disabledText4);
            myHorizontalLayout4.addView(seekBar);


        myVertLayout.addView(myHorizontalLayout1);
        myVertLayout.addView(myHorizontalLayout2);
        myVertLayout.addView(myHorizontalLayout3);
        myVertLayout.addView(myHorizontalLayout4);
        setContentView(myVertLayout, linLayoutParam);
        //setContentView(R.layout.activity_main);
    }
}
