package com.example.mappelito.laboration1_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout myLayout = new LinearLayout(this);
        myLayout.setOrientation(LinearLayout.VERTICAL);
        myLayout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

            TextView header1 = new TextView(this);
            header1.setText("Hur trivs du på LiU");
            header1.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
            header1.setGravity(Gravity.CENTER);

            TextView header2= new TextView(this);
            header2.setText("Läser du på LiTH");
            header2.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
            header2.setGravity(Gravity.CENTER);

            TextView header3= new TextView(this);
            header3.setText("Är detta LiUs logotyp");
            header3.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
            header3.setGravity(Gravity.CENTER);

            LinearLayout hzntlLayout1 = new LinearLayout(this);
            hzntlLayout1.setOrientation(LinearLayout.HORIZONTAL);
            hzntlLayout1.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

                CheckBox hznt1box1 = new CheckBox(this);
                hznt1box1.setText("Bra");
                hznt1box1.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
                CheckBox hznt1box2 = new CheckBox(this);
                hznt1box2.setText("Mycket Bra");
                hznt1box2.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
                CheckBox hznt1box3 = new CheckBox(this);
                hznt1box3.setText("Jättebra");
                hznt1box3.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
                hznt1box3.setChecked(true);

            hzntlLayout1.addView(hznt1box1);
            hzntlLayout1.addView(hznt1box2);
            hzntlLayout1.addView(hznt1box3);

            LinearLayout hzntlLayout2 = new LinearLayout(this);
            hzntlLayout2.setOrientation(LinearLayout.HORIZONTAL);
            hzntlLayout2.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

                CheckBox hznt2box1 = new CheckBox(this);
                hznt2box1.setText("Ja");
                hznt2box1.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
                CheckBox hznt2box2 = new CheckBox(this);
                hznt2box2.setText("Nej");
                hznt2box2.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
                hznt2box2.setChecked(true);


                hzntlLayout2.addView(hznt2box1);
                hzntlLayout2.addView(hznt2box2);

            LinearLayout hzntlLayout3 = new LinearLayout(this);
            hzntlLayout3.setOrientation(LinearLayout.HORIZONTAL);
            hzntlLayout3.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

                CheckBox hznt3box1 = new CheckBox(this);
                hznt3box1.setText("Ja");
                hznt3box1.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
                hznt3box1.setChecked(true);
                CheckBox hznt3box2 = new CheckBox(this);
                hznt3box2.setText("Nej");
                hznt3box2.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

            hzntlLayout3.addView(hznt3box1);
            hzntlLayout3.addView(hznt3box2);


            LinearLayout imgLayout = new LinearLayout(this);
            imgLayout.setOrientation(LinearLayout.HORIZONTAL);
            imgLayout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
            imgLayout.setGravity(Gravity.CENTER);

                ImageView img1 = new ImageView(this);
                img1.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
                img1.setBackgroundResource(R.drawable.liulogga);

            imgLayout.addView(img1);


        myLayout.addView(header1);
        myLayout.addView(hzntlLayout1);
        myLayout.addView(header2);
        myLayout.addView(hzntlLayout2);
        myLayout.addView(header3);
        myLayout.addView(imgLayout);
        myLayout.addView(hzntlLayout3);
        setContentView(myLayout);
        //setContentView(R.layout.activity_main);
    }
}
