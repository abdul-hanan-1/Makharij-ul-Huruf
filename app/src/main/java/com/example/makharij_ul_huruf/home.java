package com.example.makharij_ul_huruf;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
        Intent intent = new Intent(this, quiz.class);
        startActivity(intent);
    }
}