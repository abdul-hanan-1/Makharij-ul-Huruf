package com.example.makharij_ul_huruf;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class quiz extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "Which of the following is produced from middle of the throat?",
            "Which of the following is produced from base of Tongue which is near Uvula touching the mouth roof",
            "Which of the following is produced by Tongue touching the center of the mouth roof",
            "Which of the following is produced from one side of the tongue touching the molar teeth",
            "Which of the following is produced from rounded tip of the tongue touching the base of the frontal 8 teeth",
            "Which of the following is produced from rounded tip of the tongue touching the base of the frontal 6 teeth",
            "Which of the following is produced from rounded tip of the tongue and some portion near it touching the base of the frontal 4 teeth",
            "Which of the following is produced from Tip of the tongue touching the base of the front 2 teeth",
            "Which of the following is produced from Tip of the tongue touching the tip of the frontal teeth",
            "Which of the following is produced from Tip of the two upper jaw teeth touches the inner part of the lower lip"
    };
    String answers[] = {"ح","ق","ج","ض","ل","ن","ر","ط","ظ","ف"};
    String opt[] = {
            "أ","غ","خ","ح",
            "ک","ق","ح","غ",
            "ج","ق","غ","ق",
            "ی","ش","ض","ج",
            "ل","ش","ج","All of the mentioned",
            "ل","ن","ش","ج",
            "ل","ش","ر","ق",
            "ر","ض","ج","ط",
            "ظ","ق","ل","غ",
            "ظ","ف","ب","م"
    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        final TextView score = (TextView)findViewById(R.id.textView4);

        submitbutton=(Button)findViewById(R.id.next);
        quitbutton=(Button)findViewById(R.id.quit);
        tv=(TextView) findViewById(R.id.question);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText(""+correct);

                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),result.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),result.class);
                startActivity(intent);
            }
        });
    }

}