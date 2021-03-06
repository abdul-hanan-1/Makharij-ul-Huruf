package com.example.makharij_ul_huruf;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class result extends AppCompatActivity {
    TextView tv, tv2, tv3;
    Button btnRestart, btnShare,home;
    int sharescore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        tv = (TextView)findViewById(R.id.correct);
        tv2 = (TextView)findViewById(R.id.wrong);
        tv3 = (TextView)findViewById(R.id.finalscore);
        btnRestart = (Button) findViewById(R.id.btnRestart);
        btnShare = (Button) findViewById(R.id.share);
        home= (Button) findViewById(R.id.home);

        StringBuffer sb = new StringBuffer();
        sb.append("Correct answers: " + quiz.correct + "\n");
        StringBuffer sb2 = new StringBuffer();
        sb2.append("Wrong Answers: " + quiz.wrong + "\n");
        StringBuffer sb3 = new StringBuffer();
        sb3.append("Final Score: " + quiz.correct + "\n");
        tv.setText(sb);
        tv2.setText(sb2);
        tv3.setText(sb3);
        sharescore = quiz.correct;
        quiz.correct=0;
        quiz.wrong=0;

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),quiz.class);
                startActivity(in);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),home.class);
                startActivity(in);
            }
        });
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Yayy! I scored "+sharescore+"/10 in Makharij-ul-Huruf quiz.");
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }
        });

    }

    public void onBackPressed() {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(),"No Settings Available!", Toast.LENGTH_LONG).show();
                break;
            case R.id.action_learn:
                Intent intent = new Intent(this, learn.class);
                startActivity(intent);
                break;
            case R.id.action_help:
                Toast.makeText(getApplicationContext(),"Ask help from Allah only.", Toast.LENGTH_LONG).show();
                break;
            default:
// If we got here, the user's action was not recognized.
// Invoke the superclass to handle it.

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("correct",tv.getText().toString());
        outState.putString("wrong",tv2.getText().toString());
        outState.putString("finalscore",tv3.getText().toString());
        outState.putInt("sharescore",sharescore);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        tv.setText(savedInstanceState.getString("correct"));
        tv2.setText(savedInstanceState.getString("wrong"));
        tv3.setText(savedInstanceState.getString("finalscore"));
        sharescore = savedInstanceState.getInt("sharescore");

    }
}

