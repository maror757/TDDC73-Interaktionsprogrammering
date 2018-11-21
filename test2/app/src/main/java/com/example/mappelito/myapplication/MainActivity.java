package com.example.mappelito.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.view.ViewGroup.LayoutParams;
import android.widget.RatingBar;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //CREATION OF TOP BUTTON
        Button myButton = new Button(this);
        myButton.setText("KNAPP");

        //CREATION OF STATIC TEXT FIELD
        EditText myText1 = new EditText(this);
        myText1.setText("Text fält");
        //valueTV.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));

        //CREATION OF RATING
        LinearLayout myRatingLayout = new LinearLayout(this);
        myRatingLayout.setOrientation(LinearLayout.HORIZONTAL);
        myRatingLayout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        myRatingLayout.setGravity(Gravity.CENTER);
        RatingBar myRatingBar = new RatingBar(this);
        LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        myRatingBar.setNumStars(5);
        myRatingBar.setLayoutParams(layoutParams);
        myRatingLayout.addView(myRatingBar);


        //CREATION OF MULTILINE TEXT FIELD
        EditText myText2 = new EditText(this);
        myText2.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
        //myText2.setSingleLine(false);
        //myText2.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_FLAG_MULTI_LINE);
        myText2.setText("ett text fält som \nklarar \nav \nflera rader\noch använder det skärmutrymmet som \n \nfinns ");



        LinearLayout myLayout = new LinearLayout(this);
        myLayout.setOrientation(LinearLayout.VERTICAL);
        LayoutParams linLayoutParam = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        myLayout.setPadding(6,0,0,0);


        //ADD BUTTON TO VERTICAL LAYOUT
        myLayout.addView(myButton);
        myLayout.addView(myText1);
        myLayout.addView(myRatingLayout);
        myLayout.addView(myText2);
        // set LinearLayout as a root element of the screen
        setContentView(myLayout, linLayoutParam);
        //setContentView(R.layout.activity_main);
    }
}
