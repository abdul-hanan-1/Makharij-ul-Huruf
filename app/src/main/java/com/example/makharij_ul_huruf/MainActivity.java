package com.example.makharij_ul_huruf;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
public class MainActivity extends AppCompatActivity {
    private Button button1,button2,button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.repolink);
        button2 = findViewById(R.id.learn);
        button3 = findViewById(R.id.quiz);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://github.com/abdul-hanan-1/Makharij-ul-Huruf.git");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLearn();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
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