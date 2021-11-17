package com.example.makharij_ul_huruf;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class home extends AppCompatActivity {
    private Button button1,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        button1 = findViewById(R.id.learn);
        button2 = findViewById(R.id.quiz);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLearn();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openQuiz();
            }
        });
    }
    public void openLearn(){
        Intent intent = new Intent(this, learn.class);
        startActivity(intent);
    }
    public void openQuiz(){
        AlertDialog.Builder builder = new AlertDialog.Builder(home.this);
        builder.setMessage("The quiz contains 10 questions and you have 5 minutes to complete it.");
        builder.setTitle("Start Quiz");
        builder.setCancelable(false);
        builder.setPositiveButton(
                "Attempt Quiz",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int asdf)
                    {
                        Intent intent = new Intent(home.this, quiz.class);
                        startActivity(intent);
                    }
                });
        builder.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int asdf)
            {
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}